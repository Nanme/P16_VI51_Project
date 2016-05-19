package fr.utbm.vi51.prj.drone.ia.evt;

import java.util.UUID;

import fr.utbm.vi51.prj.drone.framework.math.MathUtil;
import fr.utbm.vi51.prj.drone.framework.math.Rectangle2f;
import fr.utbm.vi51.prj.drone.framework.math.Shape2f;
import fr.utbm.vi51.prj.drone.framework.math.Vector2f;
import fr.utbm.vi51.prj.drone.framework.time.TimeManager;
import fr.utbm.vi51.prj.drone.framework.util.LocalizedString;


public abstract class AbstractMobileObject extends AbstractSituatedObject implements MobileObject {

	private static final long serialVersionUID = -2670464828720893140L;
	
	private final float maxLinearAcceleration;
	private final float maxAngularAcceleration;
	
	private float angle = 0;
	private float currentAngularSpeed = 0;
	private Vector2f linearMove = new Vector2f();

	/**
	 * @param id the identifier of the object.
	 * @param shape the shape of the body, considering that it is centered at the (0,0) position.
	 * @param maxLinearAcceleration is the maximal linear acceleration.
	 * @param maxAngularAcceleration is the maximal angular acceleration.
	 */
	public AbstractMobileObject(UUID id, Shape2f<?> shape, float maxLinearAcceleration, float maxAngularAcceleration) {
		super(id, shape);
		this.maxLinearAcceleration = Math.abs(maxLinearAcceleration);
		this.maxAngularAcceleration = Math.abs(maxAngularAcceleration);
	}
	
	@Override
	public AbstractMobileObject clone() {
		AbstractMobileObject clone = (AbstractMobileObject) super.clone();
		clone.linearMove = this.linearMove.clone();
		return clone;
	}

	/** {@inheritDoc}
	 */
	public float getAngle() {
		return this.angle;
	}
	
	/** {@inheritDoc}
	 */
	public Vector2f getDirection() {
		return Vector2f.toOrientationVector(this.angle);
	}

	/** Set the orientation of the object.
	 * 
	 * @param angle
	 */
	public void setAngle(float angle) {
		this.angle = angle;
		this.currentAngularSpeed = 0;
	}

	/** Set the direction of the object.
	 * 
	 * @param dx
	 * @param dy
	 */
	protected void setDirection(float dx, float dy) {
		this.angle = new Vector2f(dx, dy).getOrientationAngle();
		this.currentAngularSpeed = 0;
	}

	/** {@inheritDoc}
	 */
	public float getMaxLinearAcceleration() {
		return this.maxLinearAcceleration;
	}

	/** {@inheritDoc}
	 */
	public float getMaxAngularAcceleration() {
		return this.maxAngularAcceleration;
	}
	
	/** {@inheritDoc}
	 */
	public float getCurrentAngularSpeed() {
		return this.currentAngularSpeed;
	}

	/** {@inheritDoc}
	 */
	public float getCurrentLinearSpeed() {
		return this.linearMove.getLength();
	}

	/** {@inheritDoc}
	 */
	public Vector2f getCurrentLinearMotion() {
		return new Vector2f(this.linearMove);
	}

	/** Rotate the object.
	 * 
	 * @param rotation is the real instant motion. 
	 * @param simulationDuration is the time during which the motion is applied.
	 */
	public void rotate(float rotation, float simulationDuration) {
		if (Double.isNaN(rotation)) {
			System.err.println(LocalizedString.getString(getClass(), "INVALID_ROTATION", getName()));
		} else if (Double.isNaN(simulationDuration)) {
			System.err.println(LocalizedString.getString(getClass(), "INVALID_DURATION", getName()));
		} else {
			this.angle += rotation;
			this.currentAngularSpeed = rotation / simulationDuration;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setPosition(float x, float y) {
		super.setPosition(x, y);
		this.linearMove.set(0,0);
	}

	/** Move the situated object.
	 * 
	 * @param dx is the real instant motion. 
	 * @param dy is the real instant motion.
	 * @param simulationDuration is the time during which the motion is applied.
	 * @param worldWidth is the width of the world.
	 * @param worldHeight is the height of the world.
	 * @return the real motion.
	 */
	public Vector2f move(float dx, float dy, float simulationDuration, float worldWidth, float worldHeight) {
		// Ensure that the motion in inside the bounds of the world.
		Vector2f r = new Vector2f(dx, dy);
		Shape2f<?> currentShape = getShape();
		Shape2f<?> targetShape = currentShape.translate(r);
		Rectangle2f targetBounds = targetShape.getBounds();

		if (targetBounds.getLower().getX() < 0) {
			float exceedingAmount = - targetBounds.getLower().getX();
			r.addX(exceedingAmount);
		} else if (targetBounds.getUpper().getX() > worldWidth) {
			float exceedingAmount = targetBounds.getUpper().getX() - worldWidth;
			r.subX(exceedingAmount);
		}
		
		if (targetBounds.getLower().getY() < 0) {
			float exceedingAmount = - targetBounds.getLower().getY();
			r.addY(exceedingAmount);
		} else if (targetBounds.getUpper().getY() > worldHeight) {
			float exceedingAmount = targetBounds.getUpper().getY() - worldHeight;
			r.subY(exceedingAmount);
		}

		// Update the position
		addPosition(r.getX(), r.getY());
		
		// Update dynamic properties
		if (simulationDuration>0) {
			this.linearMove.set(r.getX(), r.getY());
			float distance = this.linearMove.getLength();
			if (distance>0) {
				this.linearMove.normalize();
				this.linearMove.scale(distance/simulationDuration);
			}
		}
		else {
			this.linearMove.set(0,0);
		}

		return r;
	}

	/** Compute a steering move according to the linear move and to
	 * the internal attributes of this object.
	 * 
	 * @param move is the requested motion, expressed with acceleration.
	 * @param clock is the simulation time manager
	 * @return the linear instant motion.
	 */
	public Vector2f computeSteeringTranslation(Vector2f move, TimeManager clock) {
		float length = move.getLength();

		Vector2f v;
		
		if (length != 0f) {
			// Clamp acceleration
			float acceleration = MathUtil.clamp(
					(move.dot(this.linearMove) < 0f) ? -length : length, 
					-getMaxLinearAcceleration(), 
					getMaxLinearAcceleration());
			
			// Apply Newton law, first part (from acceleration to speed)
			acceleration = Math.abs(acceleration) / length;
			v = move.operator_multiply(acceleration);
			
			v.scale(.5f * clock.getLastStepDuration());
			v = this.linearMove.operator_plus(v);
		}
		else {
			v = this.linearMove.clone();
		}
		
		// v is a speed - unit: [m/s]
		
		length = (float) Math.sqrt(v.getX() * v.getX() + v.getY() * v.getY());
		if (length != 0f) {
			// Clamp the speed
			float speed = MathUtil.clamp(
					(v.dot(this.linearMove) < 0f) ? -length : length, 
					0f, 
					getMaxLinearAcceleration());

			// Compute the Newton law, part 2 (from speed to distance)
			float factor = clock.getLastStepDuration() * Math.abs(speed) / length;
		
			return v.operator_multiply(factor);
		}
		
		return new Vector2f();
	}

	/** Compute a steering move according to the angular move and to
	 * the internal attributes of this object.
	 * 
	 * @param move is the requested motion.
	 * @param clock is the simulation time manager
	 * @return the angular instant motion.
	 */
	public float computeSteeringRotation(float move, TimeManager clock) {
		float v;
		
		if (move != 0f) {
			// Clamp acceleration
			float acceleration = MathUtil.clamp(
					move, 
					-getMaxAngularAcceleration(), 
					getMaxAngularAcceleration());
			
			// Apply Newton law, first part (from acceleration to speed)
			acceleration = Math.abs(acceleration) / Math.abs(move);
			v = move * acceleration;
			v *= .5f * clock.getLastStepDuration();
			v += this.currentAngularSpeed;
		}
		else {
			v = this.currentAngularSpeed;
		}
		
		// v is a speed - unit: [m/s]
		
		if (v != 0f) {
			// Clamp the speed
			float speed = MathUtil.clamp(
					v, 
					-getMaxAngularAcceleration(), 
					getMaxAngularAcceleration());

			// Compute the Newton law, part 2 (from speed to distance)
			float factor = clock.getLastStepDuration() * Math.abs(speed) / Math.abs(v);
		
			return v * factor;
		}
		
		return 0f;
	}
}

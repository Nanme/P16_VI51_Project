package fr.utbm.vi51.prj.drone.ia.evt;

import java.io.Serializable;
import java.util.UUID;

import com.google.common.base.Objects;

import fr.utbm.vi51.prj.drone.framework.math.Point2f;
import fr.utbm.vi51.prj.drone.framework.math.Shape2f;
import fr.utbm.vi51.prj.drone.framework.math.Vector2f;

public class Perception implements MobileObject, Serializable {

	private static final long serialVersionUID = -6553882246151660857L;

	private final UUID bodyId;
	private final UUID objectId;
	private Shape2f<?> shape;
	private Point2f position;
	private final float angle;
	private final Serializable type;
	private final float maxLinearSpeed;
	private final float maxLinearAcceleration;
	private Vector2f currentLinearMotion;
	private final float maxAngularSpeed;
	private final float maxAngularAcceleration;
	private final float currentAngularSpeed;
	private final String name;
	
	/**
	 * @param perceivedObject is the perceived object.
	 */
	public Perception(SituatedObject perceivedObject) {
		this(perceivedObject, null);
	}
	
	/**
	 * @param perceivedObject is the perceived object.
	 * @param type the type of the object.
	 */
	public Perception(SituatedObject perceivedObject, Serializable type) {
		this.objectId = perceivedObject.getID();
		this.name = perceivedObject.getName();
		this.shape = perceivedObject.getShape();
		this.position = perceivedObject.getPosition().clone();
		if (type == null) {
			type = perceivedObject.getType();
			if (type == null) {
				type = perceivedObject.getClass().getName();
			}
		}
		this.type = type;
		if (perceivedObject instanceof MobileObject) {
			MobileObject mo = (MobileObject) perceivedObject;
			this.angle = mo.getAngle();
			this.maxAngularAcceleration = mo.getMaxAngularAcceleration();
			this.maxAngularSpeed = mo.getMaxAngularSpeed();
			this.maxLinearAcceleration = mo.getMaxLinearAcceleration();
			this.maxLinearSpeed = mo.getMaxLinearSpeed();
			this.currentAngularSpeed = mo.getCurrentAngularSpeed();
			this.currentLinearMotion = mo.getCurrentLinearMotion().clone();
		} else {
			this.angle = 0f;
			this.maxAngularAcceleration = 0f;
			this.maxAngularSpeed = 0f;
			this.maxLinearAcceleration = 0f;
			this.maxLinearSpeed = 0f;
			this.currentAngularSpeed = 0f;
			this.currentLinearMotion = null;
		}
		if (perceivedObject instanceof AgentBody) {
			this.bodyId = ((AgentBody) perceivedObject).getID();
		} else {
			this.bodyId = null;
		}
	}
	
	@Override
	public Perception clone() {
		try {
			Perception clone = (Perception) super.clone();
			clone.currentLinearMotion = this.currentLinearMotion.clone();
			clone.position = this.position.clone();
			clone.shape = this.shape.clone();
			return clone;
		} catch (CloneNotSupportedException e) {
			throw new Error(e);
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Perception) {
			Perception p = (Perception) obj;
			return this.bodyId.equals(p.bodyId)
				&& Objects.equal(this.objectId, p.objectId);
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		int h = 1;
		h = 31 * h + this.bodyId.hashCode();
		h = 31 * h + this.objectId.hashCode();
		return h;
	}
	
	@Override
	public int compareTo(SituatedObject o) {
		if (o instanceof Perception) {
			int c = this.bodyId.compareTo(((Perception) o).getBodyID());
			if (c != 0) {
				return c;
			}
			return this.objectId.compareTo(o.getID());
		}
		return Integer.MAX_VALUE;
	}

	/** Replies the id of the body.
	 *
	 * @return the id of the body.
	 */
	public UUID getBodyID() {
		return this.bodyId;
	}

	/** Replies the id of the body.
	 *
	 * @return the id of the body.
	 */
	public UUID getID() {
		return this.objectId;
	}

	@Override
	public Shape2f<?> getShape() {
		return this.shape;
	}

	@Override
	public float getX() {
		return this.position.getX();
	}

	@Override
	public float getY() {
		return this.position.getY();
	}

	@Override
	public Point2f getPosition() {
		return this.position;
	}

	@Override
	public float getAngle() {
		return this.angle;
	}

	@Override
	public Vector2f getDirection() {
		return Vector2f.toOrientationVector(this.angle);
	}

	@Override
	public float getMaxLinearSpeed() {
		return this.maxLinearSpeed;
	}

	@Override
	public float getMaxAngularSpeed() {
		return this.maxAngularSpeed;
	}

	@Override
	public float getMaxLinearAcceleration() {
		return this.maxLinearAcceleration;
	}

	@Override
	public float getMaxAngularAcceleration() {
		return this.maxAngularAcceleration;
	}

	@Override
	public float getCurrentAngularSpeed() {
		return this.currentAngularSpeed;
	}

	@Override
	public float getCurrentLinearSpeed() {
		if (this.currentLinearMotion == null) {
			return 0;
		}
		return this.currentLinearMotion.getLength();
	}

	@Override
	public Vector2f getCurrentLinearMotion() {
		if (this.currentLinearMotion == null) {
			return new Vector2f();
		}
		return this.currentLinearMotion;
	}

	@Override
	public Serializable getType() {
		return this.type;
	}

	@Override
	public String getName() {
		return this.name;
	}
	
	@Override
	public String toString() {
		if (this.name != null) {
			return this.name;
		}
		return super.toString();
	}
		
}

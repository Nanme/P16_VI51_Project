package fr.utbm.vi51.prj.drone.ia.agt;

import java.io.Serializable;

import fr.utbm.vi51.prj.drone.ia.evt.DynamicType;
import fr.utbm.vi51.prj.drone.framework.math.Vector2f;

public class BehaviorOutput implements Serializable {

	private static final long serialVersionUID = 1243172129345360316L;

	private final DynamicType type;
	private final Vector2f linear = new Vector2f();
	private float angular = 0;
	
	/**
	 * @param type is the type of the output.
	 */
	public BehaviorOutput(DynamicType type) {
		this.type = type;
	}
	
	/**
	 * @param outputToCopy is the output tp copy.
	 */
	public BehaviorOutput(BehaviorOutput outputToCopy) {
		assert(outputToCopy!=null);
		this.type = outputToCopy.getType();
		this.linear.set(outputToCopy.getLinear());
		this.angular = outputToCopy.getAngular();
	}

	/** Replies the type of the output.
	 * 
	 * @return the type of the output.
	 */
	public DynamicType getType() {
		return this.type;
	}
	
	/** Replies the linear output.
	 * 
	 * @return the linear output.
	 */
	public Vector2f getLinear() {
		return this.linear;
	}
	
	/** Replies the angular output.
	 * 
	 * @return the angular output.
	 */
	public float getAngular() {
		return this.angular;
	}
	
	/** Set the linear output.
	 * 
	 * @param linear
	 */
	public void setLinear(Vector2f linear) {
		assert(linear!=null);
		this.linear.set(linear);
	}
	
	/** Set the linear output.
	 * 
	 * @param dx
	 * @param dy
	 */
	public void setLinear(float dx, float dy) {
		this.linear.set(dx, dy);
	}

	/** Set the angular output.
	 * 
	 * @param angular
	 */
	public void setAngular(float angular) {
		this.angular = angular;
	}

	/** Set the linear output.
	 * 
	 * @param outputToCopy
	 */
	public void setLinear(BehaviorOutput outputToCopy) {
		if (outputToCopy!=null) {
			if (outputToCopy.getType()!=getType()) {
				throw new IllegalArgumentException();
			}
			this.linear.set(outputToCopy.getLinear());
		}
	}

	/** Set the angular output.
	 * 
	 * @param outputToCopy
	 */
	public void setAngular(BehaviorOutput outputToCopy) {
		if (outputToCopy!=null) {
			if (outputToCopy.getType()!=getType()) {
				throw new IllegalArgumentException();
			}
			this.angular = outputToCopy.getAngular();
		}
	}

	/** Set the linear and angular output.
	 * 
	 * @param outputToCopy
	 */
	public void set(BehaviorOutput outputToCopy) {
		if (outputToCopy!=null) {
			if (outputToCopy.getType()!=getType()) {
				throw new IllegalArgumentException();
			}
			this.linear.set(outputToCopy.getLinear());
			this.angular = outputToCopy.getAngular();
		}
	}
	
	@Override
	public String toString() {
		return "l=" + this.linear.toString() + "; a=" + this.angular;
	}

}
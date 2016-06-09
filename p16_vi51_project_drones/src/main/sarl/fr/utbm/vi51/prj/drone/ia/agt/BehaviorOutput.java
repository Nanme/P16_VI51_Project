package fr.utbm.vi51.prj.drone.ia.agt;

import java.io.Serializable;
import java.util.UUID;

import fr.utbm.vi51.prj.drone.framework.math.Vector2f;
import fr.utbm.vi51.prj.drone.ia.behavior.DynamicType;
import io.sarl.lang.core.Address;

public class BehaviorOutput implements Serializable {

	private static final long serialVersionUID = 1243172129345360316L;

	private DynamicType type;
	private Vector2f linear = new Vector2f();
	private float angular = 0;
	private UUID id;
	
	/**
	 * @param type is the type of the output.
	 */
	public BehaviorOutput(DynamicType type) {
		this.type = type;
	}
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	/**
	 * @param outputToCopy is the output tp copy.
	 */
	public BehaviorOutput(BehaviorOutput outputToCopy) {
		assert(outputToCopy!=null);
		this.type = outputToCopy.getType();
		this.linear.set(outputToCopy.getLinear());
		this.angular = outputToCopy.getAngular();
		this.id = outputToCopy.getId();
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

	BehaviorOutput(UUID address, Vector2f linear, DynamicType string) {
		this.type = string;
		this.linear=linear;
		this.id = address;
	}
	
	BehaviorOutput(UUID address, float angular, DynamicType string) {
		this.type = string;
		this.angular=angular;
		this.id = address;
	}

	BehaviorOutput(UUID address, Vector2f linear, float angular, DynamicType string) {
		this.type = string;
		this.linear=linear;
		this.angular=angular;
		this.id = address;
	}

}
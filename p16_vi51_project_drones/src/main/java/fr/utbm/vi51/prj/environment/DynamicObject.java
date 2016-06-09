package fr.utbm.vi51.prj.environment;

import java.util.UUID;

import fr.utbm.vi51.prj.drone.DroneDisplay;
import fr.utbm.vi51.prj.drone.framework.math.Vector2f;

public class DynamicObject extends EnvironmentObject{
	
	private float maxLinearAcceleration = 10;
	private float maxAngularSpeed = 10;
	private float currentAngular = 10;
		/**
	 * creation of object with a circle shape
	 * @param x
	 * @param y
	 * @param radius
	 * @param agentId
	 * @param w
	 */
	public DynamicObject(float x, float y,float z, float radius,UUID agentId/*,EnvMap map*/){
		super(agentId, new DroneDisplay(radius, (float)Math.random(), (float)Math.random(), (float)Math.random(), x, y, z, 30));
		this.width=radius*2;
		this.height=radius*2;
	}
	
	
	public float getAngle() {
		return body.getAngle();
	}
	public float getMaxLinearAcceleration() {
		return maxLinearAcceleration;
	}
	public Vector2f getCurrentLinearMotion() {
		return new Vector2f(body.getLinearVelocity());
	}
	public float getMaxAngularSpeed() {
		return maxAngularSpeed;
	}
	public float getCurrentAngularSpeed() {
		return body.getAngularVelocity();
	}
	public Vector2f getLinearVelocity(){
		return body.getLinearVelocity();
	}

	

}
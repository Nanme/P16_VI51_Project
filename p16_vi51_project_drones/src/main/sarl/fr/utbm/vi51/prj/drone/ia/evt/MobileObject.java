package fr.utbm.vi51.prj.drone.ia.evt;

import fr.utbm.vi51.prj.drone.framework.math.Vector2f;

public interface MobileObject extends SituatedObject {

	/** Replies the orientation of the object.
	 * 
	 * @return the angle of orientation from (1,0).
	 */
	float getAngle();
	
	/** Replies the orientation of the object.
	 * 
	 * @return the orientation direction.
	 */
	Vector2f getDirection();
	
	/** Replies the max linear speed.
	 * 
	 * @return the max linear speed.
	 */
	float getMaxLinearSpeed();

	/** Replies the max angular speed.
	 * 
	 * @return the max angular speed.
	 */
	float getMaxAngularSpeed();

	/** Replies the max linear acceleration.
	 * 
	 * @return the max linear acceleration.
	 */
	float getMaxLinearAcceleration();

	/** Replies the max angular acceleration.
	 * 
	 * @return the max angular acceleration.
	 */
	float getMaxAngularAcceleration();
	
	/** Replies the current angular speed.
	 * 
	 * @return the current angular speed.
	 */
	float getCurrentAngularSpeed();

	/** Replies the current linear speed.
	 * 
	 * @return the current linear speed.
	 */
	float getCurrentLinearSpeed();

	/** Replies the current linear motion.
	 * 
	 * @return the current linear motion.
	 */
	Vector2f getCurrentLinearMotion();

}

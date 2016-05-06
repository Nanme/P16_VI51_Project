package fr.utbm.vi51.prj.drone.ia.evt;

import java.io.Serializable;
import java.util.UUID;

import fr.utbm.vi51.prj.drone.framework.math.Point2f;


public interface SituatedObject extends ShapedObject, Cloneable, Comparable<SituatedObject> {

	/** Clone the object.
	 *
	 * @return the clone.
	 */
	SituatedObject clone();
	
	/** Replies the type of the object.
	 * 
	 * @return the type of the object.
	 */
	Serializable getType();
	
	/** Replies the identifier of the object.
	 * 
	 * @return the identifier of the object.
	 */
	UUID getID();

	/** Replies the name of the object.
	 *
	 * The name is defined only for displaying purpose.
	 * 
	 * @return the name of the object.
	 */
	String getName();

	/** Replies the position of the object.
	 * 
	 * @return the x-coordinate of the position of this object.
	 */
	float getX();
	
	/** Replies the position of the object.
	 * 
	 * @return the y-coordinate of the position of this object.
	 */
	float getY();

	/** Replies the position of the object.
	 * 
	 * @return the position of the object.
	 */
	Point2f getPosition();
	
}
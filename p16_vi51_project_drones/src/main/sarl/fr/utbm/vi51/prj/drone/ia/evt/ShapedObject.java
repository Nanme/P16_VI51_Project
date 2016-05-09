package fr.utbm.vi51.prj.drone.ia.evt;

import fr.utbm.vi51.prj.drone.framework.math.Shape2f;

public interface ShapedObject {

	/** Replies the 2D shape that is representing the object.
	 * The coordinates of the replied shape depends on the current
	 * position of the object.
	 * 
	 * @return the shape of this object.
	 */
	Shape2f<?> getShape();
	
}

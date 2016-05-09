package fr.utbm.vi51.prj.drone.ia.evt;

import java.io.Serializable;
import java.util.Iterator;
import java.util.UUID;

import fr.utbm.vi51.prj.drone.framework.math.Point2f;
import fr.utbm.vi51.prj.drone.framework.math.Shape2f;
import fr.utbm.vi51.prj.drone.framework.math.Vector2f;



public interface Frustum extends Serializable, Cloneable {

	/** Replies the identifier of the owner of this frustum.
	 *
	 * @return the identifier of the frustum's owner.
	 */
	UUID getOwner();
	
	/** Replies a shape that is representing this frustum.
	 *
	 * @param position the position of the owner of the frustum.
	 * @param orientation the orientation of the owner of the frustum.
	 * @return the shape.
	 */
	Shape2f<?> toShape(Point2f position, Vector2f orientation);
	
	/** Create a filtering iterator.
	 * The replied iterator may filtering the objects of the given iterator.
	 *
	 * @param iterator the original iterator.
	 * @return the filtering iterator, or the given <code>iterator</code> if
	 * there is no filtering.
	 */
	<D extends SituatedObject> Iterator<D> filter(Iterator<D> iterator);
	
}
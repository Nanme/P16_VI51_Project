package fr.utbm.vi51.prj.drone.ia.evt;

import java.util.List;
import java.util.UUID;

import fr.utbm.vi51.prj.drone.framework.math.Vector2f;

public interface Body {

	/** Replies the id of this body.
	 * 
	 * @return the id of this body.
	 */
	UUID getID();

	/** Invoked to send the influence to the environment.
	 * 
	 * @param linearInfluence is the linear influence to apply on the object.
	 * @param angularInfluence is the angular influence to apply on the object.
	 */
	void influenceSteering(Vector2f linearInfluence, float angularInfluence);

	/** Invoked to send the influence to the environment.
	 * 
	 * @param linearInfluence is the linear influence to apply on the object.
	 */
	void influenceSteering(Vector2f linearInfluence);

	/** Invoked to send the influence to the environment.
	 * 
	 * @param angularInfluence is the angular influence to apply on the object.
	 */
	void influenceSteering(float angularInfluence);
	
	/** Replies all the perceived objects.
	 * 
	 * @return the perceived objects.
	 */
	List<Perception> getPerceivedObjects();

}
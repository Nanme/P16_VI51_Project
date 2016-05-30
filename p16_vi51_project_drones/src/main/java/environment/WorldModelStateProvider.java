package environment;

import fr.utbm.vi51.prj.drone.framework.math.Point2f;


/**
 * State provider for the world model.  
 * 
 * @author St&eacute;phane GALLAND &lt;stephane.galland@utbm.fr&gt;
 * @version $Name$ $Revision$ $Date$
 */
public interface WorldModelStateProvider {

	/** Replies the width of the environment.
	 * 
	 * @return the width of the environment.
	 */
	public float getWidth();
	
	/** Replies the height of the environment.
	 * 
	 * @return the height of the environment.
	 */
	public float getHeight();
	
	/** Replies the state of the world model.
	 * 
	 * @return the state of the world model.
	 */
	public WorldModelState getState();

}
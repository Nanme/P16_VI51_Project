package fr.utbm.vi51.prj.drone.ia.behavior;

import fr.utbm.vi51.prj.drone.ia.agt.BehaviorOutput;
import fr.utbm.vi51.prj.drone.ia.evt.Perception;
import fr.utbm.vi51.prj.drone.framework.math.Point2f;

public interface MotionBehavior {
	/**
	 * @param position is the current position of the entity.
	 * @param linearSpeed is the current linear speed of the entity.
	 * @param maxLinear is the maximal linear speed or acceleration (depending on getType()) of the entity.
	 * @param target is the point to reach.
	 * @return the behaviour output.
	 */
	public BehaviorOutput runMotion(Perception perception, float acceleration, Point2f target);
	

}

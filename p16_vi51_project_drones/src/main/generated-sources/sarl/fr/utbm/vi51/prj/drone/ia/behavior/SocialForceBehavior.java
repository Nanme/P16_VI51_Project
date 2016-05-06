package fr.utbm.vi51.prj.drone.ia.behavior;

import fr.utbm.vi51.prj.drone.framework.math.Point2f;
import fr.utbm.vi51.prj.drone.framework.math.Vector2f;
import fr.utbm.vi51.prj.drone.ia.agt.BehaviorOutput;
import fr.utbm.vi51.prj.drone.ia.behavior.MotionBehavior;
import fr.utbm.vi51.prj.drone.ia.evt.DynamicType;
import fr.utbm.vi51.prj.drone.ia.evt.Perception;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author Lana Banana
 * 
 * Social Force Behavior STEERING mode
 */
@SuppressWarnings("all")
public class SocialForceBehavior implements MotionBehavior {
  @Override
  public BehaviorOutput runMotion(final Perception perception, final float acceleration, final Point2f target) {
    Vector2f repulsiveForce = null;
    BehaviorOutput _behaviorOutput = new BehaviorOutput(DynamicType.STEERING);
    final Procedure1<BehaviorOutput> _function = (BehaviorOutput it) -> {
      Vector2f _vector2f = new Vector2f(0, 0);
      it.setLinear(_vector2f);
    };
    return ObjectExtensions.<BehaviorOutput>operator_doubleArrow(_behaviorOutput, _function);
  }
}

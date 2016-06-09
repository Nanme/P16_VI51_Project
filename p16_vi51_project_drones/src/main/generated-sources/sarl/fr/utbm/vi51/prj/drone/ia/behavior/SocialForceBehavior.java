package fr.utbm.vi51.prj.drone.ia.behavior;

import fr.utbm.vi51.prj.drone.framework.math.Point2f;
import fr.utbm.vi51.prj.drone.framework.math.Vector2f;
import fr.utbm.vi51.prj.drone.ia.agt.BehaviorOutput;
import fr.utbm.vi51.prj.drone.ia.agt.Perception;
import fr.utbm.vi51.prj.drone.ia.agt.drone;
import fr.utbm.vi51.prj.drone.ia.behavior.DynamicType;
import fr.utbm.vi51.prj.drone.ia.behavior.MotionBehavior;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Lana Banana
 * 
 * Social Force Behavior STEERING mode
 */
@SuppressWarnings("all")
public class SocialForceBehavior implements MotionBehavior {
  private final drone agt;
  
  public SocialForceBehavior(final drone agt) {
    this.agt = agt;
  }
  
  @Pure
  public Point2f getNearestPoint(final float cx, final float cy, final float cz, final float cradius, final float ax, final float ay, final float az) {
    Vector2f a = new Vector2f((ax - cx), (ay - cy));
    float _lengthSquared = a.lengthSquared();
    boolean _lessEqualsThan = (_lengthSquared <= (cradius * cradius));
    if (_lessEqualsThan) {
      return new Point2f(ax, ay);
    }
    a.setLength(cradius);
    float _x = a.getX();
    float _plus = (_x + ax);
    float _y = a.getY();
    float _plus_1 = (_y + ay);
    return new Point2f(_plus, _plus_1);
  }
  
  @Override
  public BehaviorOutput runMotion(final Perception perception, final float acceleration, final Point2f target) {
    BehaviorOutput _behaviorOutput = new BehaviorOutput(DynamicType.STEERING);
    final Procedure1<BehaviorOutput> _function = (BehaviorOutput it) -> {
      Vector2f _vector2f = new Vector2f(0, 0);
      it.setLinear(_vector2f);
    };
    return ObjectExtensions.<BehaviorOutput>operator_doubleArrow(_behaviorOutput, _function);
  }
}

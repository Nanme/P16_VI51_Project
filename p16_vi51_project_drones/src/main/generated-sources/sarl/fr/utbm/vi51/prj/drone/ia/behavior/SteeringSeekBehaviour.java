package fr.utbm.vi51.prj.drone.ia.behavior;

import fr.utbm.vi51.prj.drone.framework.math.Point2f;
import fr.utbm.vi51.prj.drone.framework.math.Vector2f;
import fr.utbm.vi51.prj.drone.ia.agt.BehaviorOutput;
import fr.utbm.vi51.prj.drone.ia.behavior.DynamicType;
import fr.utbm.vi51.prj.drone.ia.behavior.SeekBehaviour;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class SteeringSeekBehaviour implements SeekBehaviour {
  @Override
  public BehaviorOutput runSeek(final Point2f position, final float linearSpeed, final float maxLinear, final Point2f target) {
    final Vector2f direction = target.operator_minus(position);
    direction.setLength(maxLinear);
    BehaviorOutput _behaviorOutput = new BehaviorOutput(DynamicType.STEERING);
    final Procedure1<BehaviorOutput> _function = (BehaviorOutput it) -> {
      it.setLinear(direction);
    };
    return ObjectExtensions.<BehaviorOutput>operator_doubleArrow(_behaviorOutput, _function);
  }
}

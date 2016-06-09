package fr.utbm.vi51.prj.drone.ia.behavior;

import fr.utbm.vi51.prj.drone.framework.math.Vector2f;
import fr.utbm.vi51.prj.drone.ia.agt.BehaviorOutput;
import fr.utbm.vi51.prj.drone.ia.behavior.AlignBehaviour;
import fr.utbm.vi51.prj.drone.ia.behavior.DynamicType;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class SteeringAlignBehaviour implements AlignBehaviour {
  private final float stopAngle;
  
  private final float decelerateAngle;
  
  private final float timeToReachTarget;
  
  public SteeringAlignBehaviour(final float stopAngle, final float decelerateAngle, final float timeToReachTarget) {
    this.stopAngle = stopAngle;
    this.decelerateAngle = decelerateAngle;
    this.timeToReachTarget = timeToReachTarget;
  }
  
  @Override
  public BehaviorOutput runAlign(final Vector2f orientation, final float angularSpeed, final float maxAngular, final Vector2f target) {
    final float sAngle = orientation.signedAngle(target);
    final float angle = Math.abs(sAngle);
    if ((angle <= this.stopAngle)) {
      BehaviorOutput _behaviorOutput = new BehaviorOutput(DynamicType.STEERING);
      final Procedure1<BehaviorOutput> _function = (BehaviorOutput it) -> {
        it.setAngular(((-angularSpeed) / 1));
      };
      return ObjectExtensions.<BehaviorOutput>operator_doubleArrow(_behaviorOutput, _function);
    }
    if ((angle > this.decelerateAngle)) {
      BehaviorOutput _behaviorOutput_1 = new BehaviorOutput(DynamicType.STEERING);
      final Procedure1<BehaviorOutput> _function_1 = (BehaviorOutput it) -> {
        float _signum = Math.signum(sAngle);
        float _multiply = (_signum * maxAngular);
        it.setAngular(_multiply);
      };
      return ObjectExtensions.<BehaviorOutput>operator_doubleArrow(_behaviorOutput_1, _function_1);
    }
    BehaviorOutput _behaviorOutput_2 = new BehaviorOutput(DynamicType.STEERING);
    final Procedure1<BehaviorOutput> _function_2 = (BehaviorOutput it) -> {
      double _power = Math.pow(this.timeToReachTarget, 2);
      double _divide = (sAngle / _power);
      it.setAngular(((float) _divide));
    };
    return ObjectExtensions.<BehaviorOutput>operator_doubleArrow(_behaviorOutput_2, _function_2);
  }
}

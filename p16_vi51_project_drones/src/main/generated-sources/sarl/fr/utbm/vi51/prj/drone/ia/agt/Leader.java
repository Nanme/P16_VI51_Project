package fr.utbm.vi51.prj.drone.ia.agt;

import fr.utbm.vi51.prj.drone.framework.math.Point2f;
import fr.utbm.vi51.prj.drone.framework.math.Vector2f;
import fr.utbm.vi51.prj.drone.ia.agt.drone;
import fr.utbm.vi51.prj.drone.ia.behavior.MotionBehavior;
import fr.utbm.vi51.prj.drone.ia.evt.PerceptionEvent;
import fr.utbm.vi51.prj.drone.ia.evt.SimulationAgentReady;
import fr.utbm.vi51.prj.drone.ia.formation.Formation;
import io.sarl.core.Initialize;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.core.BuiltinCapacitiesProvider;
import io.sarl.lang.core.Percept;
import java.util.UUID;
import javax.annotation.Generated;
import javax.inject.Inject;

@SarlSpecification("0.3")
@SuppressWarnings("all")
public class Leader extends drone {
  protected MotionBehavior socialFBehavior;
  
  protected Formation formation;
  
  @Percept
  public void _handle_Initialize_0(final Initialize occurrence) {
    super._handle_Initialize_0(occurrence);
    Object _get = occurrence.parameters[3];
    this.formation = ((Formation) _get);
    SimulationAgentReady _simulationAgentReady = new SimulationAgentReady();
    this.emit(_simulationAgentReady);
  }
  
  @Percept
  public void _handle_PerceptionEvent_1(final PerceptionEvent occurrence) {
    Point2f _position = occurrence.body.getPosition();
    this.formation.setGlobalPosition(_position);
    Vector2f _direction = occurrence.body.getDirection();
    this.formation.setGlobalOrientation(_direction);
  }
  
  /**
   * Construct an agent.
   * @param builtinCapacityProvider - provider of the built-in capacities.
   * @param parentID - identifier of the parent. It is the identifier of the parent agent and the enclosing contect, at the same time.
   * @param agentID - identifier of the agent. If <code>null</code> the agent identifier will be computed randomly.
   */
  @Inject
  @Generated("io.sarl.lang.jvmmodel.SARLJvmModelInferrer")
  public Leader(final BuiltinCapacitiesProvider builtinCapacityProvider, final UUID parentID, final UUID agentID) {
    super(builtinCapacityProvider, parentID, agentID);
  }
}

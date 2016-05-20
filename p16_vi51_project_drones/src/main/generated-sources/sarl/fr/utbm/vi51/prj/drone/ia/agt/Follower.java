package fr.utbm.vi51.prj.drone.ia.agt;

import fr.utbm.vi51.prj.drone.ia.agt.drone;
import fr.utbm.vi51.prj.drone.ia.evt.PerceptionEvent;
import fr.utbm.vi51.prj.drone.ia.evt.SimulationAgentReady;
import fr.utbm.vi51.prj.drone.ia.formation.Anchor;
import fr.utbm.vi51.prj.drone.ia.formation.FormationAssignmentPolicy;
import io.sarl.core.Initialize;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.core.BuiltinCapacitiesProvider;
import io.sarl.lang.core.Percept;
import java.util.UUID;
import javax.annotation.Generated;
import javax.inject.Inject;

@SarlSpecification("0.3")
@SuppressWarnings("all")
public class Follower extends drone {
  protected Anchor formationSlot;
  
  @Percept
  public void _handle_Initialize_0(final Initialize occurrence) {
    super._handle_Initialize_0(occurrence);
    Object _get = occurrence.parameters[4];
    FormationAssignmentPolicy assignment = ((FormationAssignmentPolicy) _get);
    Anchor _assignAnchorToMe = assignment.assignAnchorToMe();
    this.formationSlot = _assignAnchorToMe;
    SimulationAgentReady _simulationAgentReady = new SimulationAgentReady();
    this.emit(_simulationAgentReady);
  }
  
  @Percept
  public void _handle_PerceptionEvent_1(final PerceptionEvent occurrence) {
  }
  
  /**
   * Construct an agent.
   * @param builtinCapacityProvider - provider of the built-in capacities.
   * @param parentID - identifier of the parent. It is the identifier of the parent agent and the enclosing contect, at the same time.
   * @param agentID - identifier of the agent. If <code>null</code> the agent identifier will be computed randomly.
   */
  @Inject
  @Generated("io.sarl.lang.jvmmodel.SARLJvmModelInferrer")
  public Follower(final BuiltinCapacitiesProvider builtinCapacityProvider, final UUID parentID, final UUID agentID) {
    super(builtinCapacityProvider, parentID, agentID);
  }
}

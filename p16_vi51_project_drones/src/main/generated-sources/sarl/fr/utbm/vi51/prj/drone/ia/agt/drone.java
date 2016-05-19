package fr.utbm.vi51.prj.drone.ia.agt;

import com.google.common.base.Objects;
import fr.utbm.vi51.prj.drone.DroneDisplay;
import fr.utbm.vi51.prj.drone.framework.math.MathUtil;
import fr.utbm.vi51.prj.drone.framework.math.Point2f;
import fr.utbm.vi51.prj.drone.framework.math.Vector2f;
import fr.utbm.vi51.prj.drone.ia.agt.AbstractOVNI;
import fr.utbm.vi51.prj.drone.ia.agt.BehaviorOutput;
import fr.utbm.vi51.prj.drone.ia.behavior.SeekBehaviour;
import fr.utbm.vi51.prj.drone.ia.behavior.SteeringSeekBehaviour;
import fr.utbm.vi51.prj.drone.ia.evt.DynamicType;
import fr.utbm.vi51.prj.drone.ia.evt.PerceptionEvent;
import fr.utbm.vi51.prj.drone.ia.evt.SimulationAgentReady;
import io.sarl.core.AgentSpawned;
import io.sarl.core.DefaultContextInteractions;
import io.sarl.core.Initialize;
import io.sarl.lang.annotation.FiredEvent;
import io.sarl.lang.annotation.ImportedCapacityFeature;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.core.Address;
import io.sarl.lang.core.Agent;
import io.sarl.lang.core.AgentContext;
import io.sarl.lang.core.BuiltinCapacitiesProvider;
import io.sarl.lang.core.Event;
import io.sarl.lang.core.EventSpace;
import io.sarl.lang.core.Percept;
import io.sarl.lang.core.Scope;
import io.sarl.lang.core.Space;
import io.sarl.lang.core.SpaceID;
import java.util.UUID;
import javax.annotation.Generated;
import javax.inject.Inject;

/**
 * @author Lana Banana
 */
@SarlSpecification("0.3")
@SuppressWarnings("all")
public class drone extends AbstractOVNI {
  protected SeekBehaviour seekBehaviour;
  
  protected DroneDisplay dispDrone;
  
  protected final float STOP_RADIUS = (MathUtil.PI / 10f);
  
  protected final float SLOW_RADIUS = (MathUtil.PI / 4f);
  
  protected final float WANDER_CIRCLE_DISTANCE = 20f;
  
  protected final float WANDER_CIRCLE_RADIUS = 10f;
  
  protected final float WANDER_MAX_ROTATION = (MathUtil.PI / 4f);
  
  @Percept
  public void _handle_Initialize_0(final Initialize occurrence) {
    super._handle_Initialize_0(occurrence);
    boolean _equals = Objects.equal(this.behaviorType, DynamicType.STEERING);
    if (_equals) {
      SteeringSeekBehaviour _steeringSeekBehaviour = new SteeringSeekBehaviour();
      this.seekBehaviour = _steeringSeekBehaviour;
    }
    SimulationAgentReady _simulationAgentReady = new SimulationAgentReady();
    this.emit(_simulationAgentReady);
  }
  
  @Percept
  public void _handle_PerceptionEvent_1(final PerceptionEvent occurrence) {
    Point2f target = new Point2f(15, 15);
    Point2f _position = occurrence.body.getPosition();
    Vector2f _currentLinearMotion = occurrence.body.getCurrentLinearMotion();
    float _length = _currentLinearMotion.getLength();
    float _maxLinearAcceleration = occurrence.body.getMaxLinearAcceleration();
    BehaviorOutput o = this.seekBehaviour.runSeek(_position, _length, _maxLinearAcceleration, target);
    this.emitInfluence(o);
  }
  
  /**
   * See the capacity {@link io.sarl.core.DefaultContextInteractions#emit(io.sarl.lang.core.Event)}.
   * 
   * @see io.sarl.core.DefaultContextInteractions#emit(io.sarl.lang.core.Event)
   */
  @Generated("io.sarl.lang.jvmmodel.SARLJvmModelInferrer")
  @ImportedCapacityFeature(DefaultContextInteractions.class)
  protected void emit(final Event arg0) {
    getSkill(io.sarl.core.DefaultContextInteractions.class).emit(arg0);
  }
  
  /**
   * See the capacity {@link io.sarl.core.DefaultContextInteractions#emit(io.sarl.lang.core.Event,io.sarl.lang.core.Scope<io.sarl.lang.core.Address>)}.
   * 
   * @see io.sarl.core.DefaultContextInteractions#emit(io.sarl.lang.core.Event,io.sarl.lang.core.Scope<io.sarl.lang.core.Address>)
   */
  @Generated("io.sarl.lang.jvmmodel.SARLJvmModelInferrer")
  @ImportedCapacityFeature(DefaultContextInteractions.class)
  protected void emit(final Event arg0, final Scope<Address> arg1) {
    getSkill(io.sarl.core.DefaultContextInteractions.class).emit(arg0, arg1);
  }
  
  /**
   * See the capacity {@link io.sarl.core.DefaultContextInteractions#getDefaultAddress()}.
   * 
   * @see io.sarl.core.DefaultContextInteractions#getDefaultAddress()
   */
  @Generated("io.sarl.lang.jvmmodel.SARLJvmModelInferrer")
  @ImportedCapacityFeature(DefaultContextInteractions.class)
  protected Address getDefaultAddress() {
    return getSkill(io.sarl.core.DefaultContextInteractions.class).getDefaultAddress();
  }
  
  /**
   * See the capacity {@link io.sarl.core.DefaultContextInteractions#getDefaultContext()}.
   * 
   * @see io.sarl.core.DefaultContextInteractions#getDefaultContext()
   */
  @Generated("io.sarl.lang.jvmmodel.SARLJvmModelInferrer")
  @ImportedCapacityFeature(DefaultContextInteractions.class)
  protected AgentContext getDefaultContext() {
    return getSkill(io.sarl.core.DefaultContextInteractions.class).getDefaultContext();
  }
  
  /**
   * See the capacity {@link io.sarl.core.DefaultContextInteractions#getDefaultSpace()}.
   * 
   * @see io.sarl.core.DefaultContextInteractions#getDefaultSpace()
   */
  @Generated("io.sarl.lang.jvmmodel.SARLJvmModelInferrer")
  @ImportedCapacityFeature(DefaultContextInteractions.class)
  protected EventSpace getDefaultSpace() {
    return getSkill(io.sarl.core.DefaultContextInteractions.class).getDefaultSpace();
  }
  
  /**
   * See the capacity {@link io.sarl.core.DefaultContextInteractions#isDefaultContext(io.sarl.lang.core.AgentContext)}.
   * 
   * @see io.sarl.core.DefaultContextInteractions#isDefaultContext(io.sarl.lang.core.AgentContext)
   */
  @Generated("io.sarl.lang.jvmmodel.SARLJvmModelInferrer")
  @ImportedCapacityFeature(DefaultContextInteractions.class)
  protected boolean isDefaultContext(final AgentContext arg0) {
    return getSkill(io.sarl.core.DefaultContextInteractions.class).isDefaultContext(arg0);
  }
  
  /**
   * See the capacity {@link io.sarl.core.DefaultContextInteractions#isDefaultContext(java.util.UUID)}.
   * 
   * @see io.sarl.core.DefaultContextInteractions#isDefaultContext(java.util.UUID)
   */
  @Generated("io.sarl.lang.jvmmodel.SARLJvmModelInferrer")
  @ImportedCapacityFeature(DefaultContextInteractions.class)
  protected boolean isDefaultContext(final UUID arg0) {
    return getSkill(io.sarl.core.DefaultContextInteractions.class).isDefaultContext(arg0);
  }
  
  /**
   * See the capacity {@link io.sarl.core.DefaultContextInteractions#isDefaultSpace(io.sarl.lang.core.Space)}.
   * 
   * @see io.sarl.core.DefaultContextInteractions#isDefaultSpace(io.sarl.lang.core.Space)
   */
  @Generated("io.sarl.lang.jvmmodel.SARLJvmModelInferrer")
  @ImportedCapacityFeature(DefaultContextInteractions.class)
  protected boolean isDefaultSpace(final Space arg0) {
    return getSkill(io.sarl.core.DefaultContextInteractions.class).isDefaultSpace(arg0);
  }
  
  /**
   * See the capacity {@link io.sarl.core.DefaultContextInteractions#isDefaultSpace(io.sarl.lang.core.SpaceID)}.
   * 
   * @see io.sarl.core.DefaultContextInteractions#isDefaultSpace(io.sarl.lang.core.SpaceID)
   */
  @Generated("io.sarl.lang.jvmmodel.SARLJvmModelInferrer")
  @ImportedCapacityFeature(DefaultContextInteractions.class)
  protected boolean isDefaultSpace(final SpaceID arg0) {
    return getSkill(io.sarl.core.DefaultContextInteractions.class).isDefaultSpace(arg0);
  }
  
  /**
   * See the capacity {@link io.sarl.core.DefaultContextInteractions#isDefaultSpace(java.util.UUID)}.
   * 
   * @see io.sarl.core.DefaultContextInteractions#isDefaultSpace(java.util.UUID)
   */
  @Generated("io.sarl.lang.jvmmodel.SARLJvmModelInferrer")
  @ImportedCapacityFeature(DefaultContextInteractions.class)
  protected boolean isDefaultSpace(final UUID arg0) {
    return getSkill(io.sarl.core.DefaultContextInteractions.class).isDefaultSpace(arg0);
  }
  
  /**
   * See the capacity {@link io.sarl.core.DefaultContextInteractions#isInDefaultSpace(io.sarl.lang.core.Event)}.
   * 
   * @see io.sarl.core.DefaultContextInteractions#isInDefaultSpace(io.sarl.lang.core.Event)
   */
  @Generated("io.sarl.lang.jvmmodel.SARLJvmModelInferrer")
  @ImportedCapacityFeature(DefaultContextInteractions.class)
  protected boolean isInDefaultSpace(final Event arg0) {
    return getSkill(io.sarl.core.DefaultContextInteractions.class).isInDefaultSpace(arg0);
  }
  
  /**
   * See the capacity {@link io.sarl.core.DefaultContextInteractions#receive(java.util.UUID,io.sarl.lang.core.Event)}.
   * 
   * @see io.sarl.core.DefaultContextInteractions#receive(java.util.UUID,io.sarl.lang.core.Event)
   */
  @Generated("io.sarl.lang.jvmmodel.SARLJvmModelInferrer")
  @ImportedCapacityFeature(DefaultContextInteractions.class)
  protected void receive(final UUID arg0, final Event arg1) {
    getSkill(io.sarl.core.DefaultContextInteractions.class).receive(arg0, arg1);
  }
  
  /**
   * See the capacity {@link io.sarl.core.DefaultContextInteractions#spawn(java.lang.Class<? extends io.sarl.lang.core.Agent>,java.lang.Object[])}.
   * 
   * @see io.sarl.core.DefaultContextInteractions#spawn(java.lang.Class<? extends io.sarl.lang.core.Agent>,java.lang.Object[])
   */
  @FiredEvent(AgentSpawned.class)
  @Generated("io.sarl.lang.jvmmodel.SARLJvmModelInferrer")
  @ImportedCapacityFeature(DefaultContextInteractions.class)
  protected UUID spawn(final Class<? extends Agent> arg0, final Object... arg1) {
    return getSkill(io.sarl.core.DefaultContextInteractions.class).spawn(arg0, arg1);
  }
  
  /**
   * Construct an agent.
   * @param builtinCapacityProvider - provider of the built-in capacities.
   * @param parentID - identifier of the parent. It is the identifier of the parent agent and the enclosing contect, at the same time.
   * @param agentID - identifier of the agent. If <code>null</code> the agent identifier will be computed randomly.
   */
  @Inject
  @Generated("io.sarl.lang.jvmmodel.SARLJvmModelInferrer")
  public drone(final BuiltinCapacitiesProvider builtinCapacityProvider, final UUID parentID, final UUID agentID) {
    super(builtinCapacityProvider, parentID, agentID);
  }
}

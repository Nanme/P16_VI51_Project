package fr.utbm.vi51.prj.drone.ia.agt;

import environment.Environment;
import environment.EnvironmentAgent;
import fr.utbm.vi51.prj.drone.framework.util.SpawnMapping;
import fr.utbm.vi51.prj.drone.ia.evt.AgentBody;
import fr.utbm.vi51.prj.drone.ia.evt.DynamicType;
import fr.utbm.vi51.prj.drone.ia.evt.SimulationAgentReady;
import fr.utbm.vi51.prj.drone.ia.evt.StartSimulation;
import io.sarl.core.AgentKilled;
import io.sarl.core.AgentSpawned;
import io.sarl.core.DefaultContextInteractions;
import io.sarl.core.Destroy;
import io.sarl.core.Initialize;
import io.sarl.core.Lifecycle;
import io.sarl.lang.annotation.EarlyExit;
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
import io.sarl.util.OpenEventSpace;
import io.sarl.util.OpenEventSpaceSpecification;
import java.util.List;
import java.util.UUID;
import javax.annotation.Generated;
import javax.inject.Inject;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Lana Banana
 */
@SarlSpecification("0.3")
@SuppressWarnings("all")
public class SimulatorAgent extends Agent {
  protected int waitingAgents = 0;
  
  @Percept
  public void _handle_Initialize_0(final Initialize occurrence) {
    Object _get = occurrence.parameters[0];
    Environment environment = ((Environment) _get);
    Object _get_1 = occurrence.parameters[1];
    UUID spaceId = ((UUID) _get_1);
    Object _get_2 = occurrence.parameters[2];
    SpawnMapping spawnMapping = ((SpawnMapping) _get_2);
    Object _get_3 = occurrence.parameters[3];
    DynamicType behaviorType = ((DynamicType) _get_3);
    AgentContext _defaultContext = this.getDefaultContext();
    OpenEventSpace space = _defaultContext.<OpenEventSpace>getOrCreateSpaceWithID(spaceId, OpenEventSpaceSpecification.class);
    Iterable<? extends AgentBody> _agentBodies = environment.getAgentBodies();
    int _size = IterableExtensions.size(_agentBodies);
    int _plus = (_size + 1);
    this.waitingAgents = _plus;
    UUID environmentId = this.spawn(EnvironmentAgent.class, environment, spaceId);
    List<Object> agentParameters = CollectionLiterals.<Object>newArrayList(spaceId, environmentId, behaviorType);
    for (int i = 4; (i < ((List<Object>)Conversions.doWrapArray(occurrence.parameters)).size()); i++) {
      Object _get_4 = occurrence.parameters[i];
      agentParameters.add(_get_4);
    }
    Iterable<? extends AgentBody> _agentBodies_1 = environment.getAgentBodies();
    for (final AgentBody body : _agentBodies_1) {
      {
        Class<? extends Agent> agentType = spawnMapping.getAgentTypeForBody(body);
        UUID _iD = body.getID();
        AgentContext _defaultContext_1 = this.getDefaultContext();
        Object[] _array = agentParameters.toArray();
        this.spawnInContextWithID(agentType, _iD, _defaultContext_1, _array);
      }
    }
  }
  
  @Generated("io.sarl.lang.jvmmodel.SARLJvmModelInferrer")
  @Pure
  private boolean _eventhandler_guard_SimulationAgentReady_1(final SimulationAgentReady it, final SimulationAgentReady occurrence) {
    boolean _isFromMe = this.isFromMe(occurrence);
    boolean _not = (!_isFromMe);
    return _not;
  }
  
  @Generated("io.sarl.lang.jvmmodel.SARLJvmModelInferrer")
  private void _eventhandler_body_SimulationAgentReady_1(final SimulationAgentReady occurrence) {
    synchronized (this) {
      this.waitingAgents--;
      if ((this.waitingAgents <= 0)) {
        StartSimulation _startSimulation = new StartSimulation();
        this.emit(_startSimulation);
        this.killMe();
      }
    }
  }
  
  @Percept
  public void _handle_SimulationAgentReady_1(final SimulationAgentReady occurrence) {
    if (_eventhandler_guard_SimulationAgentReady_1(occurrence, occurrence)) {
      _eventhandler_body_SimulationAgentReady_1(occurrence);
    }
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
   * See the capacity {@link io.sarl.core.Lifecycle#killMe()}.
   * 
   * @see io.sarl.core.Lifecycle#killMe()
   */
  @EarlyExit
  @FiredEvent({ AgentKilled.class, Destroy.class })
  @Generated("io.sarl.lang.jvmmodel.SARLJvmModelInferrer")
  @ImportedCapacityFeature(Lifecycle.class)
  protected void killMe() {
    getSkill(io.sarl.core.Lifecycle.class).killMe();
  }
  
  /**
   * See the capacity {@link io.sarl.core.Lifecycle#spawnInContext(java.lang.Class<? extends io.sarl.lang.core.Agent>,io.sarl.lang.core.AgentContext,java.lang.Object[])}.
   * 
   * @see io.sarl.core.Lifecycle#spawnInContext(java.lang.Class<? extends io.sarl.lang.core.Agent>,io.sarl.lang.core.AgentContext,java.lang.Object[])
   */
  @FiredEvent(AgentSpawned.class)
  @Generated("io.sarl.lang.jvmmodel.SARLJvmModelInferrer")
  @ImportedCapacityFeature(Lifecycle.class)
  protected UUID spawnInContext(final Class<? extends Agent> arg0, final AgentContext arg1, final Object... arg2) {
    return getSkill(io.sarl.core.Lifecycle.class).spawnInContext(arg0, arg1, arg2);
  }
  
  /**
   * See the capacity {@link io.sarl.core.Lifecycle#spawnInContextWithID(java.lang.Class<? extends io.sarl.lang.core.Agent>,java.util.UUID,io.sarl.lang.core.AgentContext,java.lang.Object[])}.
   * 
   * @see io.sarl.core.Lifecycle#spawnInContextWithID(java.lang.Class<? extends io.sarl.lang.core.Agent>,java.util.UUID,io.sarl.lang.core.AgentContext,java.lang.Object[])
   */
  @FiredEvent(AgentSpawned.class)
  @Generated("io.sarl.lang.jvmmodel.SARLJvmModelInferrer")
  @ImportedCapacityFeature(Lifecycle.class)
  protected UUID spawnInContextWithID(final Class<? extends Agent> arg0, final UUID arg1, final AgentContext arg2, final Object... arg3) {
    return getSkill(io.sarl.core.Lifecycle.class).spawnInContextWithID(arg0, arg1, arg2, arg3);
  }
  
  /**
   * Construct an agent.
   * @param builtinCapacityProvider - provider of the built-in capacities.
   * @param parentID - identifier of the parent. It is the identifier of the parent agent and the enclosing contect, at the same time.
   * @param agentID - identifier of the agent. If <code>null</code> the agent identifier will be computed randomly.
   */
  @Inject
  @Generated("io.sarl.lang.jvmmodel.SARLJvmModelInferrer")
  public SimulatorAgent(final BuiltinCapacitiesProvider builtinCapacityProvider, final UUID parentID, final UUID agentID) {
    super(builtinCapacityProvider, parentID, agentID);
  }
}

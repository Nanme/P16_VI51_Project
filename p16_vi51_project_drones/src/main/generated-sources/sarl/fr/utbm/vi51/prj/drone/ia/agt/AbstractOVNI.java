package fr.utbm.vi51.prj.drone.ia.agt;

import com.google.common.base.Objects;
import fr.utbm.vi51.prj.drone.framework.math.Vector2f;
import fr.utbm.vi51.prj.drone.ia.agt.BehaviorOutput;
import fr.utbm.vi51.prj.drone.ia.agt.PhysicEnvironment;
import fr.utbm.vi51.prj.drone.ia.agt.StandardPhysicEnvironment;
import fr.utbm.vi51.prj.drone.ia.evt.DynamicType;
import fr.utbm.vi51.prj.drone.ia.evt.Influence;
import fr.utbm.vi51.prj.drone.ia.evt.Perception;
import fr.utbm.vi51.prj.drone.ia.evt.StopSimulation;
import io.sarl.core.AgentKilled;
import io.sarl.core.AgentSpawned;
import io.sarl.core.Destroy;
import io.sarl.core.Initialize;
import io.sarl.core.Lifecycle;
import io.sarl.lang.annotation.EarlyExit;
import io.sarl.lang.annotation.FiredEvent;
import io.sarl.lang.annotation.ImportedCapacityFeature;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.core.Agent;
import io.sarl.lang.core.AgentContext;
import io.sarl.lang.core.BuiltinCapacitiesProvider;
import io.sarl.lang.core.Percept;
import java.util.UUID;
import javax.annotation.Generated;
import javax.inject.Inject;
import org.eclipse.xtext.xbase.lib.Pure;

@SarlSpecification("0.3")
@SuppressWarnings("all")
public class AbstractOVNI extends Agent {
  protected DynamicType behaviorType;
  
  @Percept
  public void _handle_Initialize_0(final Initialize occurrence) {
    Object _get = occurrence.parameters[0];
    Object _get_1 = occurrence.parameters[1];
    StandardPhysicEnvironment physicSkill = new StandardPhysicEnvironment(
      ((UUID) _get), 
      ((UUID) _get_1));
    Object _get_2 = occurrence.parameters[2];
    this.behaviorType = ((DynamicType) _get_2);
    this.<StandardPhysicEnvironment>setSkill(PhysicEnvironment.class, physicSkill);
  }
  
  @Pure
  protected float getMaxLinear(final Perception p) {
    float _xifexpression = (float) 0;
    boolean _equals = Objects.equal(this.behaviorType, DynamicType.STEERING);
    if (_equals) {
      _xifexpression = p.getMaxLinearAcceleration();
    }
    return _xifexpression;
  }
  
  @Pure
  protected float getMaxAngular(final Perception p) {
    float _xifexpression = (float) 0;
    boolean _equals = Objects.equal(this.behaviorType, DynamicType.STEERING);
    if (_equals) {
      _xifexpression = p.getMaxAngularAcceleration();
    }
    return _xifexpression;
  }
  
  protected void emitInfluence(final BehaviorOutput output) {
    if ((output != null)) {
      DynamicType _type = output.getType();
      boolean _tripleEquals = (_type == DynamicType.STEERING);
      if (_tripleEquals) {
        Vector2f _linear = output.getLinear();
        float _angular = output.getAngular();
        this.influenceSteering(_linear, _angular);
      }
    }
  }
  
  protected void doNothing() {
    Vector2f _vector2f = new Vector2f();
    this.influenceSteering(_vector2f, 0f);
  }
  
  @Percept
  public void _handle_StopSimulation_1(final StopSimulation occurrence) {
    this.killMe();
  }
  
  /**
   * See the capacity {@link fr.utbm.vi51.prj.drone.ia.agt.PhysicEnvironment#influenceSteering(fr.utbm.vi51.prj.drone.ia.evt.Influence[])}.
   * 
   * @see fr.utbm.vi51.prj.drone.ia.agt.PhysicEnvironment#influenceSteering(fr.utbm.vi51.prj.drone.ia.evt.Influence[])
   */
  @Generated("io.sarl.lang.jvmmodel.SARLJvmModelInferrer")
  @ImportedCapacityFeature(PhysicEnvironment.class)
  protected void influenceSteering(final Influence... otherInfluences) {
    getSkill(fr.utbm.vi51.prj.drone.ia.agt.PhysicEnvironment.class).influenceSteering(otherInfluences);
  }
  
  /**
   * See the capacity {@link fr.utbm.vi51.prj.drone.ia.agt.PhysicEnvironment#influenceSteering(float,fr.utbm.vi51.prj.drone.ia.evt.Influence[])}.
   * 
   * @see fr.utbm.vi51.prj.drone.ia.agt.PhysicEnvironment#influenceSteering(float,fr.utbm.vi51.prj.drone.ia.evt.Influence[])
   */
  @Generated("io.sarl.lang.jvmmodel.SARLJvmModelInferrer")
  @ImportedCapacityFeature(PhysicEnvironment.class)
  protected void influenceSteering(final float angularInfluence, final Influence... otherInfluences) {
    getSkill(fr.utbm.vi51.prj.drone.ia.agt.PhysicEnvironment.class).influenceSteering(angularInfluence, otherInfluences);
  }
  
  /**
   * See the capacity {@link fr.utbm.vi51.prj.drone.ia.agt.PhysicEnvironment#influenceSteering(fr.utbm.vi51.prj.drone.framework.math.Vector2f,fr.utbm.vi51.prj.drone.ia.evt.Influence[])}.
   * 
   * @see fr.utbm.vi51.prj.drone.ia.agt.PhysicEnvironment#influenceSteering(fr.utbm.vi51.prj.drone.framework.math.Vector2f,fr.utbm.vi51.prj.drone.ia.evt.Influence[])
   */
  @Generated("io.sarl.lang.jvmmodel.SARLJvmModelInferrer")
  @ImportedCapacityFeature(PhysicEnvironment.class)
  protected void influenceSteering(final Vector2f linearInfluence, final Influence... otherInfluences) {
    getSkill(fr.utbm.vi51.prj.drone.ia.agt.PhysicEnvironment.class).influenceSteering(linearInfluence, otherInfluences);
  }
  
  /**
   * See the capacity {@link fr.utbm.vi51.prj.drone.ia.agt.PhysicEnvironment#influenceSteering(fr.utbm.vi51.prj.drone.framework.math.Vector2f,float,fr.utbm.vi51.prj.drone.ia.evt.Influence[])}.
   * 
   * @see fr.utbm.vi51.prj.drone.ia.agt.PhysicEnvironment#influenceSteering(fr.utbm.vi51.prj.drone.framework.math.Vector2f,float,fr.utbm.vi51.prj.drone.ia.evt.Influence[])
   */
  @Generated("io.sarl.lang.jvmmodel.SARLJvmModelInferrer")
  @ImportedCapacityFeature(PhysicEnvironment.class)
  protected void influenceSteering(final Vector2f linearInfluence, final float angularInfluence, final Influence... otherInfluences) {
    getSkill(fr.utbm.vi51.prj.drone.ia.agt.PhysicEnvironment.class).influenceSteering(linearInfluence, angularInfluence, otherInfluences);
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
  public AbstractOVNI(final BuiltinCapacitiesProvider builtinCapacityProvider, final UUID parentID, final UUID agentID) {
    super(builtinCapacityProvider, parentID, agentID);
  }
}

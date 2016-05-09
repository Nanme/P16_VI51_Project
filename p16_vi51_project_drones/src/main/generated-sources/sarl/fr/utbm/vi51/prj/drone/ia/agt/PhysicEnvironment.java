package fr.utbm.vi51.prj.drone.ia.agt;

import fr.utbm.vi51.prj.drone.framework.math.Vector2f;
import fr.utbm.vi51.prj.drone.ia.evt.Influence;
import io.sarl.lang.annotation.DefaultValue;
import io.sarl.lang.annotation.DefaultValueSource;
import io.sarl.lang.annotation.DefaultValueUse;
import io.sarl.lang.annotation.SarlSourceCode;
import io.sarl.lang.core.Capacity;
import javax.annotation.Generated;

@SuppressWarnings("all")
public interface PhysicEnvironment extends Capacity {
  /**
   * Invoked to send the influence to the environment.
   * 
   * @param linearInfluence is the linear influence to apply on the object.
   * @param angularInfluence is the angular influence to apply on the object.
   * @param otherInfluences other influences to emit in parallel to the motion influence.
   */
  @DefaultValueSource
  public abstract void influenceSteering(@DefaultValue("fr.utbm.vi51.prj.drone.ia.agt.PhysicEnvironment#INFLUENCESTEERING_0") final Vector2f linearInfluence, @DefaultValue("fr.utbm.vi51.prj.drone.ia.agt.PhysicEnvironment#INFLUENCESTEERING_1") final float angularInfluence, final Influence... otherInfluences);
  
  /**
   * Default value for the parameter linearInfluence
   */
  @Generated("io.sarl.lang.jvmmodel.SARLJvmModelInferrer")
  @SarlSourceCode(" null")
  public final static Vector2f ___FORMAL_PARAMETER_DEFAULT_VALUE_INFLUENCESTEERING_0 = null;
  
  /**
   * Default value for the parameter angularInfluence
   */
  @Generated("io.sarl.lang.jvmmodel.SARLJvmModelInferrer")
  @SarlSourceCode(" 0f")
  public final static float ___FORMAL_PARAMETER_DEFAULT_VALUE_INFLUENCESTEERING_1 = 0f;
  
  /**
   * Invoked to send the influence to the environment.
   * 
   * @optionalparam linearInfluence is the linear influence to apply on the object.
   * @optionalparam angularInfluence is the angular influence to apply on the object.
   * @param otherInfluences other influences to emit in parallel to the motion influence.
   */
  @DefaultValueUse("fr.utbm.vi51.prj.drone.framework.math.Vector2f,float,fr.utbm.vi51.prj.drone.ia.evt.Influence*")
  @Generated("io.sarl.lang.jvmmodel.SARLJvmModelInferrer")
  public abstract void influenceSteering(final Influence... otherInfluences);
  
  /**
   * Invoked to send the influence to the environment.
   * 
   * @optionalparam linearInfluence is the linear influence to apply on the object.
   * @param angularInfluence is the angular influence to apply on the object.
   * @param otherInfluences other influences to emit in parallel to the motion influence.
   */
  @DefaultValueUse("fr.utbm.vi51.prj.drone.framework.math.Vector2f,float,fr.utbm.vi51.prj.drone.ia.evt.Influence*")
  @Generated("io.sarl.lang.jvmmodel.SARLJvmModelInferrer")
  public abstract void influenceSteering(final float angularInfluence, final Influence... otherInfluences);
  
  /**
   * Invoked to send the influence to the environment.
   * 
   * @param linearInfluence is the linear influence to apply on the object.
   * @optionalparam angularInfluence is the angular influence to apply on the object.
   * @param otherInfluences other influences to emit in parallel to the motion influence.
   */
  @DefaultValueUse("fr.utbm.vi51.prj.drone.framework.math.Vector2f,float,fr.utbm.vi51.prj.drone.ia.evt.Influence*")
  @Generated("io.sarl.lang.jvmmodel.SARLJvmModelInferrer")
  public abstract void influenceSteering(final Vector2f linearInfluence, final Influence... otherInfluences);
}

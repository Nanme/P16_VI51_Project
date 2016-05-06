package fr.utbm.vi51.prj.drone.ia.evt;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import fr.utbm.vi51.prj.drone.framework.math.MathUtil;
import fr.utbm.vi51.prj.drone.framework.math.Shape2f;
import fr.utbm.vi51.prj.drone.framework.math.Vector2f;
import fr.utbm.vi51.prj.drone.framework.util.LocalizedString;


public class AgentBody extends AbstractMobileObject implements Body {

	private static final long serialVersionUID = -4636419559142339321L;
	
	private final Frustum frustum;
	
	private transient MotionInfluence motionInfluence = null;
	private transient List<Influence> otherInfluences = new ArrayList<>();
	private transient List<Perception> perceptions = new ArrayList<>();

	/**
	 * @param id
	 * @param shape the shape of the body, considering that it is centered at the (0,0) position.
	 * @param maxLinearSpeed is the maximal linear speed.
	 * @param maxLinearAcceleration is the maximal linear acceleration.
	 * @param maxAngularSpeed is the maximal angular speed.
	 * @param maxAngularAcceleration is the maximal angular acceleration.
	 * @param frustum the field-of-view associated to the body.
	 */
	public AgentBody(UUID id, Shape2f<?> shape, float maxLinearAcceleration, float maxAngularAcceleration, Frustum frustum) {
		super(id, shape, maxLinearAcceleration, maxAngularAcceleration);
		assert (frustum == null || Objects.equals(id, frustum.getOwner()));
		this.frustum = frustum;
		setType("BODY");
	}
	
	@Override
	public AgentBody clone() {
		AgentBody clone = (AgentBody) super.clone();
		clone.motionInfluence = null;
		clone.otherInfluences = new ArrayList<>();
		clone.perceptions = new ArrayList<>();
		return clone;
	}

	/** {@inheritDoc}
	 */
	@Override
	public String toString() {
		String label = LocalizedString.getString(getClass(), "BODY_OF", getID()); //$NON-NLS-1$;
		String name = getName();
		if (name != null && !name.isEmpty()) {
			return name + "(" + label + ")";
		}
		return label;
	}
	
	/** Replies the frustum associated to this body.
	 *
	 * @return the frustum.
	 */
	public Frustum getFrustum() {
		return this.frustum;
	}
	
	/** Invoked to send the given influence to the environment.
	 *
	 * @param influence the influence.
	 */
	public void influence(Influence influence) {
		if (influence != null) {
			if (influence instanceof MotionInfluence) {
				MotionInfluence mi = (MotionInfluence) influence;
				if (mi.getInfluencedObject() == null || mi.getInfluencedObject().equals(getID())) {
					switch(mi.getType()) {
						case STEERING:
						influenceSteering(mi.getLinearInfluence(), mi.getAngularInfluence());
						break;
					default:
						break;
					}
				} else {
					this.otherInfluences.add(mi);
				}
			} else {
				this.otherInfluences.add(influence);
			}
		}
	}

	/** Invoked to send the influence to the environment.
	 * 
	 * @param linearInfluence is the linear influence to apply on the object.
	 * @param angularInfluence is the angular influence to apply on the object.
	 */
	public void influenceSteering(Vector2f linearInfluence, float angularInfluence) {
		Vector2f li;
		if (linearInfluence!=null) {
			li = new Vector2f(linearInfluence);
			float nSpeed = li.getLength();
			if (nSpeed>getMaxLinearAcceleration()) {
				li.normalize();
				li.scale(getMaxLinearAcceleration());
			}
		}
		else {
			li = new Vector2f();
		}
		float ai = MathUtil.clamp(angularInfluence, -getMaxAngularAcceleration(), getMaxAngularAcceleration());
		this.motionInfluence = new MotionInfluence(DynamicType.STEERING, getID(), li, ai);
	}
	
	/** Invoked to send the influence to the environment.
	 * 
	 * @param linearInfluence is the linear influence to apply on the object.
	 */
	public void influenceSteering(Vector2f linearInfluence) {
		influenceSteering(linearInfluence, 0f);
	}
	
	/** Invoked to send the influence to the environment.
	 * 
	 * @param angularInfluence is the angular influence to apply on the object.
	 */
	public void influenceSteering(float angularInfluence) {
		influenceSteering(null, angularInfluence);
	}
	
	/** Replies all the perceived objects.
	 * 
	 * @return the perceived objects.
	 */
	public List<Perception> getPerceivedObjects() {
		return this.perceptions;
	}

	/** Replies the influence.
	 * 
	 * @return the influence.
	 */
	List<Influence> consumeOtherInfluences() {
		List<Influence> otherInfluences = this.otherInfluences;
		this.otherInfluences = new ArrayList<>();
		for(Influence i : otherInfluences) {
			if (i!=null) i.setEmitter(getID());
		}
		return otherInfluences;
	}
	
	/** Replies the influence.
	 * 
	 * @return the influence.
	 */
	MotionInfluence consumeMotionInfluence() {
		MotionInfluence mi = this.motionInfluence;
		this.motionInfluence = null;
		if (mi!=null) mi.setEmitter(getID());
		return mi;
	}

	/** Set the perceptions.
	 * 
	 * @param perceptions
	 */
	void setPerceptions(List<Perception> perceptions) {
		assert(perceptions!=null);
		this.perceptions = perceptions;
	}

	@Override
	public float getRadius() {
		// TODO Auto-generated method stub
		return 0;
	}
}

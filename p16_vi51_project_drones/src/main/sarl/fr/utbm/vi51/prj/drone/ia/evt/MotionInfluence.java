package fr.utbm.vi51.prj.drone.ia.evt;

import java.util.UUID;

import fr.utbm.vi51.prj.drone.framework.math.Vector2f;


public class MotionInfluence extends Influence {

	private static final long serialVersionUID = 5211035037875773230L;

	private final DynamicType type;
	private final Vector2f linearInfluence = new Vector2f();
	private float angularInfluence = 0f;
	
	/**
	 * @param type indicates if the influence is kinematic or steering.
	 * @param influencedObject is the influenced object.
	 * @param linearInfluence is the linear influence to apply on the object.
	 * @param angularInfluence is the angular influence to apply on the object.
	 */
	public MotionInfluence(DynamicType type, UUID influencedObject, Vector2f linearInfluence, float angularInfluence) {
		super(influencedObject);
		this.type = type;
		setLinarInfluence(linearInfluence);
		setAngularInfluence(angularInfluence);
	}
	
	/**
	 * @param type indicates if the influence is kinematic or steering.
	 * @param influencedObject is the influenced object.
	 * @param linearInfluenceX is the linear influence to apply on the object.
	 * @param linearInfluenceY is the linear influence to apply on the object.
	 * @param angularInfluence is the angular influence to apply on the object.
	 */
	public MotionInfluence(DynamicType type, UUID influencedObject, float linearInfluenceX, float linearInfluenceY, float angularInfluence) {
		super(influencedObject);
		this.type = type;
		setLinarInfluence(linearInfluenceX, linearInfluenceY);
		setAngularInfluence(angularInfluence);
	}

	/**
	 * @param type indicates if the influence is kinematic or steering.
	 * @param influencedObject is the influenced object.
	 * @param linearInfluence is the linear influence to apply on the object.
	 */
	public MotionInfluence(DynamicType type, UUID influencedObject, Vector2f linearInfluence) {
		super(influencedObject);
		this.type = type;
		setLinarInfluence(linearInfluence);
	}
	
	/**
	 * @param type indicates if the influence is kinematic or steering.
	 * @param influencedObject is the influenced object.
	 * @param linearInfluenceX is the linear influence to apply on the object.
	 * @param linearInfluenceY is the linear influence to apply on the object.
	 */
	public MotionInfluence(DynamicType type, UUID influencedObject, float linearInfluenceX, float linearInfluenceY) {
		super(influencedObject);
		this.type = type;
		setLinarInfluence(linearInfluenceX, linearInfluenceY);
	}

	/**
	 * @param type indicates if the influence is kinematic or steering.
	 * @param influencedObject is the influenced object.
	 * @param angularInfluence is the angular influence to apply on the object.
	 */
	public MotionInfluence(DynamicType type, UUID influencedObject, float angularInfluence) {
		super(influencedObject);
		this.type = type;
		setAngularInfluence(angularInfluence);
	}
	
	/**
	 * @param type indicates if the influence is kinematic or steering.
	 * @param influencedObject is the influenced object.
	 */
	public MotionInfluence(DynamicType type, UUID influencedObject) {
		super(influencedObject);
		this.type = type;
	}

	/**
	 * @param type indicates if the influence is kinematic or steering.
	 * @param linearInfluence is the linear influence to apply on the object.
	 * @param angularInfluence is the angular influence to apply on the object.
	 */
	public MotionInfluence(DynamicType type, Vector2f linearInfluence, float angularInfluence) {
		super(null);
		this.type = type;
		setLinarInfluence(linearInfluence);
		setAngularInfluence(angularInfluence);
	}
	
	/**
	 * @param type indicates if the influence is kinematic or steering.
	 * @param linearInfluenceX is the linear influence to apply on the object.
	 * @param linearInfluenceY is the linear influence to apply on the object.
	 * @param angularInfluence is the angular influence to apply on the object.
	 */
	public MotionInfluence(DynamicType type, float linearInfluenceX, float linearInfluenceY, float angularInfluence) {
		super(null);
		this.type = type;
		setLinarInfluence(linearInfluenceX, linearInfluenceY);
		setAngularInfluence(angularInfluence);
	}

	/**
	 * @param type indicates if the influence is kinematic or steering.
	 * @param linearInfluence is the linear influence to apply on the object.
	 */
	public MotionInfluence(DynamicType type, Vector2f linearInfluence) {
		super(null);
		this.type = type;
		setLinarInfluence(linearInfluence);
	}
	
	/**
	 * @param type indicates if the influence is kinematic or steering.
	 * @param linearInfluenceX is the linear influence to apply on the object.
	 * @param linearInfluenceY is the linear influence to apply on the object.
	 */
	public MotionInfluence(DynamicType type, float linearInfluenceX, float linearInfluenceY) {
		super(null);
		this.type = type;
		setLinarInfluence(linearInfluenceX, linearInfluenceY);
	}

	/**
	 * @param type indicates if the influence is kinematic or steering.
	 * @param angularInfluence is the angular influence to apply on the object.
	 */
	public MotionInfluence(DynamicType type, float angularInfluence) {
		super(null);
		this.type = type;
		setAngularInfluence(angularInfluence);
	}
	
	/**
	 * @param type indicates if the influence is kinematic or steering.
	 */
	public MotionInfluence(DynamicType type) {
		super(null);
		this.type = type;
	}

	/** Set the linear influence.
	 * 
	 * @param l is the linear influence
	 */
	public void setLinarInfluence(Vector2f l) {
		assert(l!=null);
		this.linearInfluence.set(l);
	}
		
	/** Set the linear influence.
	 * 
	 * @param dx is the linear influence
	 * @param dy is the linear influence
	 */
	public void setLinarInfluence(float dx, float dy) {
		this.linearInfluence.set(dx, dy);
	}

	/** Set the angular influence.
	 * 
	 * @param a
	 */
	public void setAngularInfluence(float a) {
		this.angularInfluence = a;
	}

	/** Replies the linear influence.
	 * 
	 * @return the linear influence
	 */
	public Vector2f getLinearInfluence() {
		return this.linearInfluence;
	}
		
	/** Replies the angular influence.
	 * 
	 * @return the angular influence
	 */
	public float getAngularInfluence() {
		return this.angularInfluence;
	}
	
	/** Replies the type of the influence.
	 * 
	 * @return the type of the influence.
	 */
	public DynamicType getType() {
		return this.type;
	}
	
	@Override
	public String toString() {
		return this.linearInfluence + "|" + this.angularInfluence;
	}

}
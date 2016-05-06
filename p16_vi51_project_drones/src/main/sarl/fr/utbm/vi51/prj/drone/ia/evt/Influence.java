package fr.utbm.vi51.prj.drone.ia.evt;

import java.io.Serializable;
import java.util.UUID;

public abstract class Influence implements Serializable {

	private static final long serialVersionUID = -3172105252469025247L;

	private UUID emitter = null;
	private final UUID influencedObject;
	
	/**
	 * @param influencedObject is the influenced object.
	 */
	protected Influence(UUID influencedObject) {
		this.influencedObject = influencedObject;
	}
	
	/** Replies the emitter of the influence.
	 * 
	 * @return the emitter of the influence.
	 */
	public UUID getEmitter() {
		return this.emitter;
	}
	
	/** Set the emitter of the influence.
	 * 
	 * @param emitter is the emitter of the influence.
	 */
	void setEmitter(UUID emitter) {
		assert(emitter!=null);
		this.emitter = emitter;
	}

	/** Replies the influenced object.
	 * 
	 * @return the influenced object.
	 */
	public UUID getInfluencedObject() {
		return this.influencedObject;
	}
	
}

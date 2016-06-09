package fr.utbm.vi51.prj.environment;

import java.util.UUID;

import fr.utbm.vi51.prj.drone.DroneDisplay;
import fr.utbm.vi51.prj.drone.framework.math.Point2f;
import fr.utbm.vi51.prj.drone.framework.math.Rectangle2f;
import fr.utbm.vi51.prj.utils.tree.node.TreeNode;

public abstract class EnvironmentObject {
	
	protected float width;
	protected float height;
	protected float depth;
	protected UUID id;
	protected DroneDisplay body;
	
	protected TreeNode node;
	//protected final enum type;
	
	/**
	 * creation of the object with his ID
	 * @param id
	 */
	public EnvironmentObject(UUID id, DroneDisplay body) { 
		this.id = id;
		if(id==null)id=UUID.randomUUID();
		this.body=body;
	}
	
	/**
	 * creation of the object with his position and dimensions
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public EnvironmentObject(float width,float height, float depth, UUID id) {
		this.id = id;
		if(id==null)id=UUID.randomUUID();
		this.width=width;
		this.height=height;
		this.depth=depth;
	}
	
	/**
	 * generate the box from the position
	 * @return
	 */
	public Rectangle2f getBox() {
		Point2f position = this.getPosition();
		Rectangle2f box = new Rectangle2f(position.getX(),position.getY(),width,height);
		//box.setFromCenter(position.getX(),position.getY(),position.getX()+width/2,position.getY()+height/2);
		return box;
	}

	/**
	 * get the position from jbox2d
	 * @return
	 */
	public Point2f getPosition() {
		Point2f position = new Point2f(body.getX(),body.getY());
		return position;
	}
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public DroneDisplay getBody() {
		return body;
	}
	
	@Override	
	public String toString(){
		
		return "UUID : " + id + "   Position : (" + getPosition().getX() + "," + getPosition().getY() + ")";
		
	}
	
}
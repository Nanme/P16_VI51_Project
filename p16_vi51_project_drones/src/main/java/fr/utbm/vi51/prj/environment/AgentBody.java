package fr.utbm.vi51.prj.environment;

import java.util.ArrayList;
import java.util.UUID;

import fr.utbm.vi51.prj.drone.framework.math.Circle2f;
import fr.utbm.vi51.prj.drone.framework.math.Rectangle2f;
import fr.utbm.vi51.prj.utils.tree.node.TreeNode;

public class AgentBody extends DynamicObject implements Comparable<AgentBody>{
	
	private float perceptionDistance; 
	//private final enum agentType; semantic
	
	public AgentBody (float x, float y,float z,float radius,UUID agentId, float perceptionDistance) {
		super (x,y,z,radius,agentId);
		this.perceptionDistance = perceptionDistance;
	}


	public float getPerceptionDistance() {
		return perceptionDistance;
	}
	
	/**
	 * return all the percepted objects
	 * 
	 * @return ArrayList<Perceivable>
	 */
	public ArrayList<Perceivable> computePerception(){
		
		TreeNode topNode = this.node;
		Circle2f range = new Circle2f(getPosition(),perceptionDistance);
		Rectangle2f r = new Rectangle2f();
		//r.setFromCorners(range.getX()-range.getRadius(),range.getY()-range.getRadius(),range.getX()+range.getRadius(),range.getY()+range.getRadius());
		
		//determine the biggest node that is in range
//		while(!topNode.getBox().contains(r)){
//			topNode = topNode.getParent();
//			assert(topNode!=null); //test
//		}
		
		ArrayList<Perceivable> percept = new ArrayList<Perceivable>();
		
//		DepthFirstIterator it = new DepthFirstIterator(topNode);
//		while(it.hasNext()){
//			TreeNode currentNode = it.next();
//			if(currentNode.getBox().intersects(range)){
//				for(EnvironmentObject o:currentNode.getObjects()){
//					if(o.getBox().intersects(range) && o!=this){
//						percept.add(new Perceivable(o));
//					}
//				}
//			}
//			
//		}
		
		//ArrayList<Perceivable> percept = computePerception1N(topNode,range); //Recursive method
				
		return percept;
	}
	
	/**
	 * usable for recursivity  -> we may use the depthFirstIterator
	 * @return ArrayList<Perceivable>
	 */
	@Deprecated
	public ArrayList<Perceivable> computePerception1N(TreeNode topNode,Circle2f range){
		
		ArrayList<Perceivable> perception = new ArrayList<Perceivable>();
		
//		for(EnvironmentObject o:topNode.getObjects()){
//			if(o.getBox().intersects(range)){
//				perception.add(new Perceivable(o));
//			}
//		}
//		if(topNode.getChildren()!=null){
//			for(TreeNode node:topNode.getChildren()){
//				if(node.getBox().intersects(range))
//				perception.addAll(computePerception1N(node, range));
//			}
//		}
		
		return perception;
		
	}
		

	@Override
	public int compareTo(AgentBody o) {
		if (o == this) {
			return 0; 
		}
		if (o == null) {
			return Integer.MAX_VALUE;
		}
		return getId().compareTo(o.getId());
	}
}
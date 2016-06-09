/**
 * 
 */
package fr.utbm.vi51.prj.utils.tree;

import java.util.ArrayList;

import environment.Environment;
import fr.utbm.vi51.prj.drone.ia.evt.AbstractSituatedObject;
import fr.utbm.vi51.prj.drone.ia.evt.SituatedObject;
import fr.utbm.vi51.prj.utils.tree.node.OctTreeNode;

/**
 * @author renaud
 *
 */
public class TreeBuilder {
	
	public OctTree<EnvironmentObject> buildEnvironmentTree(Environment e){
		OctTree<AbstractSituatedObject> tree = new OctTree<>(new OctTreeNode<AbstractSituatedObject>(null, null, null));
		ArrayList<AbstractSituatedObject> objects = (ArrayList<AbstractSituatedObject>) e.getAllObjects();
		
		
		for(SituatedObject obj : objects){
			
		}
		return tree;
		
	}

}

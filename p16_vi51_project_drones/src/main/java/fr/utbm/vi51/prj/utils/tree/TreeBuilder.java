/**
 * 
 */
package fr.utbm.vi51.prj.utils.tree;

/**
 * @author renaud
 *
 */
public class TreeBuilder {
	
	private BSPTree bspTree = null;
	
	private OctTree octTree = null;
	
	public BSPTree getInstanceOfBSPTree (){
		return bspTree;
		
	}
	
	public OctTree getInstanceOfOctTree() {
		return octTree;
	}

}

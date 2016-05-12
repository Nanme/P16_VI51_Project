/**
 * 
 */
package fr.utbm.vi51.prj.utils.tree;

import fr.utbm.vi51.prj.utils.tree.node.BSPTreeNode;
import fr.utbm.vi51.prj.utils.tree.node.BinaryTreeNode;

/**
 * @author renaud
 *
 */
public class BSPTree extends BinaryTreeNode<Object, BSPTreeNode> {

	public BSPTree(BSPTreeNode parent, Object data) {
		super(parent, data);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param data
	 */
	public BSPTree(Object data) {
		super(data);
		// TODO Auto-generated constructor stub
	}

}

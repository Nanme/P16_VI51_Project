/**
 * 
 */
package fr.utbm.vi51.prj.utils.tree.node;

/**
 * @author renaud
 *
 */
public class BSPTreeNode extends BinaryTreeNode<Object, BSPTreeNode> {
	
	//TODO Add 3D Plan use as separation.
	
	/**
	 * @param parent
	 * @param data
	 */
	public BSPTreeNode(BSPTreeNode parent, Object data) {
		super(parent, data);
	}

	/**
	 * @param data
	 */
	public BSPTreeNode(Object data) {
		super(data);
	}

}

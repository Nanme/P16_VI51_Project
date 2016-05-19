/**
 * 
 */
package fr.utbm.vi51.prj.utils.tree.node;

/**
 * @author renaud
 *
 */
public class BSPTreeNode extends BinaryTreeNode<Object, BSPTreeNode> {

	/**
	 * @param parent
	 * @param data
	 */
	public BSPTreeNode(BSPTreeNode parent, Object data) {
		super(parent, data);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param data
	 */
	public BSPTreeNode(Object data) {
		super(data);
		// TODO Auto-generated constructor stub
	}

}

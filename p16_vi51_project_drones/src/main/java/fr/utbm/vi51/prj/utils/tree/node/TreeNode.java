package fr.utbm.vi51.prj.utils.tree.node;

import java.util.Collection;

public interface TreeNode<D, N extends TreeNode<D, N>> {
	
	/**
	 * 
	 * @return the parent node
	 */
	N getParentNode();
	
	/**
	 * 
	 * @return the children.
	 */
	Collection<N> getChildren();
	
	/**
	 * 
	 * @return number of child.
	 */
	int getChildCount();
	
	/**
	 * 
	 * @param index - position of the child
	 * @return the child at <code>index</code>
	 */
	N getChildAt(int index);
	
	/**
	 * 
	 * @param child - the node which you look for position.
	 * @return the position of <code>child</code>
	 */
	int indexOf(N child);
	
	/**
	 * 
	 * @return <code>true</code> if node is empty,
	 * <code>false</code> if not.
	 */
	boolean isEmpty();
	
	/**
	 * 
	 * @return <code>true</code> if node is a leaf,
	 * <code>false</code> if not.
	 */
	boolean isLeaf();
	
	/**
	 * 
	 * @return <code>true</code> if node is a root,
	 * <code>false</code> if not.
	 */
	boolean isRoot();
	
	/**
	 * Set the parent of the node.
	 * @param parent - the parent to set.
	 */
	void setParentNode(N parent);
	
	/**
	 * @return the data contain by the Node 
	 */
	D getData();
	
	/**
	 * 
	 * @param data - the data to set.
	 */
	void setData(D data);
}

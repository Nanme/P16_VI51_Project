/**
 * 
 */
package fr.utbm.vi51.prj.utils.tree;

import java.util.Iterator;

import fr.utbm.vi51.prj.utils.tree.node.TreeNode;

/**
 * @author renaud
 *
 */
public interface Tree<D, N extends TreeNode<D, N>> extends Iterable<N> {
	
	/**
	 * 
	 * @return the root node of the tree.
	 */
	N getRoot();
	
	/**
	 * 
	 * @param root - the root to set.
	 */
	void setRoot(N root);
	
	/**
	 * 
	 * @return <code>true</code> if the tree is empty,
	 * <code>false</code> if not.
	 */
	boolean isEmpty();
	
	/**
	 * 
	 * @return the depth first iterator;
	 */
	Iterator<N> getDepthFirstIterator();
	
	/**
	 * 
	 * @return the breadthFirstIterator;
	 */
	Iterator<N> getBreadthFirstIterator();
}

/**
 * 
 */
package fr.utbm.vi51.prj.utils.tree;

import fr.utbm.vi51.prj.utils.tree.node.AbstractTreeNode;

/**
 * @author renaud
 *
 */
public abstract class AbstractTree<D, N extends AbstractTreeNode<D, N>> implements Tree<D, N> {
	
	private N root;
	
	
	
	public AbstractTree(N root) {
		this.root = root;
	}

	@Override
	public N getRoot() {
		return root;
	}

	@Override
	public void setRoot(N root) {
		this.root = root;
	}

	@Override
	public boolean isEmpty() {
		return this.root == null;
	}

}

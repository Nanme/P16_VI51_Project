/**
 * 
 */
package fr.utbm.vi51.prj.utils.tree.node;

import java.lang.ref.WeakReference;

/**
 * @author renaud
 *
 */
public abstract class AbstractTreeNode<D, N extends AbstractTreeNode<D, N>> implements TreeNode<D,N> {
	
	private WeakReference<N> parent;
	
	private D data;

	/**
	 * @param parent
	 * @param data
	 */
	public AbstractTreeNode(N parent, D data) {
		this.parent = new WeakReference<>(parent);
		this.data = data;
	}

	/**
	 * @param data
	 */
	public AbstractTreeNode(D data) {
		this.data = data;
	}

	@Override
	public N getParentNode() {
		return this.parent.get();
	}

	@Override
	public boolean isRoot() {
		return this.parent.get() == null;
	}

	@Override
	public void setParentNode(N parent) {
		this.parent = new WeakReference<>(parent);
	}

	@Override
	public D getData() {
		return this.data;
	}

	@Override
	public void setData(D data) {
		this.data = data;
	}
	
	
	
	
}

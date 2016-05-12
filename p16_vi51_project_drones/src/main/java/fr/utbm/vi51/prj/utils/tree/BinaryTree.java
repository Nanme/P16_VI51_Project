/**
 * 
 */
package fr.utbm.vi51.prj.utils.tree;

import java.util.Iterator;

import fr.utbm.vi51.prj.utils.tree.node.BinaryTreeNode;

/**
 * @author renaud
 *
 */
public class BinaryTree<D, N extends BinaryTreeNode<D, N>> extends AbstractTree<D, N> {

	public BinaryTree(N root) {
		super(root);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see fr.utbm.vi51.prj.utils.tree.Tree#getDepthFirstIterator()
	 */
	@Override
	public Iterator<N> getDepthFirstIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see fr.utbm.vi51.prj.utils.tree.Tree#getBreadthFirstIterator()
	 */
	@Override
	public Iterator<N> getBreadthFirstIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see java.lang.Iterable#iterator()
	 */
	@Override
	public Iterator<N> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	protected static class DepthFirstIterator<D, N extends BinaryTreeNode<D, N>> implements Iterator<N> {

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public N next() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
	protected static class BreadthFirstIterator<D, N extends BinaryTreeNode<D, N>> implements Iterator<N> {

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public N next() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}

}

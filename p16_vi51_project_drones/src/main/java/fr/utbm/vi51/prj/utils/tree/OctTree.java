/**
 * 
 */
package fr.utbm.vi51.prj.utils.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import fr.utbm.vi51.prj.utils.tree.node.OctTreeNode;

/**
 * @author renaud
 *
 */
public final class OctTree<D, N extends OctTreeNode<D,N>> extends AbstractTree<D, N>{
	
	private final ArrayList<N> children = new ArrayList<>(4);
	
	private D data;
	
	/**
	 * 
	 */
	public OctTree(N root) {
		super(root);
	}

	@Override
	public Iterator<N> getDepthFirstIterator() {
		return new DepthFirstIterator(this);
	}

	@Override
	public Iterator<N> getBreadthFirstIterator() {
		return new BreadthFirstIterator<>(this);
	}

	@Override
	public Iterator<N> iterator() {
		return getDepthFirstIterator();
	}
	
	private static class DepthFirstIterator<D, N extends OctTreeNode<D,N>> implements Iterator<N>{
		
		private final Stack<N> stk = new Stack<>();
		
		public DepthFirstIterator(OctTree<D, N> tree) {
			stk.push(tree.getRoot());
		}

		@Override
		public boolean hasNext() {
			return !this.stk.isEmpty();
		}

		@Override
		public N next() {
			N node = stk.pop();
			if (node.isLeaf()) {
				for (N val : node.getChildren()){
					stk.push(val);
				}
			}
			return node;
		}
		
	}
	
	private static class BreadthFirstIterator<D, N extends OctTreeNode<D, N>> implements Iterator<N>{
		private final Queue<N> queue = new LinkedList<N>();
		
		public BreadthFirstIterator(OctTree<D, N> tree) {
			queue.add(tree.getRoot());
		}
		
		@Override
		public boolean hasNext() {
			return !this.queue.isEmpty();
		}

		@Override
		public N next() {
			N node = queue.poll();
			
			if (!node.isLeaf()){
				for (N val : node.getChildren()){
					queue.add(val);
				}
			}
			return node;
		}
	}
	
}

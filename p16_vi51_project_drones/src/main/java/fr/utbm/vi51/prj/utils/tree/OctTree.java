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
public final class OctTree<D> extends AbstractTree<D, OctTreeNode<D>>{
	
	/**
	 * 
	 */
	public OctTree(OctTreeNode<D> root) {
		super(root);
	}

	@Override
	public Iterator<OctTreeNode<D>> getDepthFirstIterator() {
		return new DepthFirstIterator<D>(this);
	}

	@Override
	public Iterator<OctTreeNode<D>> getBreadthFirstIterator() {
		return new BreadthFirstIterator<D>(this);
	}

	@Override
	public Iterator<OctTreeNode<D>> iterator() {
		return getDepthFirstIterator();
	}
	
	private static class DepthFirstIterator<D> implements Iterator<OctTreeNode<D>>{
		
		private final Stack<OctTreeNode<D>> stk = new Stack<>();
		
		public DepthFirstIterator(OctTree<D> tree) {
			stk.push(tree.getRoot());
		}

		@Override
		public boolean hasNext() {
			return !this.stk.isEmpty();
		}

		@Override
		public OctTreeNode<D> next() {
			OctTreeNode<D> node = stk.pop();
			if (node.isLeaf()) {
				for (OctTreeNode<D> val : node.getChildren()){
					stk.push(val);
				}
			}
			return node;
		}
		
	}
	
	private static class BreadthFirstIterator<D> implements Iterator<OctTreeNode<D>>{
		private final Queue<OctTreeNode<D>> queue = new LinkedList<OctTreeNode<D>>();
		
		public BreadthFirstIterator(OctTree<D> tree) {
			queue.add(tree.getRoot());
		}
		
		@Override
		public boolean hasNext() {
			return !this.queue.isEmpty();
		}

		@Override
		public OctTreeNode<D> next() {
			OctTreeNode<D> node = queue.poll();
			
			if (!node.isLeaf()){
				for (OctTreeNode<D> val : node.getChildren()){
					queue.add(val);
				}
			}
			return node;
		}
	}
	
}

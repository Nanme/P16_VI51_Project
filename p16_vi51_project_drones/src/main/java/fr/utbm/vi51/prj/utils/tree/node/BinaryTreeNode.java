/**
 * 
 */
package fr.utbm.vi51.prj.utils.tree.node;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author renaud
 *
 */
public class BinaryTreeNode<D, N extends BinaryTreeNode<D, N>> extends AbstractTreeNode<D, N> {
	
	
	
	public BinaryTreeNode(D data) {
		super(data);
	}

	public BinaryTreeNode(N parent, D data) {
		super(parent, data);
	}
	
	private N leftChild;
	private N rightChild;
	
	
	/**
	 * @return the leftChild
	 */
	public N getLeftChild() {
		return leftChild;
	}

	/**
	 * @param leftChild the leftChild to set
	 */
	public void setLeftChild(N leftChild) {
		this.leftChild = leftChild;
	}

	/**
	 * @return the rightChild
	 */
	public N getRightChild() {
		return rightChild;
	}

	/**
	 * @param rightChild the rightChild to set
	 */
	public void setRightChild(N rightChild) {
		this.rightChild = rightChild;
	}

	/* (non-Javadoc)
	 * @see fr.utbm.vi51.prj.utils.tree.node.TreeNode#getChildren()
	 */
	@Override
	public Collection<N> getChildren() {
		List<N> children = new ArrayList<>(2);
		children.add(this.leftChild);
		children.add(this.rightChild);
		return children;
	}

	/* (non-Javadoc)
	 * @see fr.utbm.vi51.prj.utils.tree.node.TreeNode#getChildCount()
	 */
	@Override
	public int getChildCount() {
		return 2;
	}

	/* (non-Javadoc)
	 * @see fr.utbm.vi51.prj.utils.tree.node.TreeNode#getChildAt(int)
	 */
	@Override
	public N getChildAt(int index) throws ArrayIndexOutOfBoundsException {
		if (index == 0)
			return this.leftChild;
		else if (index == 1)
			return this.rightChild;
		else
			return null;
	}

	/* (non-Javadoc)
	 * @see fr.utbm.vi51.prj.utils.tree.node.TreeNode#indexOf(fr.utbm.vi51.prj.utils.tree.node.TreeNode)
	 */
	@Override
	public int indexOf(N child) {
		if (child == leftChild)
			return 0;
		else if (child == rightChild)
			return 1;
		else
			return -1;
	}

	/* (non-Javadoc)
	 * @see fr.utbm.vi51.prj.utils.tree.node.TreeNode#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return (data == null);
	}

	/* (non-Javadoc)
	 * @see fr.utbm.vi51.prj.utils.tree.node.TreeNode#isLeaf()
	 */
	@Override
	public boolean isLeaf() {
		return (leftChild == null && rightChild == null);
	}

}

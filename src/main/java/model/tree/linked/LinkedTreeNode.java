package model.tree.linked;

import model.tree.TreeNode;

public class LinkedTreeNode<N> extends TreeNode {

	private N left;
	private N right;
	private N parent;

	public LinkedTreeNode() {
		super();
	}

	public void setLeftNode(N left) {
		this.left = left;
	}

	public void setRightNode(N right) {
		this.right = right;
	}

	public N getLeftNode() {
		return left;
	}

	public N getRightNode() {
		return right;
	}

	public void setParentNode(N parent) {
		this.parent = parent;
	}

	public N getParentNode() {
		return parent;
	}

}
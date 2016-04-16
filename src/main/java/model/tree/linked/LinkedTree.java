package model.tree.linked;

import model.tree.Tree;
import model.tree.TreeNodeFactory;

public class LinkedTree<T extends LinkedTree<T, N>, N extends LinkedTreeNode<N>>
		extends Tree<N> {

	private N root;
	private N current;

	private enum Direction {
		LEFT, RIGHT, PARENT
	}

	@Override
	public boolean hasParentNode() {
		return current != null && current.getParentNode() != null;
	}

	@Override
	public boolean hasLeftNode() {
		return current != null && current.getLeftNode() != null;
	}

	@Override
	public boolean hasRightNode() {
		return current != null && current.getRightNode() != null;
	}

	public boolean moveToNode(Direction dir) {
		if (current == null)
			return false;

		N node = null;

		switch (dir) {
		case LEFT:
			node = current.getLeftNode();
			break;
		case RIGHT:
			node = current.getRightNode();
			break;
		case PARENT:
			node = current.getParentNode();
			break;
		}

		if (node == null)
			return false;

		current = node;
		return true;
	}

	@Override
	public boolean moveToRoot() {
		if (root == null)
			return false;

		current = root;
		return true;
	}

	@Override
	public boolean moveToLeftNode() {
		return moveToNode(Direction.LEFT);
	}

	@Override
	public boolean moveToRightNode() {
		return moveToNode(Direction.RIGHT);
	}

	@Override
	public boolean moveToParentNode() {
		return moveToNode(Direction.PARENT);
	}

	@Override
	public boolean setLeftNode(N node) {
		if (current == null)
			return false;

		current.setLeftNode(replaceNode(current.getLeftNode(), node));

		if (node != null)
			current.getLeftNode().setParentNode(current);
		return true;
	}

	@Override
	public boolean setRightNode(N node) {
		if (current == null)
			return false;

		current.setRightNode(replaceNode(current.getRightNode(), node));

		if (node != null)
			current.getRightNode().setParentNode(current);
		return true;
	}

	@Override
	public void setCurrentNode(N node) {
		if (root == null)
			root = node;

		current = replaceNode(current, node);
	}

	@Override
	public N getCurrentNode() {
		return current;
	}

	private N replaceNode(N oldNode, N newNode) {
		if (newNode == null)
			return null;

		if (oldNode != null) {
			N left = oldNode.getLeftNode();
			N right = oldNode.getRightNode();
			N parent = oldNode.getParentNode();

			newNode.setLeftNode(left);
			newNode.setParentNode(parent);
			newNode.setRightNode(right);

			if (parent != null) {
				if (parent.getLeftNode() == oldNode)
					parent.setLeftNode(newNode);
				else if (parent.getRightNode() == oldNode)
					parent.setRightNode(newNode);
				else
					throw new RuntimeException(
							"We have a parent but are neither its left nor its right child.");
			}

		} else {
			newNode.setLeftNode(null);
			newNode.setParentNode(null);
			newNode.setRightNode(null);
		}

		return newNode;
	}

	@Override
	public void clear() {
		root = null;
		current = null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <F extends TreeNodeFactory<N>> F getFactory() {
		return (F) new LinkedTreeNodeFactory<N>();
	}

}
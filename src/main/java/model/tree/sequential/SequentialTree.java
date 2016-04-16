package model.tree.sequential;

import java.util.ArrayList;

import model.tree.Tree;
import model.tree.TreeNode;

public class SequentialTree<T extends SequentialTree<T, N>, N extends SequentialTreeNode<N>>
		extends Tree<N> {

	private int currentNode;
	private ArrayList<N> sequentialTree = new ArrayList<N>();

	@Override
	public boolean hasParentNode() {
		return !isRoot();
	}

	@Override
	public boolean hasLeftNode() {
		int leftNeighborPos = 2 * currentNode + 1;
		if (leftNeighborPos < sequentialTree.size()) {
			TreeNode leftNeighbor = sequentialTree.get(leftNeighborPos);
			if (leftNeighbor != null)
				return true;
		}
		return false;
	}

	@Override
	public boolean hasRightNode() {
		int rightNeighborPos = 2 * currentNode + 2;
		if (rightNeighborPos < sequentialTree.size()) {
			TreeNode rightNeighbor = sequentialTree.get(rightNeighborPos);
			if (rightNeighbor != null)
				return true;
		}
		return false;
	}

	@Override
	public boolean moveToRoot() {
		if (sequentialTree.isEmpty())
			return false;
		if (sequentialTree.get(0) != null) {
			currentNode = 0;
			return true;
		} else
			return false;
	}

	@Override
	public boolean moveToLeftNode() {
		if (this.hasLeftNode()) {
			currentNode = 2 * currentNode + 1;
			return true;
		} else
			return false;
	}

	@Override
	public boolean moveToRightNode() {
		if (this.hasRightNode()) {
			currentNode = 2 * currentNode + 2;
			return true;
		} else
			return false;
	}

	@Override
	public boolean moveToParentNode() {
		if (this.hasParentNode()) {
			currentNode = (currentNode - 1) / 2;
			return true;
		} else
			return false;
	}

	@Override
	public boolean setLeftNode(N node) {
		if (sequentialTree.get(currentNode) != null) {
			ensureSize();
			sequentialTree.set(2 * currentNode + 1, node);
			return true;
		} else
			return false;
	}

	@Override
	public boolean setRightNode(N node) {
		if (sequentialTree.get(currentNode) != null) {
			ensureSize();
			sequentialTree.set(2 * currentNode + 2, node);
			return true;
		} else
			return false;
	}

	@Override
	public void setCurrentNode(N node) {
		if (sequentialTree.isEmpty())
			sequentialTree.add(node);
		else
			sequentialTree.set(currentNode, node);
	}

	@Override
	public N getCurrentNode() {
		if (sequentialTree.isEmpty())
			return null;

		return sequentialTree.get(currentNode);
	}

	@Override
	public void clear() {
		sequentialTree.clear();
		currentNode = 0;
	}

	private boolean isRoot() {
		if (currentNode == 0)
			return true;
		else
			return false;
	}

	private void ensureSize() {
		int leftNodePos = 2 * currentNode + 1;
		int rightNodePos = leftNodePos + 1;
		int size = sequentialTree.size();

		if (sequentialTree.get(currentNode) != null) {
			if (rightNodePos >= size) {
				for (int i = currentNode; i < rightNodePos; i++) {
					sequentialTree.add(null);
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public SequentialTreeNodeFactory<N> getFactory() {
		return new SequentialTreeNodeFactory<N>();
	}

}
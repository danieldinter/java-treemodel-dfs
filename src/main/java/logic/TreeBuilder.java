package logic;

import model.tree.Tree;
import model.tree.TreeNode;

public class TreeBuilder<T extends Tree<N>, N extends TreeNode> {

	protected T tree;

	public void createTree(int steps) throws IllegalAccessException {
		if (tree == null)
			throw new IllegalAccessException(
					"Please use a subtype of the TreeBuilder to build a tree");

		if (steps < 1)
			return;

		if (tree.getCurrentNode() == null) {
			tree.setCurrentNode(tree.getFactory().getNode());
		}

		if (!tree.hasLeftNode())
			tree.setLeftNode(tree.getFactory().getNode());

		if (!tree.hasRightNode())
			tree.setRightNode(tree.getFactory().getNode());

		tree.moveToLeftNode();
		createTree(steps - 1);
		tree.moveToParentNode();

		tree.moveToRightNode();
		createTree(steps - 1);
		tree.moveToParentNode();
	}

	public T getTree() {
		return tree;
	}
}
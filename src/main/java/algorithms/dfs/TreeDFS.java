package algorithms.dfs;

import model.tree.Tree;
import model.tree.TreeNode;
import algorithms.TreeTraversal;
import algorithms.actions.TreeAction;
import algorithms.actions.TreeModifyAction;
import algorithms.actions.TreeSearchAction;

public class TreeDFS<T extends Tree<N>, N extends TreeNode> implements
		TreeTraversal<T, N> {

	public void dfs(T tree, TreeAction<N> action) {
		N node = null;

		if (tree != null) {
			node = tree.getCurrentNode();
		}

		if (node == null)
			return;

		if(action instanceof TreeSearchAction<?>)
			((TreeSearchAction<N>) action).perform(node);
		if(action instanceof TreeModifyAction<?>)
			tree.setCurrentNode(((TreeModifyAction<N>) action).perform(node));

		if (tree.moveToLeftNode()) {
			dfs(tree, action);
			tree.moveToParentNode();
		}

		if (tree.moveToRightNode()) {
			dfs(tree, action);
			tree.moveToParentNode();
		}

	}
	
	public void dfsPostOrder(T tree, TreeAction<N> action) {
		N node = null;

		if (tree != null) {
			node = tree.getCurrentNode();
		}

		if (node == null)
			return;

		if (tree.moveToLeftNode()) {
			dfsPostOrder(tree, action);
			tree.moveToParentNode();
		}

		if (tree.moveToRightNode()) {
			dfsPostOrder(tree, action);
			tree.moveToParentNode();
		}
		
		if(action instanceof TreeSearchAction<?>)
			((TreeSearchAction<N>) action).perform(node);
		if(action instanceof TreeModifyAction<?>)
			tree.setCurrentNode(((TreeModifyAction<N>) action).perform(node));
	}

}
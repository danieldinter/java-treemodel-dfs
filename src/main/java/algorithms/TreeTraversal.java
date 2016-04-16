package algorithms;

import model.tree.Tree;
import model.tree.TreeNode;
import algorithms.actions.TreeAction;

public interface TreeTraversal<T extends Tree<N>, N extends TreeNode> {

	public void dfs(T tree, TreeAction<N> action);

}
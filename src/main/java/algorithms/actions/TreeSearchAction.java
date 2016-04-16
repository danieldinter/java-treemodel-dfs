package algorithms.actions;

import model.tree.TreeNode;

public interface TreeSearchAction<N extends TreeNode> extends TreeAction<N> {

	void perform(N node);

}
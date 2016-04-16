package algorithms.actions;

import model.tree.TreeNode;

public interface TreeModifyAction<N extends TreeNode> extends TreeAction<N> {

	N perform(N node);

}
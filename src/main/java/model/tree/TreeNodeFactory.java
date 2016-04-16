package model.tree;

public abstract class TreeNodeFactory<N extends TreeNode> {

	public abstract N getNode();

}
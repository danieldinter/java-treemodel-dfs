package model.tree;

public abstract class Tree<N extends TreeNode> {

	public abstract boolean hasParentNode();

	public abstract boolean hasLeftNode();

	public abstract boolean hasRightNode();

	public abstract boolean moveToRoot();

	public abstract boolean moveToLeftNode();

	public abstract boolean moveToRightNode();

	public abstract boolean moveToParentNode();

	public abstract boolean setLeftNode(N node);

	public abstract boolean setRightNode(N node);

	public abstract void setCurrentNode(N node);

	public abstract N getCurrentNode();

	public abstract void clear();

	public abstract <F extends TreeNodeFactory<N>> F getFactory();

}
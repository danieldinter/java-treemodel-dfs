package model.tree.linked;

import model.tree.TreeNodeFactory;

public class LinkedTreeNodeFactory<N extends LinkedTreeNode<N>> extends
		TreeNodeFactory<N> {

	/**
	 * Should be overridden by subtype
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public N getNode() {
		return (N) new LinkedTreeNode();
	}

}
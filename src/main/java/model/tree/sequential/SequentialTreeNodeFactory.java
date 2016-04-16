package model.tree.sequential;

import model.tree.TreeNodeFactory;

public class SequentialTreeNodeFactory<N> extends
		TreeNodeFactory<SequentialTreeNode<N>> {

	public SequentialTreeNode<N> getNode() {
		return new SequentialTreeNode<N>();
	}

}
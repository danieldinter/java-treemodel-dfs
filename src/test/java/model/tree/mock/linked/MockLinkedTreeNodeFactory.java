package model.tree.mock.linked;

import model.tree.linked.LinkedTreeNodeFactory;

public class MockLinkedTreeNodeFactory extends
		LinkedTreeNodeFactory<MockLinkedTreeNode> {

	@Override
	public MockLinkedTreeNode getNode() {
		return new MockLinkedTreeNode();
	}

}
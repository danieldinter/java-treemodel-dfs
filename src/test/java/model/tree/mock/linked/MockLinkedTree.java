package model.tree.mock.linked;

import model.tree.linked.LinkedTree;

public class MockLinkedTree extends
		LinkedTree<MockLinkedTree, MockLinkedTreeNode> {

	@SuppressWarnings("unchecked")
	@Override
	public MockLinkedTreeNodeFactory getFactory() {
		return new MockLinkedTreeNodeFactory();
	}

}
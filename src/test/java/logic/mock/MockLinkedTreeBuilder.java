package logic.mock;

import logic.TreeBuilder;
import model.tree.mock.linked.MockLinkedTree;
import model.tree.mock.linked.MockLinkedTreeNode;

public class MockLinkedTreeBuilder extends
		TreeBuilder<MockLinkedTree, MockLinkedTreeNode> {

	public MockLinkedTreeBuilder() {
		tree = new MockLinkedTree();
	}

}
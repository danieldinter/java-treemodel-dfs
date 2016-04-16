package test.tree.sequential;

import model.tree.Tree;
import model.tree.mock.sequential.MockSequentialTree;
import model.tree.mock.sequential.MockSequentialTreeNode;
import test.tree.AbstractTreeTest;

public class MockSequentialTreeTest extends
		AbstractTreeTest<MockSequentialTreeNode> {

	@Override
	protected Tree<MockSequentialTreeNode> getTreeImplementation() {
		return new MockSequentialTree();
	}

}
package algorithms.mock;

import model.tree.mock.linked.MockLinkedTreeNode;

public abstract class MockLinkedTreeSearchAction implements
		algorithms.actions.TreeSearchAction<MockLinkedTreeNode> {

	public abstract void perform(MockLinkedTreeNode node);

}
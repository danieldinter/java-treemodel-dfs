package algorithms.dfs.mock;

import model.tree.mock.linked.MockLinkedTree;
import model.tree.mock.linked.MockLinkedTreeNode;
import algorithms.dfs.TreeDFS;
import algorithms.mock.MockLinkedTreeSearchAction;

public class MockLinkedTreeMeasurer extends
		TreeDFS<MockLinkedTree, MockLinkedTreeNode> {

	private int nodes;

	public int countNodes(final MockLinkedTree tree) {
		nodes = 0;

		dfs(tree, new MockLinkedTreeSearchAction() {

			public void perform(MockLinkedTreeNode node) {
				nodes = nodes + 1;

				if (tree.moveToLeftNode())
					perform(tree.getCurrentNode());

				return;
			}
		});

		return nodes;
	}

}
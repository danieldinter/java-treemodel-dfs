package test.tree.linked;

import static org.junit.Assert.assertEquals;
import logic.mock.MockLinkedTreeBuilder;
import model.tree.Tree;
import model.tree.mock.linked.MockLinkedTree;
import model.tree.mock.linked.MockLinkedTreeNode;

import org.junit.Test;

import test.tree.AbstractTreeTest;
import algorithms.dfs.mock.MockLinkedTreeMeasurer;

public class MockLinkedTreeTest extends AbstractTreeTest<MockLinkedTreeNode> {

	@Override
	protected Tree<MockLinkedTreeNode> getTreeImplementation() {
		return new MockLinkedTree();
	}

	@Test
	public void testTreeMeasurer() throws IllegalAccessException {
		int steps = 2;
		MockLinkedTreeBuilder mltb = new MockLinkedTreeBuilder();
		mltb.createTree(steps);
		MockLinkedTree mlt = mltb.getTree();

		MockLinkedTreeMeasurer mltm = new MockLinkedTreeMeasurer();

		assertEquals(pow(2, steps) - 1, mltm.countNodes(mlt));
	}

	@Test
	public void testPow() {
		assertEquals(1, pow(2, 0)); // 2^0 = 1
		assertEquals(2, pow(2, 1)); // 2^1 = 2
		assertEquals(4, pow(2, 2)); // 2^2 = 4
		assertEquals(8, pow(2, 3)); // 2^3 = 8
	}

	private int pow(int n, int i) {
		int res = 1;
		for (int j = 1; j <= i; j++) {
			res = res * n;
		}
		return res;
	}

}
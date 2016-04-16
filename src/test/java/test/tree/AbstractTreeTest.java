package test.tree;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import model.tree.Tree;
import model.tree.TreeNode;

import org.junit.Before;
import org.junit.Test;

public abstract class AbstractTreeTest<N extends TreeNode> {

	protected abstract Tree<N> getTreeImplementation();

	Tree<N> tree;

	@Before
	public void setUp() {
		tree = getTreeImplementation();
	}

	@Test
	public void canSetRoot() {
		N node = tree.getFactory().getNode();
		tree.setCurrentNode(node);
		assertSame(node, tree.getCurrentNode());
	}

	@Test
	public void canAddLeft() {
		N root = tree.getFactory().getNode();
		tree.setCurrentNode(root);

		N left = tree.getFactory().getNode();

		tree.setLeftNode(left);
		assertTrue(tree.moveToLeftNode());

		assertNotNull(tree);
		assertSame(left, tree.getCurrentNode());
	}

	@Test
	public void hasLeftNodeWorks() {
		assertFalse(tree.hasLeftNode());

		N root = tree.getFactory().getNode();
		tree.setCurrentNode(root);

		assertFalse(tree.hasLeftNode());

		N left = tree.getFactory().getNode();
		tree.setLeftNode(left);

		assertTrue(tree.hasLeftNode());
	}

	@Test
	public void hasRightNodeWorks() {
		assertFalse(tree.hasRightNode());

		N root = tree.getFactory().getNode();
		tree.setCurrentNode(root);

		assertFalse(tree.hasRightNode());

		N right = tree.getFactory().getNode();
		tree.setRightNode(right);

		assertTrue(tree.hasRightNode());
	}

	@Test
	public void emptyTreeDoesNotHaveAParentNode() {
		assertFalse(tree.hasParentNode());
	}

	@Test
	public void canAddRight() {
		N root = tree.getFactory().getNode();
		tree.setCurrentNode(root);

		N right = tree.getFactory().getNode();

		tree.setRightNode(right);
		assertTrue(tree.moveToRightNode());

		assertSame(right, tree.getCurrentNode());
	}

	@Test
	public void getCurrentNodeOnEmptyTreeReturnsNull() {
		assertNull(tree.getCurrentNode());
	}

	@Test
	public void moveToLeftNodeFailsOnEmptyTree() {
		assertFalse(tree.moveToLeftNode());
	}

	@Test
	public void moveToRightNodeFailsOnEmptyTree() {
		assertFalse(tree.moveToRightNode());
	}

	@Test
	public void canClearEmptyTree() {
		tree.clear();

		assertNull(tree.getCurrentNode());
	}

	@Test
	public void clearTreeClearsRoot() {
		N root = tree.getFactory().getNode();
		N left = tree.getFactory().getNode();
		N right = tree.getFactory().getNode();

		tree.setCurrentNode(root);
		tree.setLeftNode(left);
		tree.setRightNode(right);

		assertTrue(tree.hasLeftNode());
		assertTrue(tree.hasRightNode());

		tree.clear();

		assertNull(tree.getCurrentNode());
		assertFalse(tree.hasLeftNode());
		assertFalse(tree.hasRightNode());
		assertFalse(tree.moveToLeftNode());
		assertFalse(tree.moveToRightNode());
	}

	@Test
	public void clearTreeWorksFromLeftNode() {
		N root = tree.getFactory().getNode();
		N left = tree.getFactory().getNode();
		N right = tree.getFactory().getNode();

		tree.setCurrentNode(root);
		tree.setLeftNode(left);
		tree.setRightNode(right);

		assertTrue(tree.moveToLeftNode());
		tree.clear();

		assertNull(tree.getCurrentNode());
		assertFalse(tree.hasLeftNode());
		assertFalse(tree.hasRightNode());
		assertFalse(tree.hasParentNode());
	}

	@Test
	public void clearTreeWorksFromRightNode() {
		N root = tree.getFactory().getNode();
		N left = tree.getFactory().getNode();
		N right = tree.getFactory().getNode();

		tree.setCurrentNode(root);
		tree.setLeftNode(left);
		tree.setRightNode(right);

		assertTrue(tree.moveToRightNode());
		tree.clear();

		assertNull(tree.getCurrentNode());
		assertFalse(tree.hasLeftNode());
		assertFalse(tree.hasRightNode());
		assertFalse(tree.hasParentNode());
	}

	@Test
	public void canMoveBackToRootFromLeftSubtree() {
		N root = tree.getFactory().getNode();
		N left = tree.getFactory().getNode();

		tree.setCurrentNode(root);
		tree.setLeftNode(left);

		tree.moveToLeftNode();
		assertSame(left, tree.getCurrentNode());

		tree.moveToParentNode();
		assertSame(root, tree.getCurrentNode());
	}

	@Test
	public void canMoveBackToRootFromRightSubtree() {
		N root = tree.getFactory().getNode();
		N right = tree.getFactory().getNode();

		tree.setCurrentNode(root);
		tree.setRightNode(right);

		tree.moveToRightNode();
		assertSame(right, tree.getCurrentNode());

		tree.moveToParentNode();
		assertSame(root, tree.getCurrentNode());
	}

	@Test
	public void moveToRootOnEmptyRootIsFalse() {
		assertFalse(tree.moveToRoot());
	}

	@Test
	public void moveToRootWorksFromLeftNode() {
		N root = tree.getFactory().getNode();
		N left = tree.getFactory().getNode();

		tree.setCurrentNode(root);
		tree.setLeftNode(left);

		assertTrue(tree.moveToLeftNode());

		assertTrue(tree.moveToRoot());

		assertSame(root, tree.getCurrentNode());
	}

	@Test
	public void hasParentNodeIsFalseForEmptyTree() {
		assertFalse(tree.hasParentNode());
	}

	@Test
	public void hasParentNodeWorks() {
		N root = tree.getFactory().getNode();
		N left = tree.getFactory().getNode();

		tree.setCurrentNode(root);
		assertTrue(tree.setLeftNode(left));

		assertTrue(tree.moveToLeftNode());
		assertTrue(tree.hasParentNode());
	}

	@Test
	public void canSetCurrentNodeToNull() {
		tree.setCurrentNode(null);
	}

	@Test
	public void canSetLeftNodeToNull() {
		N root = tree.getFactory().getNode();
		tree.setCurrentNode(root);
		tree.setLeftNode(null);
	}

	@Test
	public void canSetRightNodeToNull() {
		N root = tree.getFactory().getNode();
		tree.setCurrentNode(root);
		tree.setRightNode(null);

		assertFalse(tree.moveToRightNode());
	}

	@Test
	public void anEmptyTreeEqualsItself() {
		assertTrue(tree.equals(tree));
	}

	@Test
	public void aTreeIsNotEqualToNull() {
		assertFalse(tree.equals(null));
	}

	@Test
	public void parentNodeKnowsOfChangedChildrenOnTheLeftSide() {
		N root = tree.getFactory().getNode();
		N left1 = tree.getFactory().getNode();
		N left2 = tree.getFactory().getNode();

		// Set tree
		// R * current
		// /
		// L1
		tree.setCurrentNode(root);
		assertTrue(tree.setLeftNode(left1));

		// Move to left node
		// R
		// /
		// L1 * current
		assertTrue(tree.moveToLeftNode());
		assertSame(left1, tree.getCurrentNode());

		// Replace left node
		// R
		// /
		// L2 * current
		tree.setCurrentNode(left2);
		assertSame(left2, tree.getCurrentNode());

		// Move up
		// R * current
		// /
		// L2
		assertTrue(tree.hasParentNode());
		assertTrue(tree.moveToParentNode());
		assertSame(root, tree.getCurrentNode());

		// Move to left node again
		// R
		// /
		// L1 * current
		assertTrue(tree.moveToLeftNode());

		// The left mode must be the one set last.
		assertSame(left2, tree.getCurrentNode());
	}

	@Test
	public void parentNodeKnowsOfChangedChildrenOnTheRightSide() {
		N root = tree.getFactory().getNode();
		N right1 = tree.getFactory().getNode();
		N right2 = tree.getFactory().getNode();

		// Set tree
		// R * current
		// \
		// R1
		tree.setCurrentNode(root);
		assertTrue(tree.setRightNode(right1));

		// Move to right node
		// R
		// \
		// R1 * current
		assertTrue(tree.moveToRightNode());
		assertSame(right1, tree.getCurrentNode());

		// Replace right node
		// R
		// \
		// R2 * current
		tree.setCurrentNode(right2);
		assertSame(right2, tree.getCurrentNode());

		// Set tree
		// R * current
		// \
		// R2
		assertTrue(tree.hasParentNode());
		assertTrue(tree.moveToParentNode());
		assertSame(root, tree.getCurrentNode());

		// Move to right node again
		// R
		// \
		// R2 * current
		assertTrue(tree.moveToRightNode());

		// The right mode must be the one set right.
		assertSame(right2, tree.getCurrentNode());
	}

	@Test
	public void complexTreeHasCorrectRoot() {
		N rootNode = tree.getFactory().getNode();

		/**
		 * <code>
		 *                Root
		 *                 |
		 *          +------+----------+
		 *         /                   \
		 *        L                     R
		 *        |                    /
		 *     +--+--+                /
		 *    /       \              /
		 *   LL       LR            RL
		 *  /  \     /  \          /  \ 
		 * LLL LLR LRL  LRR      RLL  RLR
		 *                           /
		 *                         RLRL
		 * </code>
		 */
		tree.setCurrentNode(rootNode); // Root
		tree.setLeftNode(tree.getFactory().getNode()); // L
		tree.moveToLeftNode();
		tree.setLeftNode(tree.getFactory().getNode()); // LL
		tree.moveToLeftNode();
		tree.setLeftNode(tree.getFactory().getNode()); // LLL
		tree.setRightNode(tree.getFactory().getNode()); // LLR
		tree.moveToParentNode();
		tree.setRightNode(tree.getFactory().getNode()); // LR
		tree.moveToRightNode();
		tree.setLeftNode(tree.getFactory().getNode()); // LRL
		tree.setRightNode(tree.getFactory().getNode()); // LRR

		assertTrue(tree.moveToRoot()); // MOVE TO ROOT, DOES IT WORK?!
		assertSame(rootNode, tree.getCurrentNode());

		tree.setRightNode(tree.getFactory().getNode()); // R
		tree.moveToRightNode();
		tree.setLeftNode(tree.getFactory().getNode()); // RL
		tree.moveToLeftNode();
		tree.setLeftNode(tree.getFactory().getNode()); // RLL
		tree.moveToParentNode();
		tree.setRightNode(tree.getFactory().getNode()); // RLR
		tree.moveToRightNode();
		tree.setLeftNode(tree.getFactory().getNode()); // RLRL

		assertTrue(tree.moveToParentNode());
		assertTrue(tree.moveToParentNode());
		assertSame(rootNode, tree.getCurrentNode());
		assertFalse(tree.moveToParentNode());
		assertSame(rootNode, tree.getCurrentNode());
	}

}
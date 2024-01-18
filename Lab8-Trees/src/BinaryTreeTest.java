import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class BinaryTreeTest {

	BinaryTree<Integer> intTestTree() {
		return BinaryTree.createTree(1, BinaryTree.createTree(2, BinaryTree.createTree(4), BinaryTree.createTree(5)),
				BinaryTree.createTree(3, BinaryTree.createTree(6), BinaryTree.createTree(7)));
	}

	@Test
	public void preOrderTraversal_ShouldReturnExpectedOrder() {
		var tree = intTestTree();
		var expectedOrder = List.of(1, 2, 4, 5, 3, 6, 7);

		assertEquals(expectedOrder, BinaryTree.preOrderTraversal(tree));
	}

	@Test
	public void inOrderTraversal_ShouldReturnExpectedOrder() {
		var tree = intTestTree();
		var expectedOrder = List.of(4, 2, 5, 1, 6, 3, 7);

		assertEquals(expectedOrder, BinaryTree.inOrderTraversal(tree));
	}

	@Test
	public void postOrderTraversal_ShouldReturnExpectedOrder() {
		var tree = intTestTree();
		var expectedOrder = List.of(4, 5, 2, 6, 7, 3, 1);

		assertEquals(expectedOrder, BinaryTree.postOrderTraversal(tree));
	}

	@Test
	public void equals_TreesAreEqual_ShouldReturnTrue() {
		var first = BinaryTree.createTree(5, BinaryTree.createTree(10), null);
		var second = BinaryTree.createTree(5, BinaryTree.createTree(10), null);

		assertEquals(first, second);
	}

	@Test
	public void equals_TreesAreNotEqual_ShouldReturnTrue() {
		var first = BinaryTree.createTree(5, BinaryTree.createTree(10), null);
		var second = BinaryTree.createTree(5, BinaryTree.createTree(10), BinaryTree.createTree(20));

		assertNotEquals(first, second);
	}
}

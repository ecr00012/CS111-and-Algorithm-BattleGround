import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class BinarySearchTreeTest {

	@Test
	public void add_OnlyOne_ShouldWorkCorrectly() {
		var bst = new BinarySearchTree();
		bst.add(5);
		assertEquals(List.of(5), BinaryTree.inOrderTraversal(bst.tree));
	}

	@Test
	public void add_Several_ShouldBuildInCorrectOrder() {
		var bst = new BinarySearchTree();
		var input = List.of(42, 55, 89, 0, 22, 102);
		var expectedTree = BinaryTree.createTree(42, BinaryTree.createTree(0, null, BinaryTree.createTree(22)),
				BinaryTree.createTree(55, null, BinaryTree.createTree(89, null, BinaryTree.createTree(102))));

		input.forEach(bst::add);

		assertEquals(expectedTree, bst.tree);
	}

	@Test
	public void contains_IsInTree_ShouldReturnTrue() {
		var bst = new BinarySearchTree();
		var input = List.of(42, 55, 89, 0, 22, 102);
		bst.addAll(input);

		assertTrue(bst.contains(0));
	}

	@Test
	public void contains_IsNotInTree_ShouldReturnTrue() {
		var bst = new BinarySearchTree();
		var input = List.of(42, 55, 89, 0, 22, 102);
		bst.addAll(input);

		assertFalse(bst.contains(Integer.MIN_VALUE));
	}

}

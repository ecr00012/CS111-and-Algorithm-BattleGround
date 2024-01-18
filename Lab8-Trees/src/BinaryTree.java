import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Basically the node class from the slides just called BinaryTree itself.
 * 
 * You must implement the traversal algorithms in the static methods
 * below...Look over slides to familiarize yourself with how they work
 * 
 * Replace name below
 * 
 * @author zadidhabib
 *
 * @param <E>
 */
public class BinaryTree<E> {
	E item;
	BinaryTree<E> leftSubtree;
	BinaryTree<E> rightSubtree;

	public boolean isLeaf() {
		
		return leftSubtree == null && rightSubtree == null;
	}

	public BinaryTree(E item) {
		
		this.item = item;
	}

	public BinaryTree(E item, BinaryTree<E> left, BinaryTree<E> right) {
		
		this.item = item;
		this.leftSubtree = left;
		this.rightSubtree = right;
	}

	public static <T> BinaryTree<T> createTree(T item) {
		
		return new BinaryTree<T>(item);
	}

	public static <T> BinaryTree<T> createTree(T item, BinaryTree<T> left, BinaryTree<T> right) {
		
		return new BinaryTree<T>(item, left, right);
	}

	/**
	 * Return a list with all the element of a tree gathered using pre-order
	 * traversal
	 * 
	 * @param <T>  the Type of the tree
	 * @param tree the tree
	 * @return a list of the tree's elements in pre-order order
	 */
	public static <T> List<T> preOrderTraversal(BinaryTree<T> tree) {
		
		//Complete this portion
		ArrayList<T> list = new ArrayList<T>();
		if (tree == null)
			return list;
		//Hint1: check if the current node in the binary tree is a leaf node. 
		//Hint1: If it is, then it creates a new List with a single element containing the value of the leaf node, and return it. 
		//Hint1: This is the base case of the recursive function.
		
		
		//Hint3: recursively call the preOrderTraversal method on the left subtree of the current node 
		//Hint3: and add all its elements to the list ArrayList.
		list.add(tree.item);
		list.addAll(preOrderTraversal(tree.leftSubtree));
		
		//Hint4: recursively call the preOrderTraversal method on the right subtree of the current node 
		//Hint4: and add all its elements to the list ArrayList.
		list.addAll(preOrderTraversal(tree.rightSubtree));
		
		//Hint5: Return the list
		return list;
	}

	/**
	 * Return a list with all the element of a tree gathered using in-order
	 * traversal
	 * 
	 * @param <T>  the Type of the tree
	 * @param tree the tree
	 * @return a list of the tree's elements in in-order order
	 */
	public static <T> List<T> inOrderTraversal(BinaryTree<T> tree) {
		//Complete this portion
		ArrayList<T> list = new ArrayList<T>();
		//Hint1: check if the current node in the binary tree is a leaf node. 
		//Hint1: If it is, then it creates a new List with a single element containing the value of the leaf node, and return it. 
		//Hint1: This is the base case of the recursive function.
		if (tree == null)
			{ return list;}
		list.addAll(inOrderTraversal(tree.leftSubtree));
		list.add(tree.item);
		list.addAll(inOrderTraversal(tree.rightSubtree));
		return list;
	}

	/**
	 * Return a list with all the element of a tree gathered using post-order
	 * traversal
	 * 
	 * @param <T>  the Type of the tree
	 * @param tree the tree
	 * @return a list of the tree's elements in post-order order
	 */
	public static <T> List<T> postOrderTraversal(BinaryTree<T> tree) {
		
		ArrayList<T> list = new ArrayList<T>();
		if (tree == null)
			return list;
		list.addAll(postOrderTraversal(tree.leftSubtree));
		list.addAll(postOrderTraversal(tree.rightSubtree));
		
		list.add(tree.item);
		return list;
	}

	@Override
	public int hashCode() {
		
		final int prime = 31;
		int result = 1;
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + ((leftSubtree == null) ? 0 : leftSubtree.hashCode());
		result = prime * result + ((rightSubtree == null) ? 0 : rightSubtree.hashCode());
		return result;
	}

	
	@Override
	public boolean equals(Object obj) {
		//Complete this portion
		
		//HInt1: check if the two BinaryTree objects are the same object. 
		//Hint1: If they are, then they are equal, so it returns true.
					if (obj == this)
						return true;
		//Hint2: check if the obj parameter is null. 
		//Hint2: If it is, then the two BinaryTree objects cannot be equal, so it returns false.
					if (obj == null)
						return false;
		//	Hint3: check if the obj parameter is an instance of the BinaryTree class. 
		//Hint3: If it isn't, then the two BinaryTree objects cannot be equal, so it returns false.
						if (!(obj instanceof BinaryTree))
							return false;
		BinaryTree<?> other = (BinaryTree<?>) obj; //This line casts the obj parameter to a BinaryTree object, since it has been verified to be an instance of the BinaryTree class.
		
		
		
		//Hint4: compare the item field of the two BinaryTree objects for equality. 
		//Hint4: If the item field of one object is null and the other is not, or if the item fields of both objects are not equal, 
		//Hint4: then the two BinaryTree objects cannot be equal, so it returns false.
		if (this.hashCode() != other.hashCode())
			return false;
		
		//Hint5: compare the leftSubtree field of the two BinaryTree objects for equality.
		//Hint5: If the leftSubtree field of one object is null and the other is not, or if the leftSubtree fields of both objects are not equal, 
		//Hint5: then the two BinaryTree objects cannot be equal, so it returns false.
		
		//Hint6: compare the rightSubtree field of the two BinaryTree objects for equality.
		//Hint6: If the rightSubtree field of one object is null and the other is not, or if the rightSubtree fields of both objects are not equal, 
		//Hint6: then the two BinaryTree objects cannot be equal, so it returns false.
		
		//Hint7: If none of the previous conditions have been met, then the two BinaryTree objects must be equal, so it returns true.
		return true;
	}
}

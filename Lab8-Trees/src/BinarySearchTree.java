import java.util.Collection;

/**
 * Look over the slides to be sure how a BinarySearchTree works
 * 
 * Replace name below
 * 
 * @author zadidhabib
 *
 */
public class BinarySearchTree {
	BinaryTree<Integer> tree; // if null this means it's an empty tree

	/**
	 * Checks if a int x is in the BinarySearchTree
	 * 
	 * @param x the integer to search for
	 * @return true if x is in the tree, false otherwise
	 */
	public boolean contains(int x) {
		
		return contains(tree, x);
	}

	/**
	 * Recursive private method to check for an Integer in a BST
	 * 
	 * 
	 * @param t BinaryTree to search
	 * @param x Integer to search for
	 * @return true if x is in the tree, false otherwise
	 */
	private boolean contains(BinaryTree<Integer> t, int x) {
		//Complete this portion
		
		//Hint1: check if the t parameter is null. 
		//Hint1: If it is, then the BinaryTree object does not contain the integer value x, so it returns false.
		if (t == null)
			return false;
		//Hint2: check if the item field of the t parameter is equal to the integer value x. 
		//Hint2: If it is, then the BinaryTree object contains the integer value x, so it returns true.
		if (t.item == x)
			return true;
		//Hint3: check if the integer value x is less than the item field of the t parameter. 
		//Hint3: If it is, then the method recursively calls itself with the leftSubtree field of the t parameter and the integer value x as parameters.
		if (x < t.item)
			return contains(t.leftSubtree, x);
	    //HInt4:  check if the integer value x is greater than the item field of the t parameter. 
	   //Hint4: If it is, then the method recursively calls itself with the rightSubtree field of the t parameter and the integer value x as parameters.	
		if (x > t.item)
			return contains(t.rightSubtree, x);
		//Hint5: if none of the previous conditions are met then the method has reached this point, 
		//Hint5: then the BinaryTree object does not contain the integer value x, so it returns false.
		return false;
	}

	/**
	 * Add a item in a BST.
	 * 
	 * Add must enforce the BinaryTree to obey the laws of a BST
	 * 
	 * Check the slides to look over how nodes have to be added to the BST.
	 * 
	 * @param x Integer to add
	 */
	public void add(Integer x) {
		//Complete this portion
	
		//Hint1: call add method with the tree field of the BinaryTree object and the integer value x as parameters. 
		//Hint1: The returned BinaryTree object is then assigned to the tree field of the BinaryTree object.
		tree = add(tree, x);
	}

	/**
	 * Private method to Add a item in a BST, Recursively
	 * 
	 * Add must enforce the BinaryTree to obey the laws of a BST
	 * 
	 * Check the slides to look over how nodes have to be added to the BST.
	 * 
	 * @param t BinaryTree to add to
	 * @param x Integer to add
	 */
	private BinaryTree<Integer> add(BinaryTree<Integer> t, Integer x) {
		//Complete this portion
		
		//Hint1: check if the t parameter is null. 
		//Hint1: If it is, then it creates a new BinaryTree object with the integer value x as the item field and null as both the leftSubtree and rightSubtree fields, and returns it.
		if (t == null)
			{
			t = new BinaryTree<Integer>(x, null, null);
			return t;
			}
		//Hint2: check if the integer value x is less than the item field of the t parameter. 
		//Hint2: If it is, then it recursively calls the add method with the leftSubtree field of the t parameter 
		//HInt2: and the integer value x as parameters, and creates a new BinaryTree object with the item field of the t parameter 
		//Hint2: as its item field, the returned BinaryTree object as its leftSubtree field, 
		//Hint2: and the rightSubtree field of the t parameter as its rightSubtree field.
		if (x < t.item)
		{
			var left = add(t.leftSubtree, x);
			t = new BinaryTree<Integer>(t.item, left, t.rightSubtree );
			return t;
			
		}
		//Hint3: check if the integer value x is greater than the item field of the t parameter. 
		//Hint3: If it is, then it recursively calls the add method with the rightSubtree field of the t parameter and the integer value x as parameters, 
		//Hint3: and creates a new BinaryTree object with the item field of the t parameter as its item field, the leftSubtree field of the t parameter as its leftSubtree field, 
		//Hint3: and the returned BinaryTree object as its rightSubtree field.

		if (x > t.item)
		{
			var right = add(t.rightSubtree, x);
			t = new BinaryTree<Integer>(t.item, t.leftSubtree, right);
			return t;
			
			
		}
		//Hint4: if none of the previous conditions are met then the BinaryTree object already contains the integer value x, so it returns null.
		return null;
	}

	/**
	 * Adds a collection to the BinaryTree
	 * 
	 * This must still enforce the rules of the BST
	 * 
	 * 
	 * @param collection
	 */
	public void addAll(Collection<Integer> collection) {
		//Complete this portion
		
		//Hint1: use the forEach method of the collection parameter to iterate over each integer value in the collection, 
		//Hint1: and for each integer value, it calls the add method of the BinaryTree object with the integer value as a parameter. 
		//Hint1: This is equivalent to calling add on the BinaryTree object for each integer value in the collection.
		collection.forEach(x -> this.add(x));
		
	}

}

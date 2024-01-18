package project1.lists;

/**
* Custom Node Object for Linked List
*
* @author Eli Richmond
* @version 1.0
* @since 2023-03-10
*/
public class Node<E> {
	E item;
	Node<E> next;

//constructor
	public Node(E i) {
		this.item = i;
		next = null;
	}
// constructor
	public Node(E i, Node<E> next) {
		this.item = i;
		this.next = next;
	}
	
/* creates new Node<I>
 * @Returns Node<I> with field i for item
 */
	public static <I> Node<I> createNode(I i) {
		return new Node<I>(i);
	}

	/* creates new Node<I 
	 * @Returns Node<I> with fields i for item and next for reference to next Node
	 */
	public static <I> Node<I> createNode(I i, Node<I> next) {
		return new Node<I>(i, next);
	}
	
// @Returns Node's item
	public E getItem() {
		return item;
	}

	//@Returns next Node in list
	public Node<E> getNext() {
		return this.next;
	}

	// Sets next node in list to
	// @Param next 
	public void setNext(Node<E> next) {
		this.next = next;
	}

	// checks if current Node has next field
	public Boolean hasNext() {
		if (this.next != null)
			return true;
		else return false;
	}
}

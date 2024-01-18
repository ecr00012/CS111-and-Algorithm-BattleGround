package project1.lists;

/**
* Custom DoublyLinkedList Implementation
*
* @author Eli Richmond
* @version 1.0
* @since 2023-03-10
*/
public class DoublyLinkedNode<E> {
	E item;
	DoublyLinkedNode<E> next;
	DoublyLinkedNode<E> previous;

	// constructor with field for i item and reference to previous
	public DoublyLinkedNode(E i, DoublyLinkedNode<E> previous) {
		this.item = i;
		this.next = null;
		this.previous = previous;
		
	}
// constructor with fields for i item and next and previous nodes
	public DoublyLinkedNode(E i, DoublyLinkedNode<E> previous, DoublyLinkedNode<E> next) {
		this.item = i;
		this.next = next;
		this.previous = previous;
	}
	
	// constructor with field i for item
	public DoublyLinkedNode(E i) 
	{
		this.item = i;
		this.next = null;
		this.previous = null;
		
	}
	

	public static <I> DoublyLinkedNode<I> createDoublyLinkedNode(I i) {
		return new DoublyLinkedNode<I>(i);
	}

	public static <I> DoublyLinkedNode<I> createDoublyLinkedNode(I i, DoublyLinkedNode<I> next) {
		return new DoublyLinkedNode<I>(i, next);
	}

	// returns current DoublyLinkedNode's item
	public E getItem() {
		return this.item;
	}

	// returns the next DoublyLinkedNode when called with the current DoublyLinkedNode
	public DoublyLinkedNode<E> getNextNode() {
		return this.next;
	}
	
	// returns previous DoublyLinkedNode when called on the current DoublyLinkedNode
	public DoublyLinkedNode<E> getPreviousNode() 
	{
	return this.previous;
	}

	// sets Next DoublyLinkedNode to 
	//@Param next DoublyLinkedNode<E>
	public void setNext(DoublyLinkedNode<E> next) {
		this.next = next;
	}

	// @Returns true if next field for current Node is not null
	public Boolean hasNextNode() {
		if (this.next != null)
			return true;
		else return false;
	}
	
	
}

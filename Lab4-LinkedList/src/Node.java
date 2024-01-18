/**
 * Represents a node in a linked list
 * 
 * 
 * @author zadidhabib
 *
 * @param <E> Type variable
 */
public class Node<E> {
	E item;
	Node<E> next;

	public Node(E i) {
		this.item = i;
		next = null;
	}

	public Node(E i, Node<E> next) {
		this.item = i;
		this.next = next;
	}

	public static <I> Node<I> createNode(I i) {
		return new Node<I>(i);
	}

	public static <I> Node<I> createNode(I i, Node<I> next) {
		return new Node<I>(i, next);
	}

	public E getItem() {
		return item;
	}

	public Node<E> getNext() {
		return this.next;
	}

	public void setNext(Node<E> next) {
		this.next = next;
	}

	public Boolean hasNext() {
		return this.getNext() != null;
	}
}

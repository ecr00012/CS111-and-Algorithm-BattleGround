package lab3;

/**
 * Box represents a literal box. We can store almost anything inside the box,
 * however whatever is inside the box must implement the Comparable interface.
 * 
 * Example of how Box is used:
 *
 * Box<Integer> boxInt = new Box<Integer>();
 * 
 * Placing a Class Name inside the brackets is how we plug in the type for E.
 * 
 * @author zadidhabib
 *
 * @param <E> a type variable we can specify during instantiation. Whatever type
 *            E ends up being, it must implement the Comparable Interface.
 */
public class Box<E extends Comparable<E>> implements Comparable<Box<E>> {
	private E item; // We can use E here as the type of item, remember E is a variable for a type

	/**
	 * Default Constructor
	 * 
	 * @param item - Some value of type E, will box it up using the default
	 *             constructor
	 */
	public Box(E item) {
		this.item = item;
	}

	/**
	 * getItem
	 * 
	 * @return the value stored within the box
	 */
	public E getItem() {
		return this.item;
	}

	/**
	 * toString
	 * 
	 * As some of you may know, all Classes by default extend from Object. Object
	 * has a couple methods you can override to give your own implementation of.
	 * toString is automatically called in the System.out.print methods but on
	 * custom classes the default behavior is pretty unpleasant...
	 * 
	 * So we override it and give our own version! This is pretty common thing to do
	 * and it's very useful.
	 * 
	 * @return a custom string of this Box
	 */
	@Override
	public String toString() {
		return "Box " + item.toString();
	}

	/**
	 * compareTo
	 * 
	 * This method is what this lab is all about. compareTo comes from implementing
	 * the Comparable interface. compareTo allows you to pass in a Box and find out
	 * if that box is less then, greater then, or equal to this box.
	 * 
	 * this box refers to the box on the left of the '.' so box1.compareTo(box2).
	 * 
	 * @return - if this box is less then arg0 then return -1 else if this box is
	 *         greater then arg0 then return 1 else return 0
	 * 
	 */
	@Override
	public int compareTo(Box<E> arg0) {
		return this.getItem().compareTo(arg0.getItem());
	}

	/**
	 * equals
	 * 
	 * Another method that is overridden from Object. The default implemention of
	 * equals will only check if two things are the same reference. This overridden
	 * equals will check if the Object passed in is actually a Box then use the
	 * equals method on the items inside it to check for equality.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Box<?>) {
			var b = this.getClass().cast(obj);
			return b.getItem().equals(this.getItem());
		}
		return false;
	}
}

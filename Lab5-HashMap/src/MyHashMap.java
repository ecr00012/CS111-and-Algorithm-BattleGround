import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * MyHashMap
 * 
 * A custom implementation of a HashMap using buckets of size 1. Collision will
 * happen often because of this but it's okay for learning.
 * 
 * For a discription of what each method has to do visit here:
 * https://docs.oracle.com/javase/8/docs/api/java/util/Map.html#containsKey-java.lang.Object-
 * 
 * Replace your name below:
 * 
 * @author elirichmond
 * 
 **/
public class MyHashMap<K, V> implements Map<K, V> {

	private ArrayList<V> table;

	private int maxTableSize = 50;
	private int tableSize = 0;

	public MyHashMap() { // done

		table = new ArrayList<V>(); 
		this.clear();
	}

	public MyHashMap(int maxSize) { // done
		table = new ArrayList<V>(maxSize);
		maxTableSize = maxSize;
		this.clear();
		
		
		//Assign your input argument as the value to maxTableSize variable
		//Similarly use clear() method with this keyword
	}

	@Override
	public void clear() { // done
		table.clear();
		tableSize = 0;
		
		for (int i = 0; i < maxTableSize; i++)
			table.add(null);
		//Use a loop, continue the loop as long as it is less than the maxTableSize variable, and keep incrementing
		//Inside the loop body use the printing statement to something on the console
		//add null to the table. You can use add() method on table and pass null
	}

	private int getIndex(Object key) { // done
		return key.hashCode() % maxTableSize;
	}

	@Override
	public boolean containsKey(Object key) { // done
		
			
			return (this.get(key) != null);
		//Use a return statement and get the key whether it is not null, you can use with 'this' keyword
		
	}

	@Override
	public boolean containsValue(Object arg0) { 
		return table.stream().anyMatch((x) -> arg0.equals(x));
	}

	@Override
	public V get(Object key) { // done
		//You should have a variable for the index and assign the key as its value using getIndex() method
		//Use a return statement and get the index from table
		int index = getIndex(key);
		return table.get(index);
	}

	@Override
	public boolean isEmpty() {
		return tableSize == 0;
		//Use a return statement and return the table size as zero
		
	}

	@Override
	public V put(K key, V value) {
		
		//You should have a variable for the index and assign the key as its value using getIndex() method
		int index = this.getIndex(key);
		table.set(index, value);
		//Increment the table size
		tableSize++;
		//Use a return statement and return the value
return value;
	}

	@Override
	public V remove(Object key) {
		
		//You should have a variable for the index and assign the key as its value using getIndex() method, 
		//you can use 'this' keyword with getIndex() method
	var index = getIndex(key);
		//You should have a variable for value and get the index from the table
	var value = table.get(index);
		table.set(index, null);
		//Decrement the table size
		tableSize--;
		//Use a return statement and return the value
		return value;
	}

	@Override
	public int size() {
		//Use return statement and return table size
		return tableSize;
	}

	@Override
	public Collection<V> values() {
		//Use return statement and return table
		return table;
	}

	// Do not implement methods passed this point

	@Override
	public Set<Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<K> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> arg0) {

	}
}

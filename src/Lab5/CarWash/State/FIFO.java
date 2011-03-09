package Lab5.CarWash.State;

import java.util.Vector;
import java.lang.Iterable;
import java.util.Iterator;


/**
 * FIFO queue.
 * @author Andreas Nielsen, Fredrik Lind, Sebastian Larsson
 */
public class FIFO<T> implements Iterable<T> {
	private Vector<T> v = new Vector<T>();

	/**
	 * Initializes the FIFO.
	 */
	public FIFO() {
		v = new Vector<T>();
	}

	/**
	 * Inserts object into fifo.
	 */
	public void insert(T o) {
		v.add(o);
	}

	/**
	 * Gets the first object.
	 * @return first object.
	 */
	public T first() {
		return v.elementAt(0);
	}

	/**
	 * Gets number of objects in fifo.
	 * @return num elements.
	 */
	public int size() {
		return v.size();
	}

	/**
	 * Removes first object.
	 */
	public void removeFirst() {
		v.remove(0);
	}

	/**
	 * Checks if FIFO is empty.
	 * @return true if empty, false otherwise.
	 */
	public boolean isEmpty() {
		return v.isEmpty();
	}

	/**
	 * Gets an iterator for the FIFO.
	 * @return iterator
	 */
	public Iterator<T> iterator() {
		return v.iterator();
	}

}

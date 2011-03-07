package Lab5.CarWash.State;

import java.util.Vector;
import java.lang.Iterable;
import java.util.Iterator;


public class FIFO<T> implements Iterable<T> {
	private Vector<T> v = new Vector<T>();

	public FIFO() {
		v = new Vector<T>();
	}

	public void insert(T o) {
		v.add(o);
	}

	public T first() {
		return v.elementAt(0);
	}

	public int size() {
		return v.size();
	}

	public void removeFirst() {
		v.remove(0);
	}

	public boolean isEmpty() {
		return v.isEmpty();
	}

	public Iterator<T> iterator() {
		return v.iterator();
	}

}

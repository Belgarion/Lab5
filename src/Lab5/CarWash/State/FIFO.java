package Lab5.CarWash.State;

import java.util.Vector;

public class FIFO<T> implements java.lang.Iterable<T> {
	private Vector<T> v = new Vector<T>();
	private int currentElement = 0;

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

	public java.util.Iterator<T> iterator() {
		return v.iterator();
	}

}

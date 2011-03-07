package Lab5.CarWash.State;

import java.util.Vector;

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

	public T get(int index) {
		return v.get(index);
	}
}

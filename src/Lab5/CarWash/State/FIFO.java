package Lab5.CarWash.State;

import java.util.Vector;

public class FIFO<T> {
	private Vector<T> v;

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
}

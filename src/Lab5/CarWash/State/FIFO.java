package Lab5.CarWash.State;

import java.util.Vector;

public class FIFO {
	private Vector<Object> v;

	public void insert(Object o) {
		v.add(o);
	}

	public Object first() {
		return v.firstElement();
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

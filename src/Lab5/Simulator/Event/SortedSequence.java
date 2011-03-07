package Lab5.Simulator.Event;

import java.util.Vector;

public class SortedSequence<E extends Comparable<E>> {
	Vector<E> seq = new Vector<E>();

	public void insert(E o) {
		if (seq.isEmpty()) {
			seq.add(o);
		} else {
			int i = 0;
			for (;o.compareTo(seq.elementAt(i)) > 0 && i < seq.size() - 1; i++);
			seq.add( (o.compareTo(seq.get(seq.size() - 1)) < 0) ? i : i + 1, o);
		}
	}

	public int size() {
		return seq.size();
	}

	public void removeFirst() {
		if (seq.size() > 0) {
			seq.removeElementAt(0);
		}
	}

	public E first() {
		return seq.size() > 0 ? seq.elementAt(0) : null;
	}
}

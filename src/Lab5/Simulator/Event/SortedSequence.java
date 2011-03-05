package Lab5.Simulator.Event;
import java.util.Vector;

public class SortedSequence<E extends Comparable<E>> {
	Vector<E> seq = new Vector<E>();

	public void insert(E o) {
		if (seq.size() == 0) {
			seq.add(o);
		} else {
			int i = seq.size();
			while (i > 0 && o.compareTo(seq.elementAt(i-1)) < 0) {
				i--;
			}
			seq.add((i), o);
		}
	}

	public void removeFirst() {
		if (seq.size() > 0) {
			seq.removeElementAt(0);
		}
	}

	public E first() {
		if (seq.size() > 0) {
			return seq.elementAt(0);
		}
		return null;
	}
}

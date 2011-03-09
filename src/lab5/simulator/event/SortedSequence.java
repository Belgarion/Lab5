package lab5.simulator.event;

import java.util.Vector;
/**
 * The class defines a sorted sequence. It keeps al element sorted by requiring that al elements should be of the same type and implements the interface comparable.
 *
 * It is designed so that it only will remove or return the first element in the sequence.
 *
 * @author Andreas Nielsen, Fredrik Lind, Sebastian Larsson
 *
 * @param <E> The type of the elements. Requires that E implements the interface comparable
 */
public class SortedSequence<E extends Comparable<E>> {
	private Vector<E> seq = new Vector<E>();

	/**
	 * Inserts an element into the sorted sequence
	 * @param o the object to be inserted. must be of type E
	 */
	public void insert(E o) {
		if (seq.isEmpty()) {
			seq.add(o);
		} else {
			int i = 0;
			for (;o.compareTo(seq.elementAt(i)) > 0 && i < seq.size() - 1; i++);
			seq.add( (o.compareTo(seq.get(seq.size() - 1)) < 0) ? i : i + 1, o);
		}
	}

	/**
	 * Method returning the number of elements in the sorted sequence
	 * @return the number of elements in the sorted sequence
	 */
	public int size() {
		return seq.size();
	}

	/**
	 * Method removing the first element in the sorted sequence
	 */
	public void removeFirst() {
		if (seq.size() > 0) {
			seq.removeElementAt(0);
		}
	}

	/**
	 * Method returning the first element of the sorted sequence
	 * @return the first element of the sorted sequence. it will be of type E
	 */
	public E first() {
		return seq.size() > 0 ? seq.elementAt(0) : null;
	}
}

package Lab5.Simulator.Event;
import java.util.Vector;

import Lab5.CarWash.State.CarWash;

public class SortedSequence<E extends Comparable<E>> {
	Vector<E> seq = new Vector<E>();


	public void insert(E o) {
		if (seq.isEmpty()) {
			seq.add(o);
		} else if (seq.size() == 1) {
			if (o.compareTo(seq.elementAt(0)) > 0) {
				seq.add(o);
			} else {
				seq.add(0, o);
			}
		} else {
			int i = 0;
			while (o.compareTo(seq.elementAt(i)) > 0 && i < seq.size()-1) {
				i++;
			}
			if (o.compareTo(seq.elementAt(seq.size()-1)) < 0) {
				seq.add(i, o);
			} else {
				seq.add(o);
			}
		}
//		for(E e : seq){
//			System.out.print(e + ", ");
//		}
//		System.out.println("");

	}
	public int size(){
		return seq.size();
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

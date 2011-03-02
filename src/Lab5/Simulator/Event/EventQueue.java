package Lab5.Simulator.Event;

public class EventQueue extends SortedSequence<Event> {

	public Event get() {
		Event event = this.first();
		this.removeFirst();
		return event;
	}
}

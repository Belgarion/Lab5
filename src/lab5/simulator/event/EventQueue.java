package lab5.simulator.event;

/**
 * The class symbolizes an event queue containing events for a simulator. Defines the type of the sorted sequence to an Event type. 
 * @author Andreas Nielsen, Fredrik Lind, Sebastian Larsson
 *
 */
public class EventQueue extends SortedSequence<Event> {

	/**
	 * Method returning the first Event of the event queue and removing it from the event queue
	 * @return the first Event of the event queue.
	 */
	public Event get() {
		Event event = this.first();
		this.removeFirst();
		return event;
	}
}

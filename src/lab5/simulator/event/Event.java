package lab5.simulator.event;

import lab5.simulator.state.SimState;
import java.lang.Comparable;

/**
 * an Abstract event describing an event for a Simulation of a SimState
 * @author Andreas Nielsen, Fredrik Lind, Sebastian Larsson
 *
 */
public abstract class Event implements Comparable<Event> {
	protected double time;

	/**
	 * Constructs an Event
	 */
	public Event() {
	}

	/**
	 * Constructs an Event with a given time that it should occur
	 * @param time the time the event will occur
	 */
	public Event(double time) {
		this.time = time;
	}

	/**
	 * Method returning the time the event will occur
	 * @return the time the event will occur
	 */
	public double getTime() {
		return time;
	}

	/**
	 * The method that execute the event. It updates the state with the changes that the event causes 
	 * @param state the state that is to be updated due to the event
	 * @param eventQueue the queue that the event came from
	 */
	public abstract void updateState(SimState state, EventQueue eventQueue);

	public int compareTo(Event event) {
		if (this.time < event.time) {
			return -1;
		} else if (this.time > event.time) {
			return 1;
		}
		return 0;
	}
}

package Lab5.Simulator.Event;

import Lab5.Simulator.State.SimState;
import java.lang.Comparable;

public abstract class Event implements Comparable<Event> {
	protected double time;

	public Event() {
	}

	public Event(double time) {
		this.time = time;
	}

	public double getTime() {
		return time;
	}

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

package Lab5.Simulator;

import Lab5.Simulator.Event.EventQueue;
import Lab5.Simulator.State.SimState;
import Lab5.Simulator.View.SimView;
import Lab5.Simulator.Event.Event;

public class Simulator {
	private SimState state;
	private SimView view;
	private EventQueue eventQueue;

	public Simulator(SimState state, SimView view, EventQueue queue) {
		this.state = state;
		this.view = view;
		this.eventQueue = queue;
	}

	public void run() {
		Event e;
		while ((e = eventQueue.get()) != null) {
			e.updateState(state, eventQueue);
		}
	}
}

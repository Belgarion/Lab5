package Lab5.Simulator;

import Lab5.Simulator.Event.EventQueue;
import Lab5.Simulator.State.SimState;
import Lab5.Simulator.View.SimView;

public class Simulator {
	private SimState state;
	private SimView view;
	private EventQueue eventQueue;

	public Simulator(SimState state, EventQueue queue) {
		this.state = state;
		this.eventQueue = queue;
	}

	public void run() {
	}
}

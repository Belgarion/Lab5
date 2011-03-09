package Lab5.Simulator;

import Lab5.Simulator.Event.EventQueue;
import Lab5.Simulator.State.SimState;
import Lab5.Simulator.Event.Event;
/**
 * A class used for simulating a state machine defined by a simstate
 * @author Andreas Nielsen, Fredrik Lind, Sebastian Larsson
 *
 */
public class Simulator {
	private SimState state;
	private EventQueue eventQueue;
	
	/**
	 * Constructs a simulator for simulation of a simstate
	 * @param state the simstate witch is to be simulated
	 * @param queue the eventqueue containing the events that will occur in the simstate
	 */
	public Simulator(SimState state, EventQueue queue) {
		this.state = state;
		this.eventQueue = queue;
	}

	/**
	 * Method that runs the simulation until the simstate reaches its stoppstate.
	 */
	public void run() {
		Event e;
		while (state.isRunning() && (e = eventQueue.get()) != null) {
			e.updateState(state, eventQueue);
		}
	}
}

package Lab5.CarWash.Event;

import Lab5.Simulator.Event.Event;
import Lab5.Simulator.State.SimState;
import Lab5.Simulator.Event.EventQueue;

import Lab5.CarWash.State.CarWashState;

/**
 * A class symbolizing the stopping of the carwashstate 
 * @author Andreas Nielsen Fredrik Lind Sebastian Larsson
 *
 */
public class StopEvent extends Event {

	/**
	 * Constructs a stop event
	 * @param time the time when the stopevent shall occur
	 */
	public StopEvent(double time) {
		this.time = time;
	}

	/**
	 * method updating the state according to the stop event
	 */
	public void updateState(SimState state, EventQueue eventQueue) {
		CarWashState cwState = (CarWashState) state;
		cwState.setLastEvent(this);
		cwState.doNotify();
		cwState.stop();
	}
}

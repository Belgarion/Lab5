package lab5.carwash.event;

import lab5.simulator.event.Event;
import lab5.simulator.state.SimState;
import lab5.simulator.event.EventQueue;

import lab5.carwash.state.CarWashState;

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
		cwState.getInfo().setCurrentTime(this.time);
		cwState.doNotify(this);
		cwState.stop();
	}
}

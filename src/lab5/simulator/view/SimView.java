package lab5.simulator.view;

import java.util.Observer;
import java.util.Observable;

import lab5.simulator.state.SimState;

/**
 * The class that designs a view of the model of the simstate
 * @author Andreas Nielsen, Fredrik Lind, Sebastian Larsson
 *
 */
public abstract class SimView implements Observer {

	/**
	 * Constructor for the view of the simstate model
	 * @param state the simstate that is to be viewed
	 */
	public SimView(SimState state) {
		state.addObserver(this);
	}
}

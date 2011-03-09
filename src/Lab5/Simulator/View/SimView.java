package Lab5.Simulator.View;

import java.util.Observer;
import java.util.Observable;

import Lab5.Simulator.State.SimState;

/**
 * The class that designs a view of the model of the simstate
 * @author Andreas Nielsen, Fredrik Lind, Sebastian Larsson
 *
 */
public class SimView implements Observer {

	/**
	 * Constructor for the view of the simstate model
	 * @param state the simstate that is to be viewed
	 */
	public SimView(SimState state) {
		state.addObserver(this);
	}

	public void update(Observable o, Object arg) {
	}
}

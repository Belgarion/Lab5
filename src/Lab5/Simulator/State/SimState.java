package Lab5.Simulator.State;

import java.util.Observable;
/**
 * Class describing a the states of a simulation of a discrete event driven machine
 * @author Andreas Nielsen, Fredrik Lind, Sebastian Larsson
 *
 */
public class SimState extends Observable {

	protected boolean isRunning;

	/**
	 * Method defining the simulation as started
	 */
	public void start() {
		isRunning = true;
	}

	/**
	 * method defining the simulation as stopped
	 */
	public void stop() {
		isRunning = false;
	}

	/**
	 * Method that checks if the the simulation is running
	 * @return true if the simulation is running false otherwise 
	 */
	public boolean isRunning() {
		return isRunning;
	}
}

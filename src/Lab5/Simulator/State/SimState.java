package Lab5.Simulator.State;

import java.util.Observable;

public class SimState extends Observable {

	protected boolean isRunning;

	public void start() {
		isRunning = true;
	}

	public void stop() {
		isRunning = false;
	}

	public boolean isRunning() {
		return isRunning;
	}
}

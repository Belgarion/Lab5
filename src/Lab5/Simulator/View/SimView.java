package Lab5.Simulator.View;

import java.util.Observer;
import java.util.Observable;

import Lab5.Simulator.State.SimState;

public class SimView implements Observer {

	public SimView(SimState state) {
		state.addObserver(this);
	}

	public void update(Observable o, Object arg) {
	}
}

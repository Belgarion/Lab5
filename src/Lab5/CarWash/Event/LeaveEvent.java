package Lab5.CarWash.Event;

import Lab5.CarWash.State.*;
import Lab5.Simulator.State.SimState;
import Lab5.Simulator.Event.EventQueue;

public class LeaveEvent extends CarWashEvent {
	public void updateState(SimState state, EventQueue eventQueue) {
		
		//Update info
		((CarWashState) state).updateStatus(this);
		
	}
}

package Lab5.CarWash.Event;

import Lab5.Simulator.Event.Event;
import Lab5.Simulator.State.SimState;
import Lab5.Simulator.Event.EventQueue;

import Lab5.CarWash.State.CarWashState;

public class StopEvent extends Event {

	public StopEvent(double time) {
		this.time = time;
	}

	public void updateState(SimState state, EventQueue eventQueue) {
		((CarWashState)state).setLastEvent(this);
		eventQueue.removeAllEllementsFromQueue();//Empties the queue
		((CarWashState)state).doNotify();
	}
	public String toString(){
		return Double.toString(time);
	}
}

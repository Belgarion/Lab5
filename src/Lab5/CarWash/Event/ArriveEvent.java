package Lab5.CarWash.Event;

import Lab5.Simulator.Event.Event;
import Lab5.Simulator.State.SimState;
import Lab5.Simulator.Event.EventQueue;

import Lab5.CarWash.State.*;

public class ArriveEvent extends Event {
	public void updateState(SimState state, EventQueue eventQueue) {
		Info info = ((CarWashState)state).getInfo();
		if (info.emptyFast > 0) {
			//add car to fastWash
		} else if (info.emptySlow > 0) {
			//add car to SlowWash
		} else if (info.carsInQueue < info.maxQueueSize) {
			//add to car queue
		} else {
			//Discard car
		}
		eventQueue.insert(new ArriveEvent());
	}
}

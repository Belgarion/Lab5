package Lab5.CarWash.Event;

import Lab5.Simulator.Event.Event;
import Lab5.Simulator.State.SimState;
import Lab5.Simulator.Event.EventQueue;

import Lab5.CarWash.State.CarWashState;

public class StartEvent extends Event {
	public void updateState(SimState state, EventQueue eventQueue) {
		CarWashState cwState = (CarWashState)state;
		cwState.setLastEvent(this);
		cwState.doNotify();

		eventQueue.insert(new ArriveEvent(cwState.nextArriveTime(),
					cwState.carFactory.createCar()));
	}
}

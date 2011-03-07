package Lab5.CarWash.Event;

import Lab5.CarWash.State.*;
import Lab5.Simulator.State.SimState;
import Lab5.Simulator.Event.EventQueue;

public class LeaveEvent extends CarWashEvent {

	public LeaveEvent(Car car, double time) {// creating a new event
		super(time, car);
	}

	public void updateState(SimState state, EventQueue eventQueue) {
		CarWashState s = (CarWashState) state;
		s.getInfo().currentTime = this.time;
		s.removeFromMachines(this.car);
		s.setLastEvent(this);
		s.doNotify();
		if (s.getInfo().carsInQueue != 0) {
			Car c = s.removeFromQueue();
			eventQueue.insert(new LeaveEvent(c,s.addToMachine(c)));
		}

	}
}

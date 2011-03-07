package Lab5.CarWash.Event;

import Lab5.CarWash.State.*;
import Lab5.Simulator.State.SimState;
import Lab5.Simulator.Event.EventQueue;

/**
 * A LeaveEvent for a CarWash. Symbolizes the leaving of a car from a carwash.
 * @author Andreas Nielsen, Fredrik Lind, Sebastian Larsson
 */
public class LeaveEvent extends CarWashEvent {

	/**
	 * Constructs a LeaveEvent with a specific car
	 * @param car the car related to the event
	 * @param time the time the event will occur
	 */
	public LeaveEvent(Car car, double time) {// creating a new event
		super(time, car);
	}

	/**
	 * updates the state with the changes that a LeaveEvent causes.
	 * It removes the car from the CarWashes and if the car queue
	 * isn't empty add a new car from that queue to the machines.
	 * @param state the state wich is to be updated
	 * @param eventqueue the eventqueue from where the event came from
	 */
	public void updateState(SimState state, EventQueue eventQueue) {
		CarWashState s = (CarWashState) state;
		s.getInfo().currentTime = this.time;
		s.removeFromMachines(this.car);
		s.setLastEvent(this);
		s.doNotify();
		if (s.getInfo().carsInQueue != 0) {
			Car c = s.removeFromQueue();
			s.getInfo().totalQueueingTime += (this.time - c.getArriveTime());
			eventQueue.insert(new LeaveEvent(c, s.addToMachine(c)));
		}

	}
}

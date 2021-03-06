package lab5.carwash.event;

import lab5.carwash.state.*;
import lab5.simulator.state.SimState;
import lab5.simulator.event.EventQueue;

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
	 * @param eventQueue the eventqueue from where the event came from
	 */
	public void updateState(SimState state, EventQueue eventQueue) {
		CarWashState s = (CarWashState) state;
		s.getInfo().setCurrentTime(this.time);
		s.removeFromMachines(this.car);
		if (s.getInfo().getCarsInQueue() != 0) {
			Car c = s.removeFromQueue();
			s.getInfo().incTotalQueueingTime(this.time - c.getArriveTime());
			eventQueue.insert(new LeaveEvent(c, s.addToMachine(c)));
		}
		s.doNotify(this);
	}
}

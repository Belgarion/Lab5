package Lab5.CarWash.Event;

import Lab5.Simulator.State.SimState;
import Lab5.Simulator.Event.EventQueue;

import Lab5.CarWash.State.*;
/**
 * A class for ArriveEvents in a CarWash. Symbolizes the arrival of a car to a carwash.
 * @author Andreas Nielsen, Fredrik Lind, Sebastian Larsson
 *
 */
public class ArriveEvent extends CarWashEvent {
	/**
	 * Constructs an ArriveEvent
	 * @param time The time the event will occur
	 * @param car The car that arrives
	 */
	public ArriveEvent(double time, Car car) {
		super(time, car);
		car.setArriveTime(time);
	}

	/**
	 * updates the state with the changes that an ArriveEvent makes
	 * @param state The state that should be updated
	 * @param eventQueue the queue where the event came from
	 */
	public void updateState(SimState state, EventQueue eventQueue) {
		CarWashState s = (CarWashState) state;

		Info info = s.getInfo();

		s.getInfo().currentTime = this.time;

		if (info.emptyFast > 0 || info.emptySlow > 0) {
			// add car to fastWash or slowWash
			eventQueue.insert(new LeaveEvent(car, s.addToMachine(car)));
			info.numCarsEntered++;
		} else if (info.carsInQueue < info.maxQueueSize) {
			// add to car queue
			info.numCarsEntered++;
			s.addToQueue(car);
		} else {
			info.numRejectedCars++;
		}
		s.setLastEvent(this);
		s.doNotify();
		// if none of the if-statements is fulfilled the car is simply not used
		eventQueue.insert(new ArriveEvent(s.nextArriveTime(), s.carFactory
				.createCar()));
	}
}

package lab5.carwash.event;

import lab5.simulator.state.SimState;
import lab5.simulator.event.EventQueue;

import lab5.carwash.state.*;
/**
 * A class for ArriveEvents in a CarWash.
 * Symbolizes the arrival of a car to a carwash.
 * @author Andreas Nielsen, Fredrik Lind, Sebastian Larsson
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

		s.getInfo().setCurrentTime(this.time);

		if (info.getEmptyFast() > 0 || info.getEmptySlow() > 0) {
			// add car to fastWash or slowWash
			eventQueue.insert(new LeaveEvent(car, s.addToMachine(car)));
			info.incNumCarsEntered();
		} else if (info.getCarsInQueue() < info.getMaxQueueSize()) {
			// add to car queue
			info.incNumCarsEntered();
			s.addToQueue(car);
		} else {
			info.incNumRejectedCars();
		}
		s.doNotify(this);

		// if none of the if-statements is fulfilled the car is simply not used
		eventQueue.insert(new ArriveEvent(s.nextArriveTime(),
					s.getCarFactory().createCar()));
	}
}

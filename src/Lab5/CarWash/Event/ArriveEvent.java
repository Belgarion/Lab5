package Lab5.CarWash.Event;

import Lab5.Simulator.Event.Event;
import Lab5.Simulator.State.SimState;
import Lab5.Simulator.Event.EventQueue;

import Lab5.CarWash.State.*;

public class ArriveEvent extends CarWashEvent {
	public ArriveEvent(double time, Car car) {
		super(time, car);
		car.setArriveTime(time);
	}

	public void updateState(SimState state, EventQueue eventQueue) {
		CarWashState s = (CarWashState)state;
		s.setLastEvent(this);
		s.doNotify();

		Info info = s.getInfo();

		s.getInfo().currentTime = this.time;

		if (info.emptyFast > 0 || info.emptySlow > 0) {
			// add car to fastWash or slowWash
			eventQueue.insert(new LeaveEvent(car, s.addToMachine(car)));
		} else if (info.carsInQueue < info.maxQueueSize) {
			//add to car queue
			s.addToQueue(car);
		} else {
			info.numRejectedCars++;
		}

		//if none of the if-statements is fulfilled the car is simply not used
		eventQueue.insert(new ArriveEvent(s.nextArriveTime(), s.carFactory.createCar()));
	}
}

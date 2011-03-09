package lab5.carwash.event;

import lab5.simulator.event.Event;
import lab5.carwash.state.Car;

/**
 * An abstract CarWashEvent symbolizing events that occur at a CarWash
 * @author Andreas Nielsen, Fredrik Lind, Sebastian Larsson
 *
 */
public abstract class CarWashEvent extends Event {
	protected Car car;

	/**
	 * Constructs a carWashEvent with a specific car
	 * @param time the time the event will occur
	 * @param car the specific car that causes the event
	 */
	public CarWashEvent(double time, Car car) {
		super(time);
		this.car = car;
	}

	/**
	 * returns the car that causes the event
	 * @return the car that causes the event
	 */
	public Car getCar() {
		return this.car;
	}
}

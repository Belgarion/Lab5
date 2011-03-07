package Lab5.CarWash.Event;

import Lab5.Simulator.Event.Event;
import Lab5.CarWash.State.Car;

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

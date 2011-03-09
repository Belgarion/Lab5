package Lab5.CarWash.State;

import Lab5.Simulator.Event.Event;

/**
 * A Car.
 * Has an id number and the time it arrived.
 * @author Andreas Nielsen, Fredrik Lind, Sebastian Larsson
 */
public class Car {
	private int id;
	private double arriveTime;

	/**
	 * Creates a car.
	 * @param id The id of the car.
	 */
	public Car(int id) {
		this.id = id;
	}

	/**
	 * Gets the cars id.
	 * @return id
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Gets the cars queueing time.
	 * @param Event
	 * @return queueing time.
	 */
	public double getQueueingTime(Event e) {
		return e.getTime() - this.arriveTime;
	}

	/**
	 * Sets the time of arrival.
	 * @param time
	 */
	public void setArriveTime(double time) {
		this.arriveTime = time;
	}

	/**
	 * Gets the time of arrival.
	 * @return time
	 */
	public double getArriveTime() {
		return arriveTime;
	}
}

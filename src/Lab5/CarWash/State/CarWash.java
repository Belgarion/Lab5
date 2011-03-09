package Lab5.CarWash.State;

import random.UniformRandomStream;

/**
 * The Car wash.
 * @author Andreas Nielsen, Fredrik Lind, Sebastian Larsson.
 */
public class CarWash {
	private UniformRandomStream randStream;
	private boolean hasCar;
	private int currentCarId;
	private double idleTime;
	private Car currentCar;
	private String type;
	private double lastUsed;
	private CarWashState state;

	/**
	 * Initializes the CarWash.
	 * @param type
	 * @param state
	 * @param randStream
	 */
	public CarWash(String type, CarWashState state, UniformRandomStream randStream) {
		this.type = type;
		this.state = state;
		this.randStream = randStream;
		lastUsed = 0;
	}

	/**
	 * Gets the type.
	 * @return type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Checks if empty.
	 * @return true if empty, false otherwise.
	 */
	public boolean isEmpty() {
		return !this.hasCar;
	}

	/**
	 * Gets the id of the current car.
	 * @return id of current car.
	 */
	public int getCurrentCarId() {
		return this.currentCarId;
	}

	/**
	 * Checks if car is in the carwash.
	 * @param car Car to check for.
	 * @return true if car is in carwash, false otherwise.
	 */
	public boolean hasCar(Car car) {
		if (this.hasCar && this.currentCar.getId() == car.getId()) {
			return true;
		}
		return false;
	}

	/**
	 * Add car to carwash.
	 * @param car
	 */
	public void addCar(Car car) {
		this.currentCar = car;
		this.setHasCar(true);
		idleTime += state.getInfo().currentTime - lastUsed;
	}

	/**
	 * Remove current car from carwash.
	 */
	public void removeCar() {
		this.currentCar = null;
		this.setHasCar(false);
		lastUsed = state.getInfo().currentTime;
	}

	/**
	 * Sets hasCar state.
	 * @param hasCarNow
	 */
	public void setHasCar(boolean hasCarNow) {
		this.hasCar = hasCarNow;
	}

	/**
	 * returns how long the wash takes.
	 * @return time in wash.
	 */
	public double timeInWash() {
		return randStream.next();
	}

	/**
	 * Gets the idle time.
	 * @return idle time
	 */
	public double getIdleTime() {
		if (lastUsed == 0 && idleTime == 0) {
			return state.getInfo().currentTime;
		}
		return idleTime;
	}
}

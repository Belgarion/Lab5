package Lab5.CarWash.State;

/**
 * The car factory.
 * Builds cars.
 * @author Andreas Nielsen, Fredrik Lind, Sebastian Larsson
 */
public class CarFactory {
	private int lastId = -1;

	/**
	 * Builds a car and returns it.
	 * @return car.
	 */
	public Car createCar() {
		lastId += 1;
		Car c = new Car(lastId);
		return c;
	}
}

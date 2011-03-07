package Lab5.CarWash.State;

public class CarFactory {
	private int lastId = -1;

	public Car createCar() {
		lastId += 1;
		Car c = new Car(lastId);
		return c;
	}
}

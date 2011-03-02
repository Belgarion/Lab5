package Lab5.CarWash.State;

public class Car {
	private int id;
	private int arriveTime;

	public Car(int id) {
		this.id = id;
	}

	public int getQueueingTime() {
		return 0;
	}
}

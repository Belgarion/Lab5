package Lab5.CarWash.Event;

import Lab5.Simulator.Event.Event;
import Lab5.CarWash.State.Car;

public abstract class CarWashEvent extends Event {
	protected Car car;

	public CarWashEvent(double time, Car car) {
		super(time);
		this.car = car;
	}

	public Car getCar(){
		return this.car;
	}
}

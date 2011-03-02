package Lab5.CarWash.Event;

import Lab5.Simulator.Event.Event;
import Lab5.CarWash.State.Car;

public abstract class CarWashEvent extends Event {
	protected Car car;
	
	public Car getCar(){
		return this.car;
	}
}

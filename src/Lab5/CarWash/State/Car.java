package Lab5.CarWash.State;

import Lab5.Simulator.Event.Event;

public class Car {
	private int id;
	private double arriveTime;

	public Car(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	public double getQueueingTime(Event e) {
		return e.getTime() - this.arriveTime;
	}

	public void setArriveTime(double time) {
		this.arriveTime = time;
	}

	public double getArriveTime() {
		return arriveTime;
	}
}

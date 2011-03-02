package Lab5.CarWash.State;

import Lab5.Simulator.Event.Event;

public class Car {
	private int id;
	private int arriveTime;

	public Car(int id) {
		this.id = id;
	}
	
	public int getId(){
		return this.id;
	}

	public int getQueueingTime(Event e) {
		return e.getTime() - this.arriveTime;
	}
	
	public void setArriveTime(int time){
		this.arriveTime = time; 
	}
}

package Lab5.CarWash.Event;

import Lab5.Simulator.Event.Event;
import Lab5.Simulator.State.SimState;
import Lab5.Simulator.Event.EventQueue;

import Lab5.CarWash.State.*;

public class ArriveEvent extends Event {
	public ArriveEvent(double time){
		this.time=time;
	}
	public void updateState(SimState state, EventQueue eventQueue) {
		CarWashState s=(CarWashState)state;
		Info info = s.getInfo();
		Car car = s.carFactory.createCar();
		s.getInfo().currentTime=this.time;
		if (info.emptyFast > 0||info.emptySlow > 0) {
			//add car to fastWash or slowWash
			eventQueue.insert(new LeaveEvent(car, s.addToMachine(car)));
		} else if (info.carsInQueue < info.maxQueueSize) {
			//add to car queue
			s.addToQueue(car);
		}else{
			info.numRejectedCars++;
		}
		//if none of the if-statements is fulfilled the car is simply not used
		s.setLastEvent(this);
		//System.out.println(time);
		eventQueue.insert(new ArriveEvent(s.nextAriveTime()));
		s.doNotify();
	}
	public String toString(){
		return "Arrive";
	}
}
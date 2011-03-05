package Lab5.CarWash.Event;

import Lab5.CarWash.State.*;
import Lab5.Simulator.State.SimState;
import Lab5.Simulator.Event.EventQueue;

public class LeaveEvent extends CarWashEvent {

	public LeaveEvent(Car car, double time){//creating a new event
		super(time, car);
	}

	public void updateState(SimState state, EventQueue eventQueue) {
		//Update info
		((CarWashState) state).updateStatus(this);
//		//Alternativ lösning
//		CarWashState s = (CarWashState) state;
//		s.getInfo().currentTime=this.time;
//		s.removeFromMachines(this.car);
//		if(s.getInfo().carsInQueue>0){//if there is cars in the queue
//			Car temp=s.removeFromQueue();
//			double time = s.addToMachine(temp);
//			eventQueue.insert(new LeaveEvent(temp, time));
//		}
	}
}

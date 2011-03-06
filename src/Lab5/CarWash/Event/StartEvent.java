package Lab5.CarWash.Event;

import Lab5.Simulator.Event.Event;
import Lab5.Simulator.State.SimState;
import Lab5.Simulator.Event.EventQueue;

import Lab5.CarWash.State.CarWashState;

public class StartEvent extends Event {
	public StartEvent(){
		this.time=0.0;
	}
	public void updateState(SimState state, EventQueue eventQueue) {
		CarWashState s = (CarWashState)state;
		s.setLastEvent(this);
		s.getInfo().currentTime = this.time;
		eventQueue.insert(new ArriveEvent(s.nextArriveTime(),
					s.carFactory.createCar()));
		s.doNotify();
	}
}

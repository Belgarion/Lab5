package Lab5.CarWash.State;

import java.util.Vector;

import random.ExponentialRandomStream;
import Lab5.CarWash.Event.CarWashEvent;
import Lab5.Simulator.State.SimState;

public class CarWashState extends SimState {
	private Vector<CarWash> fastWashes;
	private Vector<CarWash> slowWashes;
	private ExponentialRandomStream randCarStream;
	private FIFO queue;
	private Info info;

	CarWashState(){
		//Create slow and fast washes, BOHO (test)
		for(int f = 0; f < info.numFastWashes; f++){
			//TODO Parameters for CarWash
			fastWashes.add(new CarWash("Fast"));
		}
		for(int s = 0; s < info.numSlowWashes; s++){
			//TODO Parameters for CarWash
			slowWashes.add(new CarWash("Slow"));
		}
	}
	
	public Info getInfo() {
		return info;
	}

	public void updateStatus(CarWashEvent e) {

		// Om denna ska anvŠndas Šven i ArriveEvent borde man kolla vilket event
		// man behandlar.

		// Update number of empty machines
		info.emptyFast = 0;
		for (CarWash o : fastWashes) {
			if (o.isEmpty()) {
				info.emptyFast++;
			}

			// Kanske funkar
			if (o.getCurrentCarId() == e.getCar().getId()) {
				o.setHasCar(false);
			}
		}

		info.emptySlow = 0;
		for (CarWash o : slowWashes) {
			if (o.isEmpty()) {
				info.emptySlow++;
			}

			// Kanske funkar
			if (o.getCurrentCarId() == e.getCar().getId()) {
				o.setHasCar(false);
			}
		}

		info.lastEvent = e;

	}
}

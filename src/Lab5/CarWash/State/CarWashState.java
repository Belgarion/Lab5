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

	public Info getInfo() {
		return info;
	}

	public void updateStatus(CarWashEvent e) {

		// Om denna ska användas även i ArriveEvent borde man kolla vilket event
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

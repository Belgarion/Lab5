package Lab5.CarWash.State;

import java.util.Vector;

import random.ExponentialRandomStream;
import Lab5.CarWash.Event.CarWashEvent;
import Lab5.Simulator.State.SimState;
import Lab5.Simulator.Event.Event;

public class CarWashState extends SimState {
	private Vector<CarWash> fastWashes;
	private Vector<CarWash> slowWashes;
	private ExponentialRandomStream randCarStream;
	private FIFO queue;
	private Info info;

	public CarWashState(){
		info = new Info();
		fastWashes = new Vector<CarWash>();
		slowWashes = new Vector<CarWash>();

		//Create slow and fast washes
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

	public void setLastEvent(Event e) {
		info.lastEvent = e;
	}

	public void doNotify() {
		setChanged();
		notifyObservers();
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

		setLastEvent(e);

	}

	public void setNumMachines(int fast, int slow) {
		info.numFastWashes = fast;
		info.numSlowWashes = slow;
	}

	public void setDistribution(double fastMin, double fastMax, double slowMin,
			double slowMax, double lambda) {
		info.fastDistributionMin = fastMin;
		info.fastDistributionMax = fastMax;
		info.slowDistributionMin = slowMin;
		info.slowDistributionMax = slowMax;
		info.lambda = lambda;
	}

	public void setSeed(int seed) {
		info.seed = seed;
	}

	public void setMaxQueueSize(int maxQueueSize) {
		info.maxQueueSize = maxQueueSize;
	}
}

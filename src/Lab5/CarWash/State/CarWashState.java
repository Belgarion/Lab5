package Lab5.CarWash.State;

import java.util.Vector;

import random.ExponentialRandomStream;
import random.UniformRandomStream;
import Lab5.Simulator.State.SimState;
import Lab5.Simulator.Event.Event;

public class CarWashState extends SimState {
	private Vector<CarWash> fastWashes;
	private Vector<CarWash> slowWashes;
	private ExponentialRandomStream randCarStream;
	private UniformRandomStream slowRandomStream;
	private UniformRandomStream fastRandomStream;;
	private FIFO<Car> queue;
	private Info info;
	public CarFactory carFactory;
	private Vector<CarWash> emptyMachines; // contains a list of all empty
											// machines fast should be placed
											// first in the vector and slow in
											// the end
	private double lastArriveTime = 0;

	public CarWashState() {
		info = new Info();
		fastWashes = new Vector<CarWash>();
		slowWashes = new Vector<CarWash>();
		carFactory = new CarFactory();
		queue = new FIFO<Car>();
		emptyMachines = new Vector<CarWash>();

		start();
	}

	public Info getInfo() {
		return info;
	}

	public void setLastEvent(Event e) {
		info.lastEvent = e;
		info.currentTime = e.getTime();
	}

	public void doNotify() {
		setChanged();
		notifyObservers();
	}

	public void setNumMachines(int fast, int slow) {
		info.numFastWashes = info.emptyFast = fast;
		info.numSlowWashes = info.emptySlow = slow;

		fastWashes.clear();
		slowWashes.clear();
		emptyMachines.clear();

		// Create slow and fast washes
		for (int f = 0; f < info.numFastWashes; f++) {
			CarWash cw = new CarWash("Fast", this, fastRandomStream);
			fastWashes.add(cw);
			emptyMachines.add(0, cw);
		}

		for (int s = 0; s < info.numSlowWashes; s++) {
			CarWash cw = new CarWash("Slow", this, slowRandomStream);
			slowWashes.add(cw);
			emptyMachines.add(cw);
		}

	}

	public void setDistribution(double fastMin, double fastMax, double slowMin,
			double slowMax, double lambda) {
		info.fastDistributionMin = fastMin;
		info.fastDistributionMax = fastMax;
		info.slowDistributionMin = slowMin;
		info.slowDistributionMax = slowMax;
		info.lambda = lambda;

		randCarStream = new ExponentialRandomStream(info.lambda, info.seed);
		fastRandomStream = new UniformRandomStream(fastMin, fastMax, info.seed);
		slowRandomStream = new UniformRandomStream(slowMin, slowMax, info.seed);
	}

	public void setSeed(int seed) {
		info.seed = seed;
	}

	public void setMaxQueueSize(int maxQueueSize) {
		info.maxQueueSize = maxQueueSize;
	}

	public double addToMachine(Car car) { // Returns the time it should come out
											// of the machine
		CarWash wash = emptyMachines.remove(0); // removes the first element and

		// adds the car to it
		wash.addCar(car);
		if (wash.getType() == "Fast") {
			info.emptyFast--;
		} else {
			info.emptySlow--;
		}

		info.totalIdleTime = 0;

		for (CarWash cw : slowWashes){
			info.totalIdleTime = info.totalIdleTime + cw.getIdleTime();
		}

		for (CarWash cw : fastWashes){
			info.totalIdleTime = info.totalIdleTime + cw.getIdleTime();
		}

		return info.currentTime + wash.timeInWash();
	}

	public void removeFromMachines(Car car) {

		for (CarWash cw : fastWashes) {
			if (cw.hasCar(car)) {
				emptyMachines.add(0, cw);
				cw.removeCar();
				info.emptyFast++;
			}
		}

		for (CarWash cw : slowWashes) {
			if (cw.hasCar(car)) {
				emptyMachines.add(cw);
				cw.removeCar();
				info.emptySlow++;
			}
		}
	}

	public void addToQueue(Car car) {
		queue.insert(car);
		info.carsInQueue++;
	}

	public Car removeFromQueue() {
		Car car = queue.first();
		queue.removeFirst();
		info.carsInQueue--;
		return car;
	}

	public double nextArriveTime() {
		return lastArriveTime += randCarStream.next();
	}

	public double getTotalQueueingTime() {
		double queueTime = 0;
		for (int i = 0; i < queue.size(); i++) {
			queueTime += info.currentTime - queue.get(i).getArriveTime();
		}

		return info.totalQueueingTime + queueTime;
	}
}

package lab5.carwash.state;

import java.util.Vector;

import random.ExponentialRandomStream;
import random.UniformRandomStream;
import lab5.simulator.state.SimState;
import lab5.simulator.event.Event;

public class CarWashState extends SimState {
	private Vector<CarWash> fastWashes;
	private Vector<CarWash> slowWashes;
	private ExponentialRandomStream randCarStream;
	private UniformRandomStream slowRandomStream;
	private UniformRandomStream fastRandomStream;;
	private FIFO<Car> queue;
	private Info info;
	private CarFactory carFactory;
	private Vector<CarWash> emptyMachines; // contains a list of all empty
											// machines fast should be placed
											// first in the vector and slow in
											// the end
	private double lastArriveTime = 0;

	/**
	 * Constructs the carwash state. Sets the dynamic variables of the class to
	 * necessary new instances.
	 */
	public CarWashState() {
		info = new Info();
		fastWashes = new Vector<CarWash>();
		slowWashes = new Vector<CarWash>();
		carFactory = new CarFactory();
		queue = new FIFO<Car>();
		emptyMachines = new Vector<CarWash>();

		start();
	}

	/**
	 * Returns the info object
	 * 
	 * @return info the info object
	 */
	public Info getInfo() {
		return info;
	}
	
	/**
	 * Returns the carFactory
	 * @return carFactory
	 * */
	public CarFactory getCarFactory() {
		return carFactory;
	}

	/**
	 * Sets the current event variable in Info
	 * @param e The event that is to be set as the last event.
	 * */
	public void setLastEvent(Event e) {
		info.lastEvent = e;
		info.currentTime = e.getTime();
	}

	/**
	 * Combiner function that calls setChanged() and notifyObservers();
	 * */
	public void doNotify() {
		setChanged();
		notifyObservers();
	}

	/**
	 * Creates carWash machines
	 * @param fast Number of fast machines to create
	 * @param slow Number of slow machines to create
	 * */
	public void createMachines(int fast, int slow) {
		info.numFastWashes = info.emptyFast = fast;
		info.numSlowWashes = info.emptySlow = slow;

		fastWashes.clear();
		slowWashes.clear();
		emptyMachines.clear();

		// Create fast washes
		for (int f = 0; f < info.numFastWashes; f++) {
			CarWash cw = new CarWash("Fast", this, fastRandomStream);
			fastWashes.add(cw);
			//adds the fast washes first in line
			emptyMachines.add(0, cw);
		}

		// Create slow washes
		for (int s = 0; s < info.numSlowWashes; s++) {
			CarWash cw = new CarWash("Slow", this, slowRandomStream);
			slowWashes.add(cw);
			emptyMachines.add(cw);
		}

	}

	/**
	 * Sets the distribution and creates new random streams
	 * @param fastMin Min dist for fast machines
	 * @param fastMax Max dist for fast machines
	 * @param slowMin Min dist for slow machines
	 * @param slowMax Max dist for slow machines
	 * @param lambda Lambda for the exponential random number generator
	 * */
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

	/**
	 * Sets the seed
	 * @param seed The seed
	 **/
	public void setSeed(int seed) {
		info.seed = seed;
	}

	
	/**
	 * Sets the max queue size
	 * @param maxQueueSize the maximum queue size 
	 * */
	public void setMaxQueueSize(int maxQueueSize) {
		info.maxQueueSize = maxQueueSize;
	}

	/**
	 * Adds a car to a carWash
	 * @param car The car to add
	 */
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

		return info.currentTime + wash.timeInWash();
	}

	/**
	 * Removes the specified car form its wash
	 * @param car The car to remove 
	 */
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

	/**
	 * Adds a car to the queue
	 * @param car the car to add
	 * */
	public void addToQueue(Car car) {
		queue.insert(car);
		info.carsInQueue++;
	}

	/**
	 * Removes the first car from the queue
	 * @return The car that was removed
	 */
	public Car removeFromQueue() {
		Car car = queue.first();
		queue.removeFirst();
		info.carsInQueue--;
		return car;
	}

	/**
	 * Returns the next arrive time
	 * @return The next time a is going to arrive 
	 */
	public double nextArriveTime() {
		return lastArriveTime += randCarStream.next();
	}

	/**
	 * Calculates and returns the total queuing time
	 * @return The total queuing time
	 */
	public double getTotalQueueingTime() {
		double queueTime = 0;
		for (Car c : queue) {
			queueTime += info.currentTime - c.getArriveTime();
		}

		return info.totalQueueingTime + queueTime;
	}

	/**
	 * Returns the mean queuing time
	 * @return The mean queuing time
	 */
	public double getMeanQueueingTime() {
		return getTotalQueueingTime() / info.numCarsEntered;
	}

	/**
	 * Returns the total idle time of all the machines
	 * @return The total idle time
	 */
	public double getTotalIdleTime() {
		double idle = 0;

		for (CarWash cw : slowWashes) {
			idle += cw.getIdleTime();
		}

		for (CarWash cw : fastWashes) {
			idle += cw.getIdleTime();
		}

		return idle;
	}
}

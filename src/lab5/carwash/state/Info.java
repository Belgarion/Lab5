package lab5.carwash.state;

import lab5.simulator.event.Event;

public class Info {
	int numRejectedCars;
	int numCarsEntered;
	double totalQueueingTime;
	double totalIdleTime;
	int numFastWashes;
	int numSlowWashes;
	int maxQueueSize;
	double meanQueueingTime;
	double currentTime;
	double lastTime;
	double fastDistributionMin;
	double fastDistributionMax;
	double slowDistributionMin;
	double slowDistributionMax;
	double lambda;
	int seed;
	int emptyFast;
	int emptySlow;
	int carsInQueue;

	/**
	 * method that gets the number of fast washes
	 *
	 * @return the number of fast washes
	 */
	public int getNumFastWashes() {
		return numFastWashes;
	}

	/**
	 * method that returns the number of slow washes
	 *
	 * @return the number of slow washes
	 */
	public int getNumSlowWashes() {
		return numSlowWashes;
	}

	/**
	 * Method that returns the fast distributions minimum value used in the
	 * random number generator for the car washes
	 *
	 * @return minimum value of the fast distribution
	 */
	public double getFastDistributionMin() {
		return fastDistributionMin;
	}

	/**
	 * Method that returns the fast distributions maximum value used in the
	 * random number generator for the car washes
	 *
	 * @return maximum value of the fast distribution
	 */
	public double getFastDistributionMax() {
		return fastDistributionMax;
	}

	/**
	 * Method that returns the slow distributions minimum value used in the
	 * random number generator for the car washes
	 *
	 * @return minimum value of the slow distribution
	 */
	public double getSlowDistributionMin() {
		return slowDistributionMin;
	}

	/**
	 * Method that returns the slow distributions maximum value used in the
	 * random number generator for the car washes
	 *
	 * @return maximum value of the slow distribution
	 */
	public double getSlowDistributionMax() {
		return slowDistributionMax;
	}

	/**
	 * Method returning the lambda used in the exponential random number
	 * generator
	 *
	 * @return lambda
	 */
	public double getLambda() {
		return lambda;
	}

	/**
	 * Method returning the seed for the random number generators
	 *
	 * @return the seed
	 */
	public int getSeed() {
		return seed;
	}

	/**
	 * method returning the maximum length of the car queue
	 *
	 * @return the maximum length of the car queue
	 */
	public int getMaxQueueSize() {
		return maxQueueSize;
	}

	/**
	 * method returning the number of empty fast washes
	 *
	 * @return the number of empty fast washes
	 */
	public int getEmptyFast() {
		return emptyFast;
	}

	/**
	 * Method returning the number of empty slow washes of the state
	 *
	 * @return the number of empty slow washes of the state
	 */
	public int getEmptySlow() {
		return emptySlow;
	}

	/**
	 * Method returning the number of cars in the queue
	 *
	 * @return the number of cars in the queue
	 */
	public int getCarsInQueue() {
		return carsInQueue;
	}

	/**
	 * Method returning the number of rejected cars
	 *
	 * @return the number of rejected cars of the state
	 */
	public int getNumRejectedCars() {
		return numRejectedCars;
	}

	/**
	 * method for setting the current time of the state
	 *
	 * @param time
	 *            the current time to witch the state is to be updated to
	 */
	public void setCurrentTime(double time) {
		currentTime = time;
	}

	/**
	 * Method increasing the number of cars that has entered the car wash by one
	 */
	public void incNumCarsEntered() {
		numCarsEntered++;
	}

	/**
	 * Method increasing the number of rejected cars by one
	 */
	public void incNumRejectedCars() {
		numRejectedCars++;
	}

	/**
	 * method increasing the total queuing time
	 *
	 * @param time
	 *            the amount that the total queuing time is to be increased
	 */
	public void incTotalQueueingTime(double time) {
		totalQueueingTime += time;
	}
}

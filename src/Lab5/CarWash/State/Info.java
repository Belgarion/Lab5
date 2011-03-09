package Lab5.CarWash.State;

import Lab5.Simulator.Event.Event;

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
	Event lastEvent;
	int emptyFast;
	int emptySlow;
	int carsInQueue;

	/**
	 * Method that gets the last event
	 * @return the last event that occured
	 */
	public Event getLastEvent(){
		return lastEvent;
	}
	
	/**
	 * method that gets the number of fast washes
	 * @return the number of fast washes
	 */
	public int getNumFastWashes(){
		return numFastWashes;
	}
	
	/**
	 * method that returns the number of slow washes 
	 * @return the number of slow washes
	 */
	public int getNumSlowWashes(){
		return numSlowWashes;
	}

	public double getFastDistributionMin(){
		return fastDistributionMin;
	}

	public double getFastDistributionMax(){
		return fastDistributionMax;
	}

	public double getSlowDistributionMin(){
		return slowDistributionMin;
	}

	public double getSlowDistributionMax(){
		return slowDistributionMax;
	}

	public double getLambda(){
		return lambda;
	}

	public int getSeed(){
		return seed;
	}

	/**
	 * method returning the maximum length of the car queue
	 * @return the maximum length of the car queue
	 */
	public int getMaxQueueSize(){
		return maxQueueSize;
	}
	
	/**
	 * method returning the number of empty fast washes
	 * @return the number of empty fast washes
	 */
	public int getEmptyFast(){
		return emptyFast;
	}

	/**
	 * Method returning the number of empty slow washes of the state
	 * @return the number of empty slow washes of the state
	 */
	public int getEmptySlow(){
		return emptySlow;
	}

	/**
	 * Method returning the number of cars in the queue
	 * @return the number of cars in the queue
	 */
	public int getCarsInQueue(){
		return carsInQueue;
	}

	/**
	 * Method returning the number of rejected cars
	 * @return the number of rejected cars of the state
	 */
	public int getNumRejectedCars(){
		return numRejectedCars;
	}

	/**
	 * method for setting the current time of the state
	 * @param time the current time to witch the state is to be updated to
	 */
	public void setCurrentTime(double time){
		currentTime = time;
	}

	/**
	 * Method increasing the number of cars that has entered the car wash by one
	 */
	public void incNumCarsEntered(){
		numCarsEntered++;
	}

	/**
	 * Method increasing the number of rejected cars by one 
	 */
	public void incNumRejectedCars(){
		numRejectedCars++;
	}

	/**
	 * method increasing the total queuing time
	 * @param time the amount that the total queuing time is to be increased
	 */
	public void incTotalQueueingTime(double time){
		totalQueueingTime += time;
	}
}

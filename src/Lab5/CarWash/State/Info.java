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
	
	public Event getLastEvent(){
		return lastEvent;
	}
	
	public int getNumFastWashes(){
		return numFastWashes;
	}
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
	
	public int getMaxQueueSize(){
		return maxQueueSize;
	}
	
	public int getEmptyFast(){
		return emptyFast;
	}
	
	public int getEmptySlow(){
		return emptySlow;
	}
	
	public double getTotalIdleTime(){
		return totalIdleTime;
	}
	
	public int getCarsInQueue(){
		return carsInQueue;
	}
	public int getNumRejectedCars(){
		return numRejectedCars;
	}
	
	public void setCurrentTime(double time){
		currentTime = time;
	}
	
	public void incNumCarsEntered(){
		numCarsEntered++;
	}
	
	public void incNumRejectedCars(){
		numRejectedCars++;
	}
	
	public void incTotalQueueingTime(double time){
		totalQueueingTime += time;
	}
}

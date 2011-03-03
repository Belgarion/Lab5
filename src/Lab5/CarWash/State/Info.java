package Lab5.CarWash.State;

import Lab5.Simulator.Event.Event;

public class Info {
	public int numRejectedCars;
	public int numCarsEntered;
	public int totalQueueingTime;
	public int totalIdleTime;
	public int numFastWashes;
	public int numSlowWashes;
	public int maxQueueSize;
	public int meanQueueingTime;
	public double fastDistributionMin;
	public double fastDistributionMax;
	public double slowDistributionMin;
	public double slowDistributionMax;
	public double lambda;
	public int seed;
	public Event lastEvent;
	public int emptyFast;
	public int emptySlow;
	public int carsInQueue;
}

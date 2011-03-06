package Lab5.CarWash.State;

import Lab5.Simulator.Event.Event;

public class Info {
	public int numRejectedCars;
	public int numCarsEntered;
	public double totalQueueingTime;
	public double totalIdleTime;
	public int numFastWashes;
	public int numSlowWashes;
	public int maxQueueSize;
	public double meanQueueingTime;
	public double currentTime;
	public double lastTime;
	public double fastDistributionMin;
	public double fastDistributionMax;
	public double slowDistributionMin;
	public double slowDistributionMax;
	public double lambda;
	public int seed;
	public Event currentEvent;
	public Event lastEvent;
	public int emptyFast;
	public int emptySlow;
	public int carsInQueue;
}

package Lab5.CarWash.View;

import Lab5.Simulator.View.SimView;
import Lab5.Simulator.Event.Event;
import Lab5.CarWash.State.Info;
import Lab5.CarWash.Event.StartEvent;
import Lab5.CarWash.Event.StopEvent;

import java.util.Observable;


public class CarWashView extends SimView {

	@Override
	public void update(Observable o, Object arg) {
		Info i = (Info)arg;
		print(i);
	}

	public void print(Info i) {
		if (i.lastEvent instanceof StartEvent) {
			System.out.println("Fast machines: " + i.numFastWashes);
			System.out.println("Slow machines: " + i.numSlowWashes);
			System.out.println("Fast distribution: " + i.fastDistribution);
			System.out.println("Slow distribution: " + i.slowDistribution);
			System.out.println("Exponential distribution with lambda: " + i.lambda);
			System.out.println("seed: " + i.seed);
			System.out.println("Max Queue Size: " + i.maxQueueSize);
			System.out.println("----------------------------------------");
			System.out.println("      Time      Event    Id    Fast    Slow    IdleTime  QueueTime  QueueSize   Rejected");
			System.out.println("      " + i.lastEvent.getTime() + "      Start");
		}

		Event e = i.lastEvent;
		System.out.println(String.format("     %s      %s            %s       %s       %s     %s          %s          %s",
					e.getTime(), e.getClass().getName(), "id", i.emptyFast, i.emptySlow,
					i.totalIdleTime, i.totalQueueingTime, i.carsInQueue, i.numRejectedCars));

		if (i.lastEvent instanceof StopEvent) {
			System.out.println("----------------------------------------");
			System.out.println("Total idle machine time: " + i.totalIdleTime);
			System.out.println("Total queueing time: " + i.totalQueueingTime);
			System.out.println("Mean queueing time: " + i.meanQueueingTime);
			System.out.println("Rejected cars: " + i.numRejectedCars);
		}
	}
}

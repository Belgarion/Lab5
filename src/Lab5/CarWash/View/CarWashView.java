package Lab5.CarWash.View;

import Lab5.Simulator.View.SimView;
import Lab5.CarWash.State.Info;
import Lab5.CarWash.State.CarWashState;
import Lab5.CarWash.Event.StartEvent;
import Lab5.CarWash.Event.StopEvent;
import Lab5.CarWash.Event.CarWashEvent;
import Lab5.Simulator.Event.Event;

import java.util.Observable;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class CarWashView extends SimView {
	private static final Pattern typePattern = Pattern
			.compile(".*\\.(.*)Event");

	private CarWashState state;

	public CarWashView(CarWashState state) {
		super(state);
		this.state = state;
	}

	@Override
	public void update(Observable o, Object arg) {
		print(state.getInfo());
	}

	/**
	 * Prints the info.
	 *
	 * @param i Info
	 */
	public void print(Info i) {
		Matcher m = typePattern.matcher(i.lastEvent.getClass().getName());
		boolean matchFound = m.find();
		String eventType = "Unknown";
		if (matchFound) {
			eventType = m.group(1);
		}

		if (i.lastEvent instanceof StartEvent) {
			System.out.println("Fast machines: " + i.numFastWashes);
			System.out.println("Slow machines: " + i.numSlowWashes);
			System.out.println("Fast distribution: (" + i.fastDistributionMin
					+ ", " + i.fastDistributionMax + ")");
			System.out.println("Slow distribution: (" + i.slowDistributionMin
					+ ", " + i.slowDistributionMax + ")");
			System.out.println("Exponential distribution with lambda: "
					+ i.lambda);
			System.out.println("seed: " + i.seed);
			System.out.println("Max Queue Size: " + i.maxQueueSize);
			System.out.println("----------------------------------------");
			System.out
					.println("      Time      Event    Id    Fast    Slow    IdleTime  QueueTime  QueueSize   Rejected");
			System.out.format("%10.2f      Start\n", i.lastEvent.getTime());
			return;
		}

		int carId = -1;
		Event e = i.lastEvent;
		if (i.lastEvent instanceof CarWashEvent) {
			carId = ((CarWashEvent)i.lastEvent).getCar().getId();
		}

		System.out.format("%10.2f      %-8s %2s    %2d      %2d       %5.2f      %5.2f        %2d        %2d\n",
						e.getTime(), eventType, carId >= 0 ? carId : "",
						i.emptyFast, i.emptySlow, i.totalIdleTime,
						state.getTotalQueueingTime(), i.carsInQueue,
						i.numRejectedCars);

		if (i.lastEvent instanceof StopEvent) {
			System.out.println("----------------------------------------");
			System.out.format("Total idle machine time: %.2f\n",
					i.totalIdleTime);
			System.out.format("Total queueing time:     %.2f\n",
					state.getTotalQueueingTime());
			System.out.format("Mean queueing time:      %.2f\n",
					state.getMeanQueueingTime());
			System.out.format("Rejected cars:         %3d", i.numRejectedCars);
		}
	}
}

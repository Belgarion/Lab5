package lab5.carwash.view;

import lab5.simulator.view.SimView;
import lab5.carwash.state.Info;
import lab5.carwash.state.CarWashState;
import lab5.carwash.event.StartEvent;
import lab5.carwash.event.StopEvent;
import lab5.carwash.event.CarWashEvent;
import lab5.simulator.event.Event;

import java.util.Observable;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * The view of the carwash.
 * @author Andreas Nielsen, Fredrik Lind, Sebastian Larsson
 */
public class CarWashView extends SimView {
	private static final Pattern typePattern = Pattern
			.compile(".*\\.(.*)Event");

	private CarWashState state;

	public CarWashView(CarWashState state) {
		super(state);
		this.state = state;
	}

	/**
	 * Runs when the state notifies observers.
	 */
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
		Matcher m = typePattern.matcher(i.getLastEvent().getClass().getName());
		boolean matchFound = m.find();
		String eventType = "Unknown";
		if (matchFound) {
			eventType = m.group(1);
		}

		Event e = i.getLastEvent();

		if (e instanceof StartEvent) {
			System.out.println("Fast machines: " + i.getNumFastWashes());
			System.out.println("Slow machines: " + i.getNumSlowWashes());
			System.out.println("Fast distribution: (" + i.getFastDistributionMin()
					+ ", " + i.getFastDistributionMax() + ")");
			System.out.println("Slow distribution: (" + i.getSlowDistributionMin()
					+ ", " + i.getSlowDistributionMax() + ")");
			System.out.println("Exponential distribution with lambda: "
					+ i.getLambda());
			System.out.println("seed: " + i.getSeed());
			System.out.println("Max Queue Size: " + i.getMaxQueueSize());
			System.out.println("----------------------------------------");
			System.out.println("      Time      Event    Id    Fast    Slow"
					+ "    IdleTime  QueueTime  QueueSize   Rejected");
			System.out.format("%10.2f      Start\n", i.getLastEvent().getTime());
			return;
		}

		int carId = -1;
		if (e instanceof CarWashEvent) {
			carId = ((CarWashEvent)e).getCar().getId();
		}

		System.out.format("%10.2f      %-8s %2s    %2d      %2d       %5.2f"
				+ "      %5.2f        %2d        %2d\n",
						e.getTime(), eventType, carId >= 0 ? carId : "",
						i.getEmptyFast(), i.getEmptySlow(), state.getTotalIdleTime(),
						state.getTotalQueueingTime(), i.getCarsInQueue(),
						i.getNumRejectedCars());

		if (e instanceof StopEvent) {
			System.out.println("----------------------------------------");
			System.out.format("Total idle machine time: %.2f\n",
					state.getTotalIdleTime());
			System.out.format("Total queueing time:     %.2f\n",
					state.getTotalQueueingTime());
			System.out.format("Mean queueing time:      %.2f\n",
					state.getMeanQueueingTime());
			System.out.format("Rejected cars:         %3d", i.getNumRejectedCars());
		}
	}
}

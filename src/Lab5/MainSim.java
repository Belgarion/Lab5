package Lab5;

import Lab5.Simulator.Event.EventQueue;
import Lab5.CarWash.State.CarWashState;
import Lab5.CarWash.View.CarWashView;
import Lab5.Simulator.Simulator;
import Lab5.CarWash.Event.StartEvent;
import Lab5.CarWash.Event.StopEvent;

/**
 * The main class that creates a carwashstate an eventqueue and a simulation
 * object and runs the simulation of the system
 * 
 * @author Andreas Nielsen, Fredrik Lind, Sebastian Larsson
 * 
 */
public class MainSim {
	/**
	 * The main method
	 * 
	 * @param args
	 *            the arguments used for starting the program should be in the
	 *            following format: <fast machines> <slow machines> <fast
	 *            distribution min> <fast distribution max> <slow distribution
	 *            min> <slow distribution max> <lambda> <seed> <max queue size>
	 *            <stop time>
	 */
	public static void main(String[] args) {
		if (args.length < 10) {
			System.out
					.println("Usage: java -jar lab5.jar <fast machines> <slow machines> <fast distribution min>"
							+ " <fast distribution max> <slow distribution min> <slow distribution max> <lambda> <seed>"
							+ " <max queue size> <stop time>");
			return;
		}

		// Parse args
		int fast = Integer.parseInt(args[0]);
		int slow = Integer.parseInt(args[1]);
		double fastMin = Double.parseDouble(args[2]);
		double fastMax = Double.parseDouble(args[3]);
		double slowMin = Double.parseDouble(args[4]);
		double slowMax = Double.parseDouble(args[5]);
		double lambda = Double.parseDouble(args[6]);
		int seed = Integer.parseInt(args[7]);
		int maxQueueSize = Integer.parseInt(args[8]);
		double stopTime = Double.parseDouble(args[9]);

		CarWashState state = new CarWashState();
		EventQueue queue = new EventQueue();
		new CarWashView(state);

		state.setSeed(seed);
		state.setDistribution(fastMin, fastMax, slowMin, slowMax, lambda);
		state.setMaxQueueSize(maxQueueSize);
		state.createMachines(fast, slow);

		queue.insert(new StartEvent());
		queue.insert(new StopEvent(stopTime));
		Simulator sim = new Simulator(state, queue);
		sim.run();
	}
}

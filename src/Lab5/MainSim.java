package Lab5;
import Lab5.Simulator.Event.EventQueue;
import Lab5.CarWash.State.CarWashState;
import Lab5.CarWash.View.CarWashView;
import Lab5.Simulator.Simulator;
import Lab5.CarWash.Event.StartEvent;
import Lab5.CarWash.Event.StopEvent;

public class MainSim {
	public static void main(String[] args) {
		if (args.length < 9) {
			System.out.println("Usage: java -jar lab5.jar <fast machines> <slow machines> <fast distribution min>"
					+ " <fast distribution max> <slow distribution min> <slow distribution max> <lambda> <seed>"
					+ " <max queue size>");
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

		CarWashState state = new CarWashState();
		CarWashView view = new CarWashView(state);
		EventQueue queue = new EventQueue();

		state.setNumMachines(fast, slow);
		state.setDistribution(fastMin, fastMax, slowMin, slowMax, lambda);
		state.setSeed(seed);
		state.setMaxQueueSize(maxQueueSize);

		queue.insert(new StartEvent());
		queue.insert(new StopEvent(15.0));

		Simulator sim = new Simulator(state, view, queue);
		sim.run();
	}
}

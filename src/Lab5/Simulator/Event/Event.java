
public abstract class Event {
	private int time;

	public int getTime() {
		return time;
	}

	public abstract void updateState(SimState state, EventQueue eventQueue);

	public int compareTo(Event event) {
		return 0;
	}
}

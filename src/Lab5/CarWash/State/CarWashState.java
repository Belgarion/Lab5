package Lab5.CarWash.State;

import java.util.Vector;

import random.ExponentialRandomStream;

public class CarWashState {
	private Vector<CarWash> fastWashes;
	private Vector<CarWash> slowWashes;
	private ExponentialRandomStream randCarStream;
	private FIFO queue;
	private Info info;
}

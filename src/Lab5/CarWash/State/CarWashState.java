package Lab5.CarWash.State;

import java.util.Vector;

import random.ExponentialRandomStream;

import Lab5.Simulator.State.SimState;

public class CarWashState extends SimState {
	private Vector<CarWash> fastWashes;
	private Vector<CarWash> slowWashes;
	private ExponentialRandomStream randCarStream;
	private FIFO queue;
	private Info info;
	public Info getInfo(){
		return info;
	}
}

package Lab5.CarWash.State;

import java.util.Vector;

import random.ExponentialRandomStream;
import Lab5.CarWash.Event.CarWashEvent;
import Lab5.Simulator.State.SimState;
import Lab5.Simulator.Event.Event;

public class CarWashState extends SimState {
	private Vector<CarWash> fastWashes;
	private Vector<CarWash> slowWashes;
	private ExponentialRandomStream randCarStream;
	private FIFO<Car> queue;
	private Info info;
	public CarFactory carFactory;
	private Vector<CarWash> emptyMachines;//contains a list of al empty machines fast should be placed first in the vector and slow in the end
	private double lastArriveTime=0;

	public CarWashState(){
		info = new Info();
		fastWashes = new Vector<CarWash>();
		slowWashes = new Vector<CarWash>();

		//Create slow and fast washes
		for(int f = 0; f < info.numFastWashes; f++){
			//TODO Parameters for CarWash
			fastWashes.add(new CarWash("Fast", this));
		}
		for(int s = 0; s < info.numSlowWashes; s++){
			//TODO Parameters for CarWash
			slowWashes.add(new CarWash("Slow", this));
		}
		
		carFactory = new CarFactory();
		queue = new FIFO<Car>();
	}
	
	public CarWashState(int fast, int slow, double fastMin, double fastMax, double slowMin, double slowMax, double lambda, int seed, int maxQueueSize, double stopTime){
		info = new Info();
		info.numFastWashes=fast;
		info.numSlowWashes=slow;
		info.emptyFast = fast;
		info.emptySlow = slow;
		info.lambda=lambda;
		info.slowDistributionMax=slowMax;
		info.slowDistributionMin = slowMin;
		info.fastDistributionMax=fastMax;
		info.fastDistributionMin=fastMin;
		info.seed=seed;
		info.maxQueueSize=maxQueueSize;
		info.numRejectedCars = 0;
		
		fastWashes = new Vector<CarWash>();
		slowWashes = new Vector<CarWash>();
		//Create slow and fast washes
		for(int f = 0; f < info.numFastWashes; f++){
			//TODO Parameters for CarWash
			fastWashes.add(new CarWash("Fast", this));
		}
		for(int s = 0; s < info.numSlowWashes; s++){
			//TODO Parameters for CarWash
			slowWashes.add(new CarWash("Slow", this));
		}
		emptyMachines = new Vector<CarWash>();
		for(CarWash o : fastWashes){
			emptyMachines.add(o);
			
		}
		for(CarWash o : slowWashes){
			emptyMachines.add(o);
		}
		carFactory = new CarFactory();
		queue = new FIFO<Car>();
		randCarStream = new ExponentialRandomStream(info.lambda, info.seed);
	}

	public Info getInfo() {
		return info;
	}

	public void setLastEvent(Event e) {
		info.lastEvent = e;
	}

	public void doNotify() {
		setChanged();
		notifyObservers();
	}

	public void updateStatus(CarWashEvent e) {

		// Om denna ska anvŠndas Šven i ArriveEvent borde man kolla vilket event
		// man behandlar.

		// Update number of empty machines
		info.emptyFast = 0;
		for (CarWash o : fastWashes) {
			if (o.isEmpty()) {
				info.emptyFast++;
			}

			// Kanske funkar
			if (o.getCurrentCarId() == e.getCar().getId()) {
				o.setHasCar(false);
			}
		}

		info.emptySlow = 0;
		for (CarWash o : slowWashes) {
			if (o.isEmpty()) {
				info.emptySlow++;
			}

			// Kanske funkar
			if (o.getCurrentCarId() == e.getCar().getId()) {
				o.setHasCar(false);
			}
		}

		setLastEvent(e);

	}

	public void setNumMachines(int fast, int slow) {
		info.numFastWashes = fast;
		info.numSlowWashes = slow;
	}

	public void setDistribution(double fastMin, double fastMax, double slowMin,
			double slowMax, double lambda) {
		info.fastDistributionMin = fastMin;
		info.fastDistributionMax = fastMax;
		info.slowDistributionMin = slowMin;
		info.slowDistributionMax = slowMax;
		info.lambda = lambda;
	}

	public void setSeed(int seed) {
		info.seed = seed;
	}

	public void setMaxQueueSize(int maxQueueSize) {
		info.maxQueueSize = maxQueueSize;
	}
	//***************************************************
	//Added by Andreas Nielsen 
	public void setrandCarStream(){//Hitta bättre lösning
		randCarStream = new ExponentialRandomStream(info.lambda, info.seed);
	}
	public double addToMachine(Car car){//Returns the time it should come out of the machine
		CarWash wash = emptyMachines.remove(0);//removes the first element and adds the car to it
		wash.addCar(car);
		if(wash.getType()=="Fast"){
			info.emptyFast--;
			//System.out.println("fast " + info.emptyFast);
		}else{
			info.emptySlow--;
			//System.out.println("slow " + info.emptySlow);
		}
		return info.currentTime + wash.TimeInWash();
	}
	public void removeFromMachines(Car car){
		for(int i=0; i<fastWashes.size(); i++){
			if(fastWashes.elementAt(i).hasCar(car)){
				emptyMachines.add(fastWashes.elementAt(i));
				fastWashes.elementAt(i).removeCar();
				info.emptyFast++;
			}
		}
		for(int i=0; i<slowWashes.size(); i++){
			if(slowWashes.elementAt(i).hasCar(car)){
				emptyMachines.add(slowWashes.elementAt(i));
				slowWashes.elementAt(i).removeCar();
				info.emptySlow++;
			}
		}
	}

	public void addToQueue(Car car){
		queue.insert(car);
		info.carsInQueue++;
	}
	public Car removeFromQueue(){
		Car car = queue.first();
		queue.removeFirst();
		info.carsInQueue--;
		return car;
	}
	public double nextAriveTime(){
		return lastArriveTime = lastArriveTime+randCarStream.next();
	}
	//***************************************************
}

package Lab5.CarWash.State;

import random.UniformRandomStream;

public class CarWash {
	private UniformRandomStream randStream;
	private boolean hasCar;
	private int currentCarId;
	private double idleTime;
	private Car currentCar;
	private String type;
	private double lastUsed;
	private CarWashState state;
	private boolean hasHadaCar;

	public CarWash(String type, CarWashState state, UniformRandomStream randStream) {
		this.type = type;
		this.state = state;
		Info info = state.getInfo();
		hasHadaCar=false;
		this.randStream = randStream;
		lastUsed = 0;
	}

	public String getType() {
		return type;
	}

	public boolean isEmpty() {
		return !this.hasCar;
	}

	public int getCurrentCarId() {
		return this.currentCarId;
	}

	public boolean hasCar(Car car) {
		if (this.hasCar) {
			if (this.currentCar.getId() == car.getId()) {
				return true;
			}
		}
		return false;
	}

	public void addCar(Car car) {
		hasHadaCar= true;
		this.currentCar = car;
		this.setHasCar(true);
		idleTime = idleTime + (state.getInfo().currentTime - lastUsed);
	}

	public void removeCar() {
		this.currentCar = null;
		this.setHasCar(false);
		lastUsed = state.getInfo().currentTime;
	}

	public void setHasCar(boolean hasCarNow) {
		this.hasCar = hasCarNow;
	}

	public double timeInWash() {
		return randStream.next();
	}
	
	public double getIdleTime(){
		if(!hasHadaCar){
			return state.getInfo().currentTime;
		}
		return idleTime;
	}
}

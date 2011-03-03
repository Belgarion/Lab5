package Lab5.CarWash.State;

import random.UniformRandomStream;

public class CarWash {
	private UniformRandomStream randStream;
	private boolean hasCar;
	private int currentCarId;
	private int idleTime;
	
	public boolean isEmpty(){
		return !this.hasCar;
	}
	
	//Maybe better to create sub-classes?
	public boolean isFast(){
		
	}
	
	public int getCurrentCarId(){
		return this.currentCarId;
	}
	
	public void setHasCar(boolean hasCarNow){
		this.hasCar = hasCarNow;
	}
}
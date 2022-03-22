package UsedCars;

public class Truck extends Vehicle {
	private int towing;
	
	public Truck() {
		
	}
	
	public Truck (String type, int year, double price, int towing) {
		super(type, year, price);
		this.towing = towing;
	}
	
	public boolean canTowBoat() {
		if (towing >= 2000) {return true;}
		else {return false;}
	}
	
	@Override
	public String getInfo() {
		return super.getInfo() + " // Towing Capacity : " + towing;
	}

}

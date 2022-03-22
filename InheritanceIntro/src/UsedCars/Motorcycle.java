package UsedCars;

public class Motorcycle extends Vehicle {
	private int topSpeed;
	
	public Motorcycle() {
		
	}
	
	public Motorcycle(String type, int year, double price, int topSpeed) {
		super(type, year, price);
		this.topSpeed = topSpeed;
	}
	
	@Override
	public String getInfo() {
		return super.getInfo() + " // Top Speed : " + topSpeed;
	}
}

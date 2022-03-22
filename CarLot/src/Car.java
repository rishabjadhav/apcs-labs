
public class Car {
	private int fuelCapacity;
	private int fuelEfficiency;
	private int mileage;
	private double fuelCurrent;
	private String name;
	
	public Car() {
		
	}
	
	public Car (String nameC, int capacityC, int efficiencyC, int mileageC) {
		if(nameC.length() > 20) {
			nameC = nameC.substring(0, 20);
		}
		
		if(capacityC < 0) {
			throw new IllegalArgumentException("The fuel capacity argument is illegal");
		}
		
		if(efficiencyC < 0) {
			throw new IllegalArgumentException("The fuel efficiency argument is illegal");
		}
		
		if(mileageC < 0) {
			throw new IllegalArgumentException("The mileage argument is illegal");
		}
		
		name = nameC;
		fuelCapacity = capacityC;
		fuelEfficiency = efficiencyC;
		mileage = mileageC;
		fuelCurrent = (fuelCapacity / 2.0);
		
		if (fuelCurrent < 0 || fuelCurrent > fuelCapacity) {
			throw new IllegalArgumentException("Fuel Capacity Exceeded (" + fuelCurrent + ")");
		}
	}

	public int getFuelCapacity() {
		return fuelCapacity;
	}

	public int getFuelEfficiency() {
		return fuelEfficiency;
	}

	public int getMileage() {
		return mileage;
	}

	public double getFuelCurrent() {
		return fuelCurrent;
	}

	public String getName() {
		return name;
	}
	
	public void drive(int miles) {
		mileage += miles;
		double usedFuel = (miles / (double)fuelEfficiency);
		fuelCurrent -= usedFuel;
		if (fuelCurrent < 0) {
		throw new IllegalArgumentException("Miles Exceed Current Fuel (" + miles + ")");
		}
	}
	
	public void addGas(double gasAdded) {
		fuelCurrent += gasAdded;
		if (fuelCurrent > fuelCapacity) {
			throw new IllegalArgumentException("Gas Added Exceeds Fuel Capacity (" + gasAdded + ")");
		}
		
	}
	
	public String toString() {
		return String.format("%-20s %14d %6d %12.1f %9d", name, fuelCapacity, fuelEfficiency, fuelCurrent, mileage);
	}
	
	
}

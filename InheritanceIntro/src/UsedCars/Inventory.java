package UsedCars;

import java.util.ArrayList;

public class Inventory {

	private ArrayList<Vehicle> vehicles;
	
	public Inventory() {
		
	}
	
	public Inventory(ArrayList<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	
	public void addVehicle(Vehicle v) {
		vehicles.add(v);
	}
	
	public void listInventory() {
		for (Vehicle v : vehicles) {
			System.out.println(v.getInfo());
		}
	}

}

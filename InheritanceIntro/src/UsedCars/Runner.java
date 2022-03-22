package UsedCars;

import java.util.ArrayList;

import CombinationLock.CombinationLockTest;
import Scheduler.Scheduler;

public class Runner {
	public static void main (String[]args) {
		
		System.out.println("*************** Combination Lock ***************");
		CombinationLockTest.test();
		
		System.out.println("*************** Scheduler ***************");
		Scheduler app = new Scheduler();
		
		
		System.out.println("*************** Used Cars ***************");
		Car car1 = new Car("Honda Civic", 2014, 7100, 36);
		Car car2 = new Car("Toyota Corolla", 2011, 6200, 20);
		
		Truck truck1 = new Truck("Chevrolet Silverado", 2008, 13500, 2500);
		Truck truck2 = new Truck("Ford Ranger", 2020, 26000, 7000);
		
		System.out.println(car1.greatMPG());
		System.out.println(car2.getInfo());

		System.out.println(truck1.canTowBoat());
		System.out.println(truck2.getInfo());
		System.out.println();
		
		Motorcycle motorcycle1 = new Motorcycle("Suzuki GSX-R", 2017, 14750, 125);
		
		ArrayList <Vehicle> vehicles = new ArrayList<Vehicle>();
		vehicles.add(car1);
		vehicles.add(car2);
		vehicles.add(truck1);
		vehicles.add(truck2);
		vehicles.add(motorcycle1);
		
		Inventory inventory = new Inventory(vehicles);
		inventory.listInventory();
		
	}
}

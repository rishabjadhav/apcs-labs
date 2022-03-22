import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CarLot {
	public static void main(String[]args) {
		File file = new File("cars.txt");
		Scanner scanner = null;
		Car[] cars = null;
		int a = 0;
		int arrayLength = 0;
		
		try {
			scanner = new Scanner(file);
			arrayLength = scanner.nextInt();
			cars = new Car[arrayLength];
			scanner.nextLine();
			
			while(scanner.hasNext()) {
				String name = scanner.nextLine();
				String info = scanner.nextLine();
				
				String fuelCapacity = info.substring(0, 2);
				int fuelCapacityI = Integer.parseInt(fuelCapacity);
				
				String fuelEfficiency = info.substring(3, 5);
				int fuelEfficiencyI = Integer.parseInt(fuelEfficiency);
				
				String mileage = info.substring(6);
				mileage.trim();
				int mileageI = Integer.parseInt(mileage);
				
				cars[a] = new Car(name, fuelCapacityI, fuelEfficiencyI, mileageI);
				a++;
			}
		}
		
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		boolean end = false;
		Scanner console = new Scanner(System.in);
		while (end == false) {
			printCars(cars);
			System.out.println("Do you want to (D)rive, (A)dd gas, or (Q)uit?");
			String choice = console.next();
			choice = choice.toUpperCase();
			
			if (choice.equals("D")) {
				System.out.println("Which Car (1-" + cars.length + ")?");
				int whichCar = console.nextInt();
				if (whichCar < 1 || whichCar > cars.length) {
					throw new IllegalArgumentException("Car not found (" + whichCar + ")");
				}
				
				System.out.println("How many miles?");
				int milesInput = console.nextInt();
				if (milesInput < 0) {
					throw new IllegalArgumentException("Cannot drive negative miles (" + milesInput + ")");
				}
				cars[whichCar - 1].drive(milesInput);
			} 
			else if (choice.equals("A")) {
				System.out.println("Which Car (1-" + cars.length + ")?");
				int whichCar = console.nextInt();
				if (whichCar < 1 || whichCar > cars.length) {
					throw new IllegalArgumentException("Car not found (" + whichCar + ")");
				}
				System.out.println("How much gas?");
				double filledGas = console.nextDouble();
				if (filledGas < 0) {
					throw new IllegalArgumentException("Gas cannot be removed (" + filledGas + ")");
				}
				cars[whichCar - 1].addGas(filledGas);
			} 
			else if (choice.equals("Q")) {
				console.close();
				end = true;
			} 
			else {
				throw new IllegalArgumentException("Invalid Input (" + choice + ")");
			}
		}
	}
	
	public static void printCars(Car[] cars) {
		System.out.printf("%-23s %14s %6s %12s %9s\n", "   Car Name", "Fuel Capacity", "MPG", "Fuel Level", "Mileage");
		for (int i = 0; i < cars.length; i++) {
			System.out.println(i + 1 + ": " + cars[i]);
		}
	}
}
import java.util.ArrayList;

public class House {
	private ArrayList<Animal> animals = new ArrayList<Animal>();
	
	public void printAnimals() {
		for (Animal a : animals) {
			System.out.println(a);
			System.out.println();
		}
	}
	
	public void cleanHouse() {
		for (Animal animal : animals)
		{
		   ArrayList<Toy> dToys = animal.getToys();
		   for (int i = 0; i < dToys.size(); i++) {
			   
			   if (dToys.indexOf(dToys.get(i)) != dToys.lastIndexOf(dToys.get(i))) {
					   dToys.remove(i);
					   i--;
			   }
		   }
		}
	}
	
	public void add(Animal a) {
		animals.add(a);
	}
}

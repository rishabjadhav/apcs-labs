import java.util.ArrayList;

public class Animal {
	
	private String name;
	private int birthyear;
	private ArrayList<Toy> toys = new ArrayList<Toy>();
	private Animal friend = null;
	public static int currentYear = 2021;
	
	public void addToy(Toy toy) {
		toys.add(toy);
	}
	
	public Animal() {
		
	}
	
	public void setFriend(Animal a) {
		this.friend = a;
	}
	
	public ArrayList<Toy> getToys() {
		return toys;
	}

	public Animal(String name, int birthyear) {
		this.name = name;
		this.birthyear = birthyear;
	}
	
	public int currentAge() {
		return currentYear - birthyear;
	}
	
	public String toString() {
		if (friend != null) {
			return "Hello, I am " + name + ", I am " + currentAge() + " years old. "
					+ "\nI have a friend named " + friend.name
					+ "\nI have the following toys : " + toys;
			
		}
		else {
			return "Hello, I am " + name + ", I am " + currentAge() + " years old. "
					+ "\nI have no friends"
					+ "\nI have the following toys : " + toys;
		}
	}
}

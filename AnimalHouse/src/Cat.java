
public class Cat extends Animal {
	private int numLives;
	
	public Cat() {
		super();
	}
	
	public Cat(String name, int birthyear) {
		super(name, birthyear);
		numLives = 9;
	}
	
	public Cat(String name, int birthyear, int numLives) {
		super(name, birthyear);
		this.numLives = numLives;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\nI have " + numLives + " lives.";
	}

}
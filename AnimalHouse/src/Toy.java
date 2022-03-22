
public class Toy {
	private String name;
	
	public Toy() {
		
	}
	
	public Toy(String name) {
		this.name = name;
	}
	
	public String toString() {
		return "A " + name;
	}
	
	@Override
	public boolean equals(Object toy) {
		Toy temp = (Toy) toy;
		if (temp.name.equals(this.name)) {
			return true;
		}
		else {
			return false;
		}
	}


}

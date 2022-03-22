
public class Dog extends Animal {
	private boolean goodBoy;
	
	public Dog() {
		super();
	}
	
	public Dog(String name, int birthyear, boolean goodBoy) {
		super(name, birthyear);
		this.goodBoy = goodBoy;
	}
	
	@Override
	public String toString() {
		if (goodBoy == true) {
			return super.toString() + "\nI am a good boy.";
		}
		else {
			return super.toString() + "\nI am not a good boy.";
		}
	}
	
}

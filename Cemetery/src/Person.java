
public class Person {
	private String name;
	private int IQ;
	
	public Person () {
		IQ = 0;
	}
	
	public Person (String nameP, int IQp) {
		name = nameP;
		IQ = IQp;
	}
	
	public int getIQ() {
		return IQ;
	}

	public String getName() {
		return name;
	}
	
	
}

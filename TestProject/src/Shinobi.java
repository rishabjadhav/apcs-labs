
public class Shinobi {
	private String name;
	private int age;
	
	public Shinobi() {
		
	}
	
	public Shinobi(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void intro() {
		System.out.print("My name is " + name + " and I am " + age + " years old");
	}
}

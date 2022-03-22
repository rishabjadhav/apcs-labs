
public class Jonin extends Shinobi {
	private static String chakraStyle;
	
	public Jonin() {
		super();
	}
	
	public Jonin(String name, int age, String chakraStyle) {
		super(name, age);
		this.chakraStyle = chakraStyle;
	}
	
	public void isJonin() {
		System.out.println(true);
	}
	
	@Override
	public void intro() {
		super.intro();
		System.out.println(" and I am a jonin");
	}
	
	public static void chakra() {
		System.out.println("my chakra style is " + chakraStyle);
	}
}

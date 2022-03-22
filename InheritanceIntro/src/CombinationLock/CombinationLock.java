package CombinationLock;
import java.util.Scanner;
public class CombinationLock extends Lock {
	Scanner console = new Scanner(System.in);
	private String combination;
	
	public CombinationLock() {
		super();
		combination = "";
	}
	
	public CombinationLock(String combo) {
		super();
		combination = combo;
	}
	
	public void open() {
		System.out.println("Enter combination");
		String combo = console.next();
		if (combo.equals(combination) == true) {
			super.open();
		}
		else {
			System.out.println("Incorrect combination");
		}
	}
	
	public String toString() {
		return super.toString() + "\n" + "Combination = " + combination + "\n";
	}

	public String getCombination() {
		return combination;
	}

	public void setCombination(String combination) {
		this.combination = combination;
	}

}

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Cemetery {
	private ArrayList<Tombstone> list;
	
	public Cemetery() {
		
	}
	
	public Cemetery(String fileName) {
		int sumAge = 0;
		int i = 0;
		list = new ArrayList <Tombstone>();
		File file = new File(fileName);
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
			
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String name = line.substring(0, 25);
				String date = line.substring(25, 37);
				String age = line.substring(37, 41);
				String address = line.substring(42);
				Tombstone t = new Tombstone(name.trim(), date.trim(), parseAge(age.trim()), address.trim());
				list.add(t);
				
				if (address.contains("Little Carter Lane")) {
					sumAge += parseAge(age.trim());
					i++;
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		float avgAge = sumAge / i;
		System.out.println((double)Math.round(avgAge/365 * Math.pow(10, 1)) / Math.pow(10, 1));
	}
	
	/** 
	 * convert the ageString to a number of days; age can 
	 * take a variety of forms in the data file
	 */
	public static int parseAge(String ageString)
	{
		if (ageString.contains("d")) { //age supplied in days
			ageString = ageString.replaceAll("d", "");
			return Integer.parseInt(ageString);
		}
		
		int result = 0;
		
		boolean done = true;

		try { result = Integer.parseInt(ageString); } //is the String a whole number of years?
		
		catch (NumberFormatException n) { done = false; }
		
		if (done) //successfully parsed as an int, return value
			return 365 * result; //ignoring leap years
		
		double ageDouble = 0;
		
		done = true;
		
		try { ageDouble = Double.parseDouble(ageString); } //is the String a floating point number of years?
		
		catch (NumberFormatException n) { done = false; }
		
		if (done) { //successfully parse as a double, String doesn't contain any text
			return (int)(ageDouble * 365); //ignoring leap years, using 30 for days in a month
		}
		
		if (ageString.contains("w")) { //age is supplied in weeks, return appropriately
			ageString = ageString.replaceAll("w", "");
			return Integer.parseInt(ageString) * 7;
		}
		
		return 0;
	}
}

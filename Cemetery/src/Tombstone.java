
public class Tombstone {
	private String name;
	private String burialDate;
	private int age;
	private String address;
	
	public Tombstone() {
		
	}
	
	public Tombstone (String nameT, String burialDateT, int ageT, String addressT) {
		name = nameT;
		burialDate = burialDateT;
		age = ageT;
		address = addressT;
	}

	public String getName() {
		return name;
	}

	public String getBurialDate() {
		return burialDate;
	}

	public int getAge() {
		return age;
	}

	public String getAddress() {
		return address;
	}
	
	public String toString() {
		return "Name : " + name + " // Burial Date : " + burialDate + " // Age : " + age + " // Address : " + address;
		
	}
	

}

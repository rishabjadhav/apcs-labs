
public class Student implements Comparable<Student> {
	private String name;
	private int studentID;
	
	public Student(String n, int id) {
		this.name = n;
		this.studentID = id;
	}

	public boolean equals(Student s) {
		if (this.name.contains(s.name)) {
			if (this.studentID == s.studentID) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return studentID + " : " + name;
	}

	@Override
	public int compareTo(Student o) {
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		if (equals(o) == true) {
			return 0;
		}
		
		if (alphabet.indexOf(name.substring(0, 1)) == alphabet.indexOf(o.name.substring(0, 1))) {
			return 0;
		}
		else if (alphabet.indexOf(name.substring(0, 1)) < alphabet.indexOf(o.name.substring(0, 1))) {
			return 1;
		}
		else {
			return -1;
		}
		
		
		//
		
//		if (this.studentID == o.studentID) {
//			return 0;
//		}
//		else if (this.studentID > o.studentID) {
//			return 1;
//		}
//		else {
//			return -1;
		
	}

	public String getName() {
		return name;
	}

	public int getStudentID() {
		return studentID;
	}


}

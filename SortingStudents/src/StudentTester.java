import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class StudentTester
{
	
	public static ArrayList<Student> students = new ArrayList<Student>();
	
	public static void main(String[] args)
	{
		
		try {
			File file = new File("names.csv");
			Scanner console = new Scanner(file);
			Random rng = new Random();
			while (console.hasNext()) {
				int rand = rng.nextInt(999999);
				if (rand < 100000) {
					rand *= 10;
				}
				Student s = new Student(console.next(), rand);
				students.add(s);
			}
			console.close();
		} catch(FileNotFoundException e) {
			System.out.println("404");
		}
		Student s = new Student("Alda", 123456);
		
		System.out.println(indexOf(s));
		
		System.out.println(students);
		
		
		
		////
		
//		Student a = new Student("Joe", 100009);
//		Student b = new Student("Sally", 100004);
//		Student c = new Student("Sam", 100007);
//		Student d = new Student("Bob", 100006);
//
//		List<Student> list = new ArrayList<>();
//
//		list.add(a); list.add(b); list.add(c); list.add(d);
//
//		Collections.sort(list); //this wouldn't compile if Student didn't implement Comparable!
//
//		System.out.println(list); //implicit call to ArrayList's (and therefore Student's) toString()
	}
	
	public static void sort() {
 		for (int a = 0; a < students.size() - 1; a++) {
 			int smallestIndex = a;
 	            
 	        for (int b = a + 1; b < students.size(); b++) {
 	        	if (students.get(b).compareTo(students.get(smallestIndex)) == 1) {
 	                	smallestIndex = b;
 	            }
 	        }
 	        
 	       Student temp = students.get(smallestIndex);
 	       students.set(smallestIndex, students.get(a));
 	       students.set(a, temp);
 	    }
 	}
	
	public static int indexOf(Student s) {
		sort();
		int low = 0;
		int high = students.size() - 1;
		
		while (low <= high) {
			int mid = (high + low) / 2;
			
			if (students.get(mid).compareTo(s) == -1) {
				high = mid - 1;
			}
			else if (students.get(mid).compareTo(s) == 1) {
				low = mid + 1;
			}
			else {
				return mid;
			}
		}
		return -1;
	}
}

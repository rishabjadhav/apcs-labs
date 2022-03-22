import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) 
	{
		/* (1)
		 * An ArrayList is a class that is very similar to an array, whereas an array is
		 * a built-in type. The number of elements can be changed in an ArrayList, but not
		 * in an array. The syntax differs between ArrayList and array.
		 */
		
		//2
		ArrayList <String> story = new ArrayList <String>();
		story.add("It");
		story.add("was");
		story.add("a");
		story.add("stormy");
		story.add("night");
		
		System.out.println("The size of the ArrayList is " + story.size());
		System.out.println("The ArrayList is of the String type");
		
		//3
		story.add(3, "dark");
		story.add(4, "and");
		
		//4
		story.set(1, "IS");
		
		//5
		for (int i = 0; i < story.size(); i++)
		{
			if (story.get(i).contains("a"))
			{
				story.remove(i);
				i--;
			}
		}
		
		for (int i = 0; i < story.size(); i++)
		{
			System.out.println(story.get(i));
		}
	}

}

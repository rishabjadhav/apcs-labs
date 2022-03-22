
public class Runner {

	public static void main(String[] args) {
		int[] arr = {9, 5, 4, 3, 7, 6, 8, 1, 2};
		SearchSort s = new SearchSort(10);
		int i = 6;
//		System.out.println(s.linearSearch(i));
//		System.out.println(s.binarySearch(i));
//		System.out.println(s.linearSearchRecur(i));
//		System.out.println(s.binarySearchRecur(i));
		
		s.bubbleSort(false);
		s.selectionSort(false);
		s.insertionSort(false);
		
	}

}

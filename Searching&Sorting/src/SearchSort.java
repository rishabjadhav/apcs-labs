import java.util.Arrays;
import java.util.Random;

public class SearchSort {
	private int[] nums;
	
	public SearchSort(int[] nums) {
		this.nums = nums;
	}
	
	public SearchSort(int size) {
		nums = new int[size];
		initArray();
	}
	
	public void initArray() {
		Random rng = new Random(1000);
		for (int i = 0; i < nums.length; i++) {
			nums[i] = rng.nextInt();
		}
	}
	
	public void swap(int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
	
	public int linearSearch(int key) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == key) {
				return i;
			}
		}
		return -1;
	}
	
	public int linearSearchRecur(int key) {
		return linearSearchRecur(key, 0);
	}
	private int linearSearchRecur(int key, int index) {
		if (index == nums.length) {
			return -1;
		}
		else if (nums[index] == key) {
			return index;
		}
		else {
			index++;
			return linearSearchRecur(key, index);
		}
	}
	
	public int binarySearch(int key) {
		Arrays.sort(nums);
		int low = 0;
		int high = nums.length - 1;
		
		while (low <= high) {
			int mid = (high + low) / 2;
			
			if (nums[mid] > key) {
				high = mid - 1;
			}
			else if (nums[mid] < key) {
				low = mid + 1;
			}
			else {
				return mid;
			}
		}
		return -1;
	}
	
	public int binarySearchRecur(int key) {
		return binarySearchRecur(key, 0, nums.length - 1);
	}
	
 	private int binarySearchRecur(int key, int low, int high) {
		Arrays.sort(nums);
		int mid = (high + low) / 2;
		
		if (low >= high) {
			return -1;
		}
		else if (nums[mid] > key) {
			high = mid - 1;
			return binarySearchRecur(key, low, high);
		}
		else if (nums[mid] < key) {
			low = mid + 1;
			return binarySearchRecur(key, low, high);
		}
		else {
			return mid;
		}
		
	}
 	
 	public void bubbleSort(boolean print) {
        for (int a = nums.length - 1; a > 0; a--) {
        	for (int b = 0; b < a; b++) {
        		if (nums[b] > nums[b + 1]) {
        			swap(b, b + 1);
        		}	
        	}
        	if (print) {print();}
        }
        print();
    }
 	
 	//6. 6 ZEROS IN A MILLION
 	
 	public void selectionSort(boolean print) {
 		for (int a = 0; a < nums.length - 1; a++) {
 			int smallestIndex = a;
 	            
 	        for (int b = a + 1; b < nums.length; b++) {
 	        	if (nums[b] < nums[smallestIndex]) {
 	                	smallestIndex = b;
 	            }
 	        }
 	           
 	        if (print) {print();}
 	  
 	        int temp = nums[smallestIndex];
 	        nums[smallestIndex] = nums[a];
 	        nums[a] = temp;
 	    }
 		print();
 	}
 	
 	public void insertionSort(boolean print) {
        for (int a = 1; a < nums.length; a++) {
            int key = nums[a];
            int b = 0;
            
            for (b = a - 1; b >= 0 && nums[b] > key; b--) {
            	nums[b + 1] = nums[b];
            }
            
            nums[b + 1] = key;
            if (print) {
            	print();
            	System.out.println();
            }
            
        }
        
        print();
 	}
 	
 	public void mergeSort(boolean print) {
 		//TODO
 	}
 	
 	//10. 7 DIGITS IN A TELEPHONE NUMBER
 	
 	public void print() {
 		System.out.print("[");
 		for (int i = 0; i < nums.length; i++) {
 			if (i == nums.length - 1) {
 				System.out.print(nums[i]);
 				continue;
 			}
 			System.out.print(nums[i] + ", ");
 			
 		}
 		System.out.println("]");
 		System.out.println();
 	}
}



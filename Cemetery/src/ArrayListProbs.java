import java.util.ArrayList;
import java.util.Random;

public class ArrayListProbs {
	
	public ArrayListProbs() {
		
	}
	
	public void makeListAndPrint(int num, int limit) {
		ArrayList<Integer> list = new ArrayList<Integer>();

		Random rng = new Random();
		for (int i = 0; i < num; i++) {
			list.add(rng.nextInt(limit)+1);

		}
		System.out.println(list);
	}
	
	public ArrayList<Integer> addOne(ArrayList<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			list.set(i, list.get(i) + 1);
			
		}
		return list;
	}
	
	public ArrayList<Integer> minToFront(ArrayList<Integer> list) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) < min) {
				min = list.get(i);
			}
		}
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(min);
		for (int i = 1; i < list.size() + 1; i++) {
			list2.add(list.get(i - 1));
		}
		return list2;
	}
	
	public ArrayList<String> removeDupes(ArrayList<String> list) {
		
		for (int i = 0; i < list.size(); i++) {
			if ((i > 0) && (list.get(i) == list.get(i - 1))) {
				list.remove(i);
				i--;
			}
		}
		return list;
	}
	
	public ArrayList<Integer> swapPairs(ArrayList<Integer> list) {
		ArrayList<Integer> listSwap = new ArrayList<Integer>();
		for (int i = 1; i < list.size() + 1; i++) {
			listSwap.add(list.get(i));
			listSwap.add(list.get(i - 1));
			i++;
		}
		return listSwap;
	}
	
	public ArrayList<String> removeLenN(ArrayList<String> list, int n) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).length() == n) {
				list.remove(i);
				i--;
			}
		}
		return list;
	}
	
	//9 : The letter 'e'
	
	public int dumbestPerson(ArrayList<Person> list) {
		int minIndex = 0;
		if (list.get(0).getIQ() < list.get(1).getIQ())
		{
			minIndex = 0;
		}
		else {minIndex = 1;}
	
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getIQ() < list.get(minIndex).getIQ()) {
				minIndex = i;
			}
		}
		return minIndex;
	}
	
	public Book highestPricedBook(ArrayList<Book> list) {
		int maxIndex = 0;
		if (list.get(0).getPrice() < list.get(1).getPrice()) {
			maxIndex = 1;
		}
		else {
			maxIndex = 0;
		}
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getPrice() > list.get(maxIndex).getPrice()) {
				maxIndex = i;
			}
		}
		return list.get(maxIndex);
	}
	
	public ArrayList<Book> banBook(ArrayList<Book> list, Book book) {
		 for (int i = 0; i < list.size(); i++) {
			 if (list.get(i).getTitle() == book.getTitle())
			 {
				 list.remove(i);
				 i--;
			 }
		 }
		 return list;
	 }
	
	public double bookstoreValue(Bookstore store) {
		double sum = 0;
		for (int i = 0; i < store.numBooks(); i++) {
			sum += store.getBook(i).getPrice();
		}
		return sum;
	}
}




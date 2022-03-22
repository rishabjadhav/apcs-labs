import java.util.ArrayList;

public class Bookstore {
	private ArrayList<Book> inventory;
	
	
	public Bookstore() {
		inventory = new ArrayList<Book>();
	}
	
	public void addBook(Book b) {
		inventory.add(b);
	}
	
	public int numBooks() {
		return inventory.size();
	}
	
	public Book getBook(int index) {
		if (index < 0 || index >= inventory.size()) {return null;}
		else {return inventory.get(index);}
	}
	
	//bookstoreValue method is implemented in ArrayListProbs class
	//public double bookstoreValue(Bookstore store) 
}

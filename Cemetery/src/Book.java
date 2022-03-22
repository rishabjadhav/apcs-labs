
public class Book {
	private String title;
	private String author;
	private double price;
	
	public Book () {
		
	}
	
	public Book (String titleB, String authorB, double priceB) {
		title = titleB;
		author = authorB;
		price = priceB;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public double getPrice() {
		return price;
	}
	
	public String toString() {
		return title + ", by " + author + ". Cost: $" + price;
	}
}

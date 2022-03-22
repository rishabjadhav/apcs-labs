import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListProbsRunner {

	public static void main(String[] args) {
		
		/*
		ArrayListProbs test = new ArrayListProbs();
		
		test.makeListAndPrint(5, 100);
		
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(1);
		list.add(2);
		list.add(2);
		list.add(4);
		System.out.println(test.addOne(list));
		
		
		System.out.println(test.minToFront(list));
		
		
		ArrayList<String> listDupes = new ArrayList<String>();
		listDupes.add("hello");
		listDupes.add("how");
		listDupes.add("are");
		listDupes.add("you");
		listDupes.add("you");
		listDupes.add("today");
		listDupes.add("today");
		//Should return "hello how are you today"
		System.out.println(test.removeDupes(listDupes));
		
		
		ArrayList<Integer> pairsSwap = new ArrayList<Integer>();
		pairsSwap.add(2);
		pairsSwap.add(1);
		pairsSwap.add(4);
		pairsSwap.add(3);
		pairsSwap.add(6);
		pairsSwap.add(5);
		//Should return 1, 2, 3, 4, 5, 6
		System.out.println(test.swapPairs(pairsSwap));
		
		
		ArrayList<String> listLength = new ArrayList<String>();
		listLength.add("hello");
		listLength.add("remove");
		listLength.add("my");
		listLength.add("remove");
		listLength.add("name");
		listLength.add("is");
		listLength.add("remove");
		listLength.add("remove");
		listLength.add("john");
		listLength.add("remove");
		//Should return "hello my name is john"
		System.out.println(test.removeLenN(listLength, 6));
		
		
		ArrayList<Person> personList = new ArrayList<Person>();
		Person John = new Person("John", 115);
		personList.add(John);
		Person Gale = new Person("Gale", 145);
		personList.add(Gale);
		Person Mia = new Person("Mia", 125);
		personList.add(Mia);
		Person Kyle = new Person("Kyle", 90);
		personList.add(Kyle);
		Person Ana = new Person("Ana", 120);
		personList.add(Ana);
		//Should return 3 (Kyle)
		System.out.println(test.dumbestPerson(personList));
		
		
		ArrayList<Book> bookList = new ArrayList<Book>();
		Book harryPotter = new Book("Harry Potter", "JK Rowling", 13.99);
		bookList.add(harryPotter);
		Book lordOfTheRings = new Book("Lord of the Rings", "JRR Tolkien", 19.99);
		bookList.add(lordOfTheRings);
		Book greenEggsAndHam = new Book("Green Eggs and Ham", "Dr Seuss", 9.99);
		bookList.add(greenEggsAndHam);
		Book nineteenEightyfour = new Book("1984", "George Orwell", 14.99);
		bookList.add(nineteenEightyfour);
		Book hungerGames = new Book("The Hunger Games", "Suzanne Collins", 17.99);
		bookList.add(hungerGames);
		//Should return lordOfTheRings
		System.out.println(test.highestPricedBook(bookList));
		
	
		ArrayList<Book> bookList2 = new ArrayList<Book>();
		Book toKillAMockingbird = new Book("To Kill A Mockingbird", "Harper Lee", 12.99);
		bookList2.add(toKillAMockingbird);
		Book warAndPeace = new Book("War and Peace", "Leo Tolstoy", 21.99);
		bookList2.add(warAndPeace);
		Book ofMiceAndMen = new Book("Of Mice and Men", "John Steinbeck", 18.99);
		bookList2.add(ofMiceAndMen);
		Book theCatcherInTheRye = new Book("The Catcher in the Rye", "JD Salinger", 16.99);
		bookList2.add(theCatcherInTheRye);
		Book adventuresOfHuckleberryFinn = new Book("The Adventures of Huckleberry Finn", "Mark Twain", 13.99);
		bookList2.add(adventuresOfHuckleberryFinn);
		//Should return all but warAndPeace
		System.out.println(test.banBook(bookList2, warAndPeace));
		*/
		ArrayListProbs a = new ArrayListProbs(); //use this object to call the methods
		 
		a.makeListAndPrint(12, 50); //make 12 random items, from 1 to 50
		System.out.println(a.addOne(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4))));
		System.out.println(a.minToFront(new ArrayList<Integer>(Arrays.asList(2, 4, -5, 3))));
		System.out.println(a.removeDupes(new ArrayList<String>(Arrays.asList("to", "to", "be", "be", "be", "be", "or"))));
		System.out.println(a.swapPairs(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4))));
		System.out.println(a.removeLenN(new ArrayList<String>(Arrays.asList("wow", "hello", "world", "omg")), 3));
		
		System.out.println(a.dumbestPerson(new ArrayList<Person>(Arrays.asList(new Person("Rita", 150), 
			new Person("Ron", 100), new Person("Ronda", 120))))); 
		System.out.println(a.highestPricedBook(new ArrayList<Book>(Arrays.asList(new Book("Book 1", "Author 1", 12.99), 
			new Book("Book 2", "Author 2", 15.99), new Book("Book 3", "Author 3", 9.99)))).toString());
		System.out.println(a.banBook(new ArrayList<Book>(Arrays.asList(new Book("Book 1", "Author 1", 12.99), 
			new Book("Book 2", "Author 2", 15.99), new Book("Book 3", "Author 3", 9.99))), new Book("Book 1", "Author 1", 12.99)));
		
		Bookstore store = new Bookstore();
		store.addBook(new Book("Book 1", "Author 1", 12.99)); store.addBook(new Book("Book 2", "Author 2", 15.99));
		store.addBook(new Book("Book 3", "Author 3", 9.99));
		System.out.println(a.bookstoreValue(store));
	}
}

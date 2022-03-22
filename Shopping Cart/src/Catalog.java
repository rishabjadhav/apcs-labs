import java.util.ArrayList;

public class Catalog {
	private String name;
	private ArrayList<Item> list = new ArrayList<Item>();
	
	public Catalog (String name) {
		this.name = name;
	}
	
	public void add (Item item) {
		//System.out.println("in Catalog.add()");
		list.add(item);
	}
	
	public int size () {
		//System.out.println("in Catalog.size()");
		return list.size();
	}
	
	public Item get (int index) {
		//System.out.println("in Catalog.get(" + index + ")");
		return list.get(index);
	}
	
	public String getName () {
		//System.out.println("in Catalog.getName()");
		return name;
	}
}

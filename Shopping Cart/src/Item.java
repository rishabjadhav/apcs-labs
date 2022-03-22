
public class Item {
	
	private String name;
	private double price;
	private int bulkQuantity;
	private double bulkPrice;
	
	public Item (String name, double price) {
		this.name = name;
		this.price = price;
		
		if (this.price < 0) {
			throw new IllegalArgumentException("Cannot have negative price.");
		}
	}
	
	public Item (String name, double price, int bulkQuantity, double bulkPrice) {
		this.name = name;
		this.price = price;
		this.bulkQuantity = bulkQuantity;
		this.bulkPrice = bulkPrice;
		
		if (this.price < 0) {
			throw new IllegalArgumentException("Cannot have negative price.");
		}
		
		if (this.bulkPrice < 0) {
			throw new IllegalArgumentException("Cannot have negative price.");
		}
		
		if (this.bulkQuantity < 1) {
			throw new IllegalArgumentException("Illegal bulk quantity.");
		}
	}
	
	public double priceFor (int quantity) {
		//System.out.println("in Item.priceFor(" + quantity + ")");
		if (quantity < 0) {
			throw new IllegalArgumentException("Cannot have negative quantity.");
		}
		
		if (bulkQuantity == 0) {
			return quantity * price;
		}
		
		int x = quantity / bulkQuantity;
		int y = quantity % bulkQuantity;
		return (bulkPrice * x) + (y * price);
	}
	
	public String toString () {
		if (bulkQuantity != 0) {
			return name + ", " + price + "(" + bulkQuantity + " for " + bulkPrice + ")";
		}
		else {
			return name + ", " + price;
		}
	}

	public String getName() {
		return name;
	}

}

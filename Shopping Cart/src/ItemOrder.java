
public class ItemOrder {
	private int quantity;
	private Item item;
	public ItemOrder () {
		
	}
	
	public ItemOrder (Item item, int quantity) {
		this.quantity = quantity;
		this.item = item;
	}
	
	public double getPrice () {
		//System.out.println("in ItemOrder.getPrice()");
		return item.priceFor(quantity);
	}
	
	public Item getItem () {
		//System.out.println("in ItemOrder.getItem()");
		return item;
	}

	public int getQuantity() {
		return quantity;
	}
}

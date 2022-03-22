import java.util.ArrayList;
import java.text.*;

public class ShoppingCart {
	private ArrayList<ItemOrder> list = new ArrayList<ItemOrder>();
	private boolean discount;
	
	public ShoppingCart () {
		
	}
	
	public void add (ItemOrder itemorder) {
		System.out.println(itemorder.getItem().getName() + " : " + itemorder.getQuantity());
		boolean dupe = false;

		for (int i = 0; i < list.size(); i++) {
			
			if (list.get(i).getItem().getName() == itemorder.getItem().getName()) {
				list.set(i, itemorder);
				dupe = true;
				break;
			}
		}
		if (dupe == false) {
			list.add(itemorder);
		}
	}
	
	public void setDiscount (boolean discount) {
		//System.out.println("in ShoppingCart.setDiscount()");
		this.discount = discount;
		
	}
	
	public double getTotal () {
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		//System.out.println("in ShoppingCart.getTotal()");
		double total = 0;
		for (int i = 0; i < list.size(); i++) {
			total += list.get(i).getPrice();
		}
		
		if (this.discount == true) {
			total *= 0.9;
		}
		String totalS = nf.format(total);
		System.out.println("order total : " + totalS);
		return total;
	}
}

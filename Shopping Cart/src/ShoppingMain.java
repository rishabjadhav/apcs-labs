// Stuart Reges 3/28/07
// 

// ShoppingMain provides method main for a simple shopping program.

public class ShoppingMain {
    public static void main(String[] args) {
        Catalog list = new Catalog("Overlake APCS Gift Catalog");
        list.add(new Item("silly putty", 3.95, 10, 19.99));
        list.add(new Item("Game of Life circuit", 3.50, 10, 14.95));
        list.add(new Item("bottle o bubbles", 0.99));
        list.add(new Item("Nintendo Wii system", 199.99));
        list.add(new Item("Mario Computer Science Party 2 (Wii)", 49.99));
        list.add(new Item("Don Knuth Code Jam Challenge (Wii)", 49.99));
        list.add(new Item("Computer Science pen", 3.40));
        list.add(new Item("Rubik's cube", 9.10));
        list.add(new Item("Computer Engineering Barbie", 19.99));
        list.add(new Item("'Java Rules!' button", 0.99, 10, 5.0));
        list.add(new Item("'Java Rules!' bumper sticker", 0.99, 20, 8.95));
        
        ShoppingFrame f = new ShoppingFrame(list);
        f.setVisible(true);
        
        /*
        ShoppingCart cart = new ShoppingCart();
        ItemOrder putty = new ItemOrder(new Item("silly putty", 3.95, 10, 19.99), 1);
        cart.add(putty);
        cart.getTotal();
        
        ItemOrder GOL = new ItemOrder(new Item("Game of Life circuit", 3.50, 10, 14.95), 1);
        cart.add(GOL);
        cart.getTotal();
        
        ItemOrder putty2 = new ItemOrder(new Item("silly putty", 3.95, 10, 19.99), 2);
        cart.add(putty2);
        cart.getTotal();
        
        ItemOrder gol2 = new ItemOrder(new Item ("Game of Life circuit", 3.50, 10, 14.95), 11);
        cart.add(gol2);
        cart.getTotal();
        
        ItemOrder wia = new ItemOrder((new Item("Computer Engineering Barbie", 19.99)), 1);
        cart.add(wia);
        
        ItemOrder JRB = new ItemOrder((new Item("'Java Rules!' button", 0.99, 10, 5.0)), 11);
        cart.add(JRB);
        
        ItemOrder jwiu = new ItemOrder(new Item("'Java Rules!' bumper sticker", 0.99, 20, 8.95), 22);
        cart.add(jwiu);
        cart.getTotal();
        
        cart.setDiscount(true);
        cart.getTotal();
        
        cart.setDiscount(false);
        cart.getTotal();
        */
        
    }
}

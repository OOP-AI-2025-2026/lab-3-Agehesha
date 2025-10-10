
import java.math.BigDecimal;


public class Main {
public static void main(String[] args) {
Item apple = new Item("A1", "Apple", new BigDecimal("19.99"));
Item banana = new Item("B2", "Banana", new BigDecimal("9.49"));


Cart cart = new Cart();
cart.add(apple, 2); 
cart.add(banana, 3);
cart.setQuantity(banana, 1); 


System.out.println("Cart:");
for (String line : cart.snapshotView()) System.out.println(" " + line);
System.out.println("Cart total = " + cart.total());


Order order = Order.fromCart("ORD-1001", "Roman Shugaev", cart);
System.out.println("\nOrder " + order.getOrderId() + " for " + order.getCustomer());
for (String line : order.viewLines()) System.out.println(" " + line);
System.out.println("Order total = " + order.total());


order.pay();
System.out.println("Status after pay = " + order.getStatus());
}
}

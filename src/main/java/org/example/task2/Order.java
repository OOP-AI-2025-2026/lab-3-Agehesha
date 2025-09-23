package org.example.task2;


public class Order {
    private final long id;
    private final String customer;

    public Order(long id, String customer) {
        this.id = id;
        this.customer = customer;
    }


    public String formOrderBill(Cart cart) {
        StringBuilder builder = new StringBuilder();
        builder.append("Order number ").append(this.id)
               .append(" for customer ").append(this.customer);
        builder.append("\n------------------\n");

        double sum = 0.0;
        Item[] items = cart.getSnapshot();

        for (Item it : items) {
            sum += it.getPrice();
            builder.append("Item id: ").append(it.getId())
                   .append(" name: ").append(it.getName())
                   .append(" price: ").append(it.getPrice())
                   .append("\n");
        }

        builder.append("------------------\n");
        builder.append("Total sum: ").append(sum);

        return builder.toString();
    }
}

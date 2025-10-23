package org.example.task2;

public class Order {
    private final long id;
    private final String customer;

    public Order(long id, String customer) {
        if (id <= 0) throw new IllegalArgumentException("id must be > 0");
        if (customer == null || customer.isBlank()) throw new IllegalArgumentException("customer is required");
        this.id = id;
        this.customer = customer;
    }

    public String formOrderBill(Cart cart) {
        StringBuilder b = new StringBuilder()
            .append("Order number ").append(id)
            .append(" for customer ").append(customer)
            .append("\n------------------\n");
        for (Item it : cart.toArray()) {
            b.append("Item id: ").append(it.getId())
             .append(" name: ").append(it.getName())
             .append(" price: ").append(it.getPrice())
             .append("\n");
        }
        b.append("------------------\nTotal sum: ").append(cart.total());
        return b.toString();
    }
}

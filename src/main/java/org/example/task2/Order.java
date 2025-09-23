package org.example.task2;

public class Order {
  private final long id;
  private final String customer;

  public Order(long id, String customer) {
    this.id = id;
    this.customer = customer;
  }

  public String formOrderBill(Cart cart) {
    StringBuilder sb = new StringBuilder();
    sb.append("Order number ").append(this.id)
      .append(" for customer ").append(this.customer)
      .append("\n------------------\n");

    double sum = 0.0;
    for (Item it : cart.getSnapshot()) {
      sum += it.getPrice();
      sb.append("Item id: ").append(it.getId())
        .append(" name: ").append(it.getName())
        .append(" price: ").append(it.getPrice())
        .append("\n");
    }

    sb.append("------------------\n")
      .append("Total sum: ").append(sum);

    return sb.toString();
  }
}

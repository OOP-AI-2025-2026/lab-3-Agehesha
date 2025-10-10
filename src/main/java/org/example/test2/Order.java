
private final String orderId;
private final String customer;
private final LocalDateTime createdAt;
private final List<OrderLine> lines;
private Status status;


public Order(String orderId, String customer, List<OrderLine> lines) {
if (orderId == null || orderId.isBlank()) throw new IllegalArgumentException("orderId blank");
if (customer == null || customer.isBlank()) throw new IllegalArgumentException("customer blank");
if (lines == null || lines.isEmpty()) throw new IllegalArgumentException("empty order lines");
this.orderId = orderId;
this.customer = customer;
this.createdAt = LocalDateTime.now();
this.lines = new ArrayList<>(lines); 
this.status = Status.NEW;
}



public static Order fromCart(String orderId, String customer, Cart cart) {
if (cart == null || cart.isEmpty()) throw new IllegalArgumentException("cart empty");
List<OrderLine> copy = new ArrayList<>();
for (String s : cart.snapshotView()) {
copy.add(new OrderLine(s));
}
return new Order(orderId, customer, copy);
}


public String getOrderId() { return orderId; }
public String getCustomer() { return customer; }
public LocalDateTime getCreatedAt() { return createdAt; }
public Status getStatus() { return status; }


public List<String> viewLines() {
List<String> v = new ArrayList<>();
for (OrderLine l : lines) v.add(l.readonlyText());
return Collections.unmodifiableList(v);
}


public BigDecimal total() {

BigDecimal sum = BigDecimal.ZERO;
for (OrderLine l : lines) {
String t = l.readonlyText();
int idx = t.lastIndexOf('=');
if (idx >= 0 && idx + 1 < t.length()) {
String num = t.substring(idx + 1).trim();
try {
sum = sum.add(new BigDecimal(num));
} catch (NumberFormatException ignore) { /* noop */ }
}
}
return sum;
}


public void pay() {
ensure(Status.NEW, "pay");
this.status = Status.PAID;
}


public void cancel() {
ensure(Status.NEW, "cancel");
this.status = Status.CANCELED;
}


private void ensure(Status expected, String action) {
if (this.status != expected) {
throw new IllegalStateException("Cannot " + action + " when status=" + this.status);
}
}


private static final class OrderLine {
private final String text;
private OrderLine(String text) { this.text = text; }
private String readonlyText() { return text; }
}
}

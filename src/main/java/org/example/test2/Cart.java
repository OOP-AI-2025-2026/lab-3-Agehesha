import java.math.BigDecimal;
import java.util.*;


public class Cart {

private final Map<Item, Integer> lines = new LinkedHashMap<>();


public void add(Item item, int quantity) {
validate(item, quantity);
int old = lines.getOrDefault(item, 0);
lines.put(item, old + quantity);
}


public void setQuantity(Item item, int quantity) {
validate(item, quantity);
if (quantity == 0) {
lines.remove(item);
} else {
lines.put(item, quantity);
}
}


public void remove(Item item) {
if (item == null) return;
lines.remove(item);
}


public void clear() { lines.clear(); }


public boolean isEmpty() { return lines.isEmpty(); }


public int uniqueItems() { return lines.size(); }


public BigDecimal total() {
BigDecimal sum = BigDecimal.ZERO;
for (Map.Entry<Item, Integer> e : lines.entrySet()) {
BigDecimal line = e.getKey().getPrice().multiply(BigDecimal.valueOf(e.getValue()));
sum = sum.add(line);
}
return sum;
}



List<String> out = new ArrayList<>();
for (Map.Entry<Item, Integer> e : lines.entrySet()) {
out.add(e.getKey().getName() + " x" + e.getValue() + " = " +
e.getKey().getPrice().multiply(BigDecimal.valueOf(e.getValue())));
}
return Collections.unmodifiableList(out);
}


private void validate(Item item, int quantity) {
if (item == null) throw new IllegalArgumentException("item is null");
if (quantity < 0) throw new IllegalArgumentException("quantity < 0");
}
}


import java.math.BigDecimal;
import java.util.Objects;


public final class Item {
private final String id;
private final String name;
private final BigDecimal price; 


public Item(String id, String name, BigDecimal price) {
if (id == null || id.isBlank()) throw new IllegalArgumentException("id is blank");
if (name == null || name.isBlank()) throw new IllegalArgumentException("name is blank");
if (price == null || price.signum() < 0) throw new IllegalArgumentException("price < 0");
this.id = id;
this.name = name;
this.price = price;
}


public String getId() { return id; }
public String getName() { return name; }
public BigDecimal getPrice() { return price; }


@Override public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof Item)) return false;
Item item = (Item) o;
return id.equals(item.id);
}


@Override public int hashCode() { return Objects.hash(id); }


@Override public String toString() {
return "Item{" +
"id='" + id + '\'' +
", name='" + name + '\'' +
", price=" + price +
'}';
}
}

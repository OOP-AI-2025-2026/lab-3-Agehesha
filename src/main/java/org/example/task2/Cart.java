package ua.opnu;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class Cart {
    // Весь стан кошика — тут. Жодних масивів/індексів.
    private final Map<Item, Integer> lines = new LinkedHashMap<>();

    public void add(Item item) {
        add(item, 1);
    }

    public void add(Item item, int qty) {
        if (item == null) throw new IllegalArgumentException("item is null");
        if (qty <= 0) throw new IllegalArgumentException("qty must be > 0");
        lines.merge(item, qty, Integer::sum);
    }

    public void remove(Item item) {
        if (item == null) return;
        lines.remove(item);
    }

    public double getTotal() {
        double sum = 0.0;
        for (Map.Entry<Item, Integer> e : lines.entrySet()) {
            sum += e.getKey().getPrice() * e.getValue();
        }
        return sum;
    }

    public int getItemCount() {
        int count = 0;
        for (int q : lines.values()) count += q;
        return count;
    }

    public List<String> viewLines() {
        List<String> out = new ArrayList<>();
        for (Map.Entry<Item, Integer> e : lines.entrySet()) {
            out.add(e.getKey().getName() + " x " + e.getValue());
        }
        return Collections.unmodifiableList(out);
    }

    public void clear() {
        lines.clear();
    }

  
    Map<Item, Integer> snapshot() {
        return new LinkedHashMap<>(lines);
    }

    public boolean isEmpty() {
        return lines.isEmpty();
    }
}

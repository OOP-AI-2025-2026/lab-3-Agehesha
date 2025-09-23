package org.example.task2;


public class Item {
    private final long id;
    private String name;
    private double price;

    public Item(long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price < 0 ? 0.0 : price;
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    // Optional mutators if needed later (kept encapsulated)
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price < 0 ? 0.0 : price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + this.id +
                ", price=" + this.price +
                ", name='" + this.name + '\'' +
                "}";
    }
}

package org.example.task2;

import java.util.Arrays;

public class Cart {
    private final Item[] contents;
    private int size; // number of actual items

    public Cart(int capacity) {
        if (capacity <= 0) capacity = 1;
        this.contents = new Item[capacity];
        this.size = 0;
    }

    /**
     * Adds an item if there is space and item is non-null.
     * @return true if added, false otherwise
     */
    public boolean add(Item item) {
        if (item == null || this.isFull()) return false;
        this.contents[this.size] = item;
        this.size++;
        return true;
    }

    /**
     * Removes an item by its id (NOT by index).
     * @return true if removed, false if not found
     */
    public boolean removeById(long id) {
        if (this.size == 0) return false;
        int idx = this.findIndexById(id);
        if (idx == -1) return false;
        this.shiftLeftFrom(idx);
        return true;
    }

    /**
     * @return current number of items in cart
     */
    public int getSize() {
        return this.size;
    }

    /**
     * @return true if the cart is full
     */
    public boolean isFull() {
        return this.size == this.contents.length;
    }

    /**
     * @return true if the cart is empty
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Returns a safe snapshot of current items (no nulls, exact size).
     */
    public Item[] getSnapshot() {
        return Arrays.copyOf(this.contents, this.size);
    }

    /**
     * Internal: find index by item id among active items.
     */
    private int findIndexById(long id) {
        for (int i = 0; i < this.size; i++) {
            if (this.contents[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Internal: shift elements left from the given index, shrink size by 1.
     */
    private void shiftLeftFrom(int index) {
        for (int i = index; i < this.size - 1; i++) {
            this.contents[i] = this.contents[i + 1];
        }
        this.contents[this.size - 1] = null;
        this.size--;
    }

    @Override
    public String toString() {
        Item[] active = this.getSnapshot();
        return "Cart{contents=" + Arrays.toString(active) + "}\n";
    }
}


package org.example.task2;

import java.util.Arrays;

public class Cart {
  private final Item[] contents;
  private int size;

  public Cart(int capacity) {
    if (capacity <= 0) {
      capacity = 1;
    }
    this.contents = new Item[capacity];
    this.size = 0;
  }

  public boolean add(Item item) {
    if (item == null || isFull()) {
      return false;
    }
    this.contents[this.size] = item;
    this.size++;
    return true;
  }

  public boolean removeById(long id) {
    if (this.size == 0) {
      return false;
    }
    int idx = findIndexById(id);
    if (idx == -1) {
      return false;
    }
    shiftLeftFrom(idx);
    return true;
  }

  public Item[] getSnapshot() {
    return Arrays.copyOf(this.contents, this.size);
  }

  public boolean isFull() {
    return this.size == this.contents.length;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  public int getSize() {
    return this.size;
  }

  private int findIndexById(long id) {
    for (int i = 0; i < this.size; i++) {
      if (this.contents[i].getId() == id) {
        return i;
      }
    }
    return -1;
  }

  private void shiftLeftFrom(int index) {
    for (int i = index; i < this.size - 1; i++) {
      this.contents[i] = this.contents[i + 1];
    }
    this.contents[this.size - 1] = null;
    this.size--;
  }

  @Override
  public String toString() {
    return "Cart{contents=" + Arrays.toString(getSnapshot()) + "}\n";
  }
}

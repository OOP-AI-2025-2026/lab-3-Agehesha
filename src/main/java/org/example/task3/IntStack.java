package org.example.task3;

import java.util.NoSuchElementException;

public class IntStack {
    private int[] data;
    private int size;

    public IntStack() {
        this.data = new int[8];
        this.size = 0;
    }

    public void push(int value) {
        ensureCapacity(size + 1);
        data[size++] = value;
    }

    public int pop() {
        if (isEmpty()) throw new NoSuchElementException("stack is empty");
        int v = data[--size];
        return v;
    }

    public int peek() {
        if (isEmpty()) throw new NoSuchElementException("stack is empty");
        return data[size - 1];
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    public void clear() { size = 0; }

    private void ensureCapacity(int min) {
        if (min <= data.length) return;
        int newCap = Math.max(min, data.length * 2);
        int[] next = new int[newCap];
        System.arraycopy(data, 0, next, 0, size);
        data = next;
    }
}

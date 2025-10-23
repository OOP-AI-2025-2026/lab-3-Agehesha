package org.example.task1;

public class Main {
    public static void main(String[] args) {
        Box box = new Box(2.5, 3.0, 4.0);
        System.out.println("Surface area = " + box.surfaceArea());
        System.out.println("Lateral area = " + box.lateralArea());
        System.out.println("Volume       = " + box.volume());
    }
}

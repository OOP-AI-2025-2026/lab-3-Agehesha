package ua.opnu;


public class Main {
    public static void main(String[] args) {
        // Valid example
        Box box = new Box(5, 3, 4);
        System.out.println("Volume: " + box.getVolume());
        System.out.println("Lateral surface area: " + box.getLateralSurfaceArea());
        System.out.println("Total surface area: " + box.getSurfaceArea());

        // Invalid example -> zero-sized box (soft validation, no exceptions)
        Box invalid = new Box(-1, 2, 3);
        System.out.println("Invalid box volume (expected 0): " + invalid.getVolume());
    }
}

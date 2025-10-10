package ua.opnu;

public class MainBox {
    public static void main(String[] args) {
        try {
            Box b = new Box(2.0, 3.0, 4.0);
            System.out.println("Surface area = " + b.getSurfaceArea());
            System.out.println("Lateral surface area = " + b.getLateralSurfaceArea());
            System.out.println("Volume = " + b.getVolume());
        } catch (IllegalArgumentException e) {
            System.out.println("Input error: " + e.getMessage());
        }
    }
}

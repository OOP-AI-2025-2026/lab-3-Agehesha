public class Main {
public static void main(String[] args) {
Box box = new Box(2.5, 1.2, 0.8);


System.out.printf("Surface area: %.4f\n", box.surfaceArea());
System.out.printf("Lateral surface area: %.4f\n", box.lateralSurfaceArea());
System.out.printf("Volume: %.4f\n", box.volume());
}
}

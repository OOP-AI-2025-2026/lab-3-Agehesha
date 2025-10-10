public class Box {
private double length;
private double width;
private double height;
public Box(double length, double width, double height) {
setLength(length);
setWidth(width);
setHeight(height);
}
public double getLength() { return length; }
public double getWidth() { return width; }
public double getHeight() { return height; }
private void setLength(double length) {
validatePositive("length", length);
this.length = length;
}
private void setWidth(double width) {
validatePositive("width", width);
this.width = width;
}
private void setHeight(double height) {
validatePositive("height", height);
this.height = height;
}
private void validatePositive(String name, double value) {
if (value <= 0) {
throw new IllegalArgumentException(name + " must be > 0");
}
}
public double surfaceArea() {
return 2.0 * (length * width + length * height + width * height);
}
public double lateralSurfaceArea() {
return 2.0 * (length + width) * height;
}
public double volume() {
return length * width * height;
}
}

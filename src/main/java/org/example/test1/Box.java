package org.example.task1;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    private void setLength(double v) { validate(v, "length"); this.length = v; }
    private void setWidth(double v)  { validate(v, "width");  this.width  = v; }
    private void setHeight(double v) { validate(v, "height"); this.height = v; }

    private static void validate(double v, String name) {
        if (v <= 0) throw new IllegalArgumentException(name + " must be > 0");
    }

    public double surfaceArea() {
        return 2 * (length*width + width*height + length*height);
    }

    public double lateralArea() {
        return 2 * height * (length + width);
    }

    public double volume() {
        return length * width * height;
    }
}

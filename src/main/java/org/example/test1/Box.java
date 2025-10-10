package ua.opnu;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        setDimension(length, "length");
        setDimension(width, "width");
        setDimension(height, "height");
    }

    private void setDimension(double value, String name) {
        if (value <= 0) {
            throw new IllegalArgumentException(name + " must be greater than 0");
        }
        switch (name) {
            case "length":
                this.length = value;
                break;
            case "width":
                this.width = value;
                break;
            case "height":
                this.height = value;
                break;
            default:
                throw new IllegalArgumentException("Unknown dimension: " + name);
        }
    }

    public double getSurfaceArea() {
        return 2 * (length * width + length * height + width * height);
    }

    public double getLateralSurfaceArea() {
        return 2 * height * (length + width);
    }

    public double getVolume() {
        return length * width * height;
    }
}

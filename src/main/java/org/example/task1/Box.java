package ua.opnu;


public class Box {
    double length; 
    double width; 
    double height; 

    // Package-private constructor (same style as TimeSpan)
    Box(double length, double width, double height) {
        if (length <= 0 || width <= 0 || height <= 0) {
            this.length = 0;
            this.width = 0;
            this.height = 0;
        } else {
            this.length = length;
            this.width = width;
            this.height = height;
        }
    }

    /** Volume: V = l * w * h */
    double getVolume() {
        return length * width * height;
    }

    /** Lateral surface area (without top and bottom): A_lat = 2lh + 2wh */
    double getLateralSurfaceArea() {
        return 2 * length * height + 2 * width * height;
    }

    /** Total surface area: A_total = 2lw + 2lh + 2wh */
    double getSurfaceArea() {
        return 2 * length * width + 2 * length * height + 2 * width * height;
    }
}

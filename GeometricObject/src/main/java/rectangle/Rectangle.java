package rectangle;

import geometricobject.GeometricObject;

public class Rectangle extends GeometricObject {
    private double x, y;

    public Rectangle() {
        x = 10;
        y = 20;
    }

    public Rectangle(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getPerimeter() {
        return 2 * (x + y);
    }
    public double getArea() {
        return x * y;
    }
}

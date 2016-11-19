package circle;

import geometricobject.GeometricObject;

public class Circle extends GeometricObject {
    private double radius;

    public Circle() {
        setRadius(1.0);
    }

    public Circle(double radius) {
        setRadius(radius);
    }

    public void setRadius(double newRadius) {
        radius = newRadius;
    }

    public double getPerimeter() {
        return 2 * 3.1415926 * radius;
    }

    public double getArea() {
        return 3.1415926 * radius * radius;
    }
}

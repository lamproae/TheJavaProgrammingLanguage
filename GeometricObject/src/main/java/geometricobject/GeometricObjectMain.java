package geometricobject;

import circle.Circle;
import rectangle.Rectangle;

public class GeometricObjectMain {
    public static void main(String[] args) {
        Circle c = new Circle();
        Rectangle r = new Rectangle();
        System.out.println(c);
        c.setFilled(true);
        System.out.println(c);
        System.out.println(r);
        r.setColor("blue");
        System.out.println(r);
    }
}

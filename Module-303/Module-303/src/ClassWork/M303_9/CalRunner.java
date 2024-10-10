package ClassWork.M303_9;

import java.util.ArrayList;
import java.util.List;

public class CalRunner {
    public static void main(String[] args) {
        Circle c = new Circle();
        c.setRadius(10.0);
        c.setName("circle");

        Circle c1 = new Circle();
        c.setRadius(101.0);
        c.setName("circle 1");

        Triangle t = new Triangle();
        t.setHeight(7);
        t.setBase(8);
        t.setName("triangle");

        List<Shape> shapes = new ArrayList<>();
        shapes.add(c);
        shapes.add(c1);
        shapes.add(t);



    }
}

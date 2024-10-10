package ClassWork.M303_9;

public class Runner {
    public static void main(String[] args) {
        Circle c = new Circle();
        c.setRadius(10.0);
        c.setName("circle");

        Circle c1 = new Circle();
        c1.setRadius(101.0);
        c1.setName("circlle");

        Triangle t = new Triangle();
        t.setBase(12);
        t.setName("tri");

        System.out.println("c1: " +c.getRadius());
        System.out.println("c1: " +c1.getRadius());
    }
}

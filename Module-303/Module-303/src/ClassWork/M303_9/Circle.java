package ClassWork.M303_9;

public class Circle extends Shape{
    private static double radius; //<---static only exist in memory once, examples in Runner.java

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return 3.14 * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 3.14 * (2 * radius);
    }
}

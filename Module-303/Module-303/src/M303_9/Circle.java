package M303_9;

public class Circle extends Shape{
    private static double radius; //<---static only exist in memory once, examples in Runner.java

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}

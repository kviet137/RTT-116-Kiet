package ClassWork.M303_9;

public class Triangle extends Shape {
    private int base;
    private int height;

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return .5 * base * height;
    }

    @Override
    public double calculatePerimeter() {
        return 2*base + 2*height;
    }
}
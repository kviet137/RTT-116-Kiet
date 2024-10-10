package ClassWork.M303_8;

import java.util.Objects;

public class Square {
    private char height;
    private char width;


    public Square() {
    }

    public Square(char height, char width) {
        this.height = height;
        this.width = width;
    }

    public String toString(){
        return "height: " + height + " width: " + width;
    }

    public void setHeight(char height) {
        this.height = height;
        //return this.height; -->Cannot return a value from a method with void result type
    }

    public void setWidth(char width) {
        this.width = width;
    }

    public char getHeight() {
    return height;
    }
    public char getWidth() {
        return width;
    }

    @Override  //just trying the Generate Option
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Square square)) return false;
        return height == square.height && width == square.width;
    }

    @Override //just trying the Generate Option
    public int hashCode() {
        return Objects.hash(height, width);
    }

    private void privateAvailable(){
        //this is only available within the Square class itself
    }
    public void publicAvailable(){
        //this is available everywhere
    }
    protected void partlyAvailable(){
        //this is only available within the PACKAGE
        //protected will be assigned if it doesn't specify when creating a function
    }


}

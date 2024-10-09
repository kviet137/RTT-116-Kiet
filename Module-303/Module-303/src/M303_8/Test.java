package M303_8;

import java.util.Objects;

public class Test {
    private char height;
    private char width;




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

    public static double sayWhat(){
        return 24.0;
    }
    public static int sayWhat(int w){
        return 24;
    }
    public static void main(String[] args) {
        Test s1 = new Test();
        System.out.println(s1.toString());


    }
}



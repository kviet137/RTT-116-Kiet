package org.perscholas;

public class WrapperClassesExamples {
    public static void autobox(Integer x){
        System.out.println("Function called with " + x);
    }
    public static void main (String [] args){
        int x = 5;
        Integer y = x;
        Integer z = Integer.valueOf(x);

        autobox(5);
        autobox( x);
        autobox(y);
        autobox(z);


    }
}

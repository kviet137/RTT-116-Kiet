package org.perscholas;

public class EscapeSequenceExamples {
    public static void main (String [] args){
        System.out.print("this is line 1.\n");
        System.out.println("this is ->\b<-line 2.");

        String x = "st";

        System.out.println(x.getBytes());
    }
}

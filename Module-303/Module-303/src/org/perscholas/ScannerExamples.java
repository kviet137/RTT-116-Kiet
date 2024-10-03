package org.perscholas;
import  java.util.Scanner;

public class ScannerExamples {

    public static void main(String[] args){
        System.out.print("enter a radius:");

        Scanner scanner = new Scanner(System.in);

        double x = scanner.nextDouble();

        System.out.println("you entered a radius " + x);

        double area = x * x + 3.14159;

        System.out.println("the area of a cirle is " + area);

    }
}

package HomeWork.M303;

import java.util.Scanner;

public class PA_303_2_2 {
    public static void main (String [] args){
        //1.In this challenge, you must read  integers from stdin and then print them
        // to stdout. Each integer must be printed on a new line. To make the problem
        // a little easier, a portion of the code is provided for you in the editor below
        // Input Format
        //There are 3 lines of input, and each line contains a single integer.

        Scanner scanner = new Scanner(System.in);

        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();


        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num3);


        //2.In this challenge, you must read an integer, a double, and a String
        // from stdin, then print the values according to the instructions in the
        // Output Format section below. To make the problem a little easier, a
        // portion of the code is provided for you in the editor.
        //Input Format:
        //There are three lines of input:
        //A.The first line contains an integer.
        //B.The second line contains a double.
        //CThe third line contains a String.
        //Output Format
        //There are three lines of output:
        //A.On the first line, print String: followed by the unaltered String read from
        // stdin.
        //BOn the second line, print Double: followed by the unaltered double read from
        // stdin.
        //C.On the third line, print Int: followed by the unaltered integer read from
        // stdin.

        int intValue = scanner.nextInt();
        double doubleValue = scanner.nextDouble();
        scanner.nextLine();
        String stringValue = scanner.nextLine();

        System.out.println("String: " + stringValue);
        System.out.println("Double: " + doubleValue);
        System.out.println("Int: " + intValue);
    }
}

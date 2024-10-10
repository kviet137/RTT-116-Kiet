package HomeWork.M303_5;

import java.util.Scanner;

public class GLAB303_5_1 {
    public static void main(String[] args) {

        //question1
        int n = 5;
        // for loop
        for (int i = 1; i <= n; ++i) {
            System.out.println("Java is fun");
        }

        //question2
        int sum = 0;
        int n2 = 1000;
        // for loop
        for (int i = 1; i <= n2; ++i) {
            // body inside for loop
            sum += i;     // sum = sum + i
        }
        System.out.println("Sum = " + sum);

        //question3
        String original, reverse = ""; // Objects of String class
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a string/number to check if it is a palindrome");
        original = in.nextLine();
        int length = original.length();
        for ( int i = length - 1; i >= 0; i-- )
            reverse = reverse + original.charAt(i);
        if (original.equals(reverse)) {
            System.out.println("Entered string/number is a palindrome.");
        }else
        {
            System.out.println("Entered string/number isn't a palindrome.");
        }


    }


}

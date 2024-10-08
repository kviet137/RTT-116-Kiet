package HomeWork.M303;

import java.util.Scanner;

public class PA303_5_1 {
    public static void main(String[] args) {
        //question1
        int maxNum = 12;

        for (int i = 1; i <= maxNum; i++) {
            for (int j = 1; j <= maxNum; j++) {
                System.out.print(i * j + " ");
            }
            System.out.println();
        }
        //question2
        Scanner input = new Scanner(System.in);


        System.out.print("Enter the first positive number (n1): ");
        int n1 = input.nextInt();
        System.out.print("Enter the second positive number (n2): ");
        int n2 = input.nextInt();


        int smaller;
        if (n1 < n2) {
            smaller = n1;
        } else {
            smaller = n2;
        }

        int gcd = 1;
        for (int k = 2; k <= smaller; k++) {
            if (n1 % k == 0 && n2 % k == 0) {
                gcd = k;
            }
        }

        System.out.println("The GCD of " + n1 + " and " + n2 + " is :" + gcd);

        //question3

        double tuition = 10000;
        double target = 20000;
        int years = 0;


        while (tuition < target) {
            tuition = tuition * 1.07;
            years++;
        }

        // Display the result
        System.out.println("It will take " + years + " years for the tuition to double.");

    }
}


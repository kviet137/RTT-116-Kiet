package HomeWork.M303;

import java.util.Scanner;

public class PA303_4_1 {
    public static void main(String[] args) {

        //question1
        int x = 7;
        if (x < 10) {
            System.out.println("Less than 10");
        }

        x = 15;
        if (x < 10) {
            System.out.println("Less than 10");
        }


        //question2
        int x2 = 7;
        if (x2 < 10) {
            System.out.println("Less than 10");
        } else {
            System.out.println("Greater than 10");
        }

        x2 = 15;
        if (x2 < 10) {
            System.out.println("Less than 10");
        } else {
            System.out.println("Greater than 10");
        }


        //question3
        int x3 = 15;
        if (x3 < 10) {
            System.out.println("Less than 10");
        } else if (x3 > 10 && x3 < 20) {
            System.out.println("Between 10 and 20");
        } else {
            System.out.println("Greater than or equal to 20");
        }

        x3 = 50;
        if (x3 < 10) {
            System.out.println("Less than 10");
        } else if (x3 > 10 && x3 < 20) {
            System.out.println("Between 10 and 20");
        } else {
            System.out.println("Greater than or equal to 20");
        }

        //question4
        int x4 = 15;
        if (x4 < 10 || x4 > 20) {
            System.out.println("Out of range");
        } else {
            System.out.println("In range");
        }


        x4 = 5;
        if (x4 < 10 || x4 > 20) {
            System.out.println("Out of range");
        } else {
            System.out.println("In range");
        }

        //question6
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a score (0 - 100): ");
        int score = input.nextInt();

        if (score < 0 || score > 100) {
            System.out.println("Score out of range");
        } else if (score >= 90) {
            System.out.println("Grade: A");
        } else if (score >= 80) {
            System.out.println("Grade: B");
        } else if (score >= 70) {
            System.out.println("Grade: C");
        } else if (score >= 60) {
            System.out.println("Grade: D");
        } else {
            System.out.println("Grade: F");
        }


        //question6
        System.out.print("Enter a number between 1 and 7: ");
        int day = input.nextInt();

        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Out of range");
                break;
        }
    }
}

package M303_4;

import java.util.Scanner;

public class IfStatementsExample {
    public static void main(String[] args) {
        int year = 1534;
        if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
            System.out.println("Leap year");
        } else {
            System.out.println("Leap year");
        }

    }
}


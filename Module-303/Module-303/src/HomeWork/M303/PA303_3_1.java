package HomeWork.M303;

import java.util.Scanner;

public class PA303_3_1 {
    public static void main(String[] args) {
        //1.Given two strings of lowercase English letters,A  and B, perform the
        // following operations: Sum the lengths of A  and B.
        //Determine if A is lexicographically larger than B
        // (i.e.: does  A come before B in the dictionary?).
        //Capitalize the first letter in  A and B and print them on a single line,
        // separated by a space.
        //The first line contains a string A . The second line contains another string B.
        // The strings are comprised of only lowercase English letters.
        //There are three lines of output:
        //For the first line, sum the lengths of A and B .
        //For the second line, write Yes if A is lexicographically greater than B otherwise
        //print No instead.
        //For the third line, capitalize the first letter in both A and B  and print
        //them on a single line, separated by a space.

        Scanner scanner = new Scanner(System.in);

        String A = scanner.nextLine();
        String B = scanner.nextLine();

        int lengthSum = A.length() + B.length();
        System.out.println(lengthSum);


        if (A.compareTo(B) > 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        String capitalizedA = Character.toUpperCase(A.charAt(0)) + A.substring(1);
        String capitalizedB = Character.toUpperCase(B.charAt(0)) + B.substring(1);
        System.out.println(capitalizedA + " " + capitalizedB);

        //2.

        String s2 = scanner.nextLine();

        int start = scanner.nextInt();
        int end = scanner.nextInt();

        String substring = s2.substring(start, end);
        System.out.println(substring);

        //3.

        String s3 = scanner.nextLine();
        int k3 = scanner.nextInt();

        String result3 = getSmallestAndLargest(s3, k3);
        System.out.println(result3);


        //4.
        
        String A4 = scanner.nextLine();

        if (isPalindrome(A4)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        //5.

        String s5 = scanner.nextLine();
        String[] tokens = s5.split("[^A-Za-z]+");

        int count = 0;
        for (String token : tokens) {
            if (!token.isEmpty()) {
                count++;
            }
        }
        System.out.println(count);

        for (String token : tokens) {
            if (!token.isEmpty()) {
                System.out.println(token);
            }
        }

    }

    public static String getSmallestAndLargest(String s, int k) {

        String smallest = s.substring(0, k);
        String largest = s.substring(0, k);


        for (int i = 1; i <= s.length() - k; i++) {
            String substring = s.substring(i, i + k);

            if (substring.compareTo(smallest) < 0) {
                smallest = substring;
            }
            if (substring.compareTo(largest) > 0) {
                largest = substring;
            }
        }

        return smallest + "\n" + largest;
    }

    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
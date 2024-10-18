package ClassWork.M303_13;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class ScannerWriter {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            File file = new File("C:\\Users\\Learner_9ZH3Z105\\development\\RTT-166-Classwork\\Module-303\\Module-303\\src\\temp2.txt");
            PrintWriter pw = new PrintWriter(file);

            System.out.println("enter a string to write to the file: ");
            String input = scanner.nextLine();

            pw.println(input);
            pw.flush();
        } catch (Exception e) {
        }
    }
}


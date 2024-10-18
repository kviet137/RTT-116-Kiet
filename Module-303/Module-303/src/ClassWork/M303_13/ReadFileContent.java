package ClassWork.M303_13;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ReadFileContent {
    public static void main(String[] args) {

        try {
            File file = new File("src/temp.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));

            String st;
            while ((st = br.readLine()) != null) {
                System.out.println(st);
            }
        } catch (Exception e) {

        }
    }

}

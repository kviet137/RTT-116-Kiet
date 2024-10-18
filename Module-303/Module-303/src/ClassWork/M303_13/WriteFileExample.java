package ClassWork.M303_13;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class WriteFileExample {
    public static void main(String[] args) {

        File file = new File("C:\\Users\\Learner_9ZH3Z105\\development\\RTT-166-Classwork\\Module-303\\Module-303\\src\\temp1.txt");

        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(file,true));
            bw.write("Line1\n");
            bw.write("Line2\n");
            bw.write("more on Line2!@!");

            bw.flush();
            bw.close();
        }catch (Exception e){

        }
    }
}

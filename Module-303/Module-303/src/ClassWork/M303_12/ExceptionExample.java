package ClassWork.M303_12;

public class ExceptionExample {
    public static void main(String[] args) {

        int [] numbers = { 1 , 2 , 3 , 4 , 5 };
        try {
            System.out.println(numbers[10]);
        } catch (Exception e) {
            System.out.println("print the exception message " + e);

        }finally {
            //finally block is optional
            //this code will execute no matter what
            //in both success or failure cases
            //often times it is used to clean up or close a resource like to close a file
            System.out.println("finally block");
        }
    }
}

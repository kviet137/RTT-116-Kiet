package ClassWork.M303_12;

public class CheckedExceptionExample {

    //=======>>>In this example, this will throw at the start() function
    //********NOTICE how the start() function doesnt have the extended "throws" next to its name
    //******ALSO inside the start function doesnt need to have the "throw" exception because of the "catch"<<<======


    // this one chooses to deal with the exception in the start method after being thrown again by method1

    public void start() {
        // start method has now the same choice in either deal with it or throw it again
        try {
            method1();
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

    public void method1() throws CustomException {
        System.out.println("method1");

        // whats shown here is #2
        method2();
    }

    // throwing an exception here causes method1 to have to
    // 1) either catch the exception with a try catch block
    // or
    // 2) throw the exception for the calling method to catch
    public void method2() throws CustomException {
        System.out.println("method2");
        throw new CustomException("Error in method 2");//this will not print unless u catch
                                                        //the e from try/catch and print it from there
    }


    public static void main(String[] args) {
        CheckedExceptionExample cee = new CheckedExceptionExample();
        cee.start();
    }
}

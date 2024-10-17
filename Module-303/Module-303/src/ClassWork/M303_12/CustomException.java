package ClassWork.M303_12;

public class CustomException extends Exception {

    //when making a custom exception, the naming practice is to always end with the word exception
    //Making your own custom exception
    //1. extends Exception
    //2. we create a constructor that takes a string and calls super to set it on the parent
    //--->> this will be on the SBA

    public CustomException(String message) {
        super(message);
    }

}

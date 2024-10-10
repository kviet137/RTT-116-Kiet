package ClassWork;

public class ForLoopsExamples {
    public static void main(String[] args) {
        String[] strings = {"one", "two", "three"};
        String characters = "abcde";


        for (int count = 0; count < strings.length; count++) {
            System.out.println("String at position " + count + ":" + strings[count]);
        }

        for (int count = 0; count < characters.length(); count++) {
            System.out.println("Characters at position " + count + ":" + characters.charAt(count));
        }

        // new style for loop for an array

        for (String value : strings){ //for each value in strings
            System.out.println("new style for loop for an array :"+ value);

        }
    }
}

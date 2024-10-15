package HomeWork.M303_10.PA303_10_2;

public class Main {
    public static void main(String[] args) {
        MyBook new_novel = new MyBook();  // Create an instance of MyBook
        new_novel.setTitle("The Great Gatsby");  // Set the title
        System.out.println("The title is: " + new_novel.getTitle());  // Print the title
    }
}
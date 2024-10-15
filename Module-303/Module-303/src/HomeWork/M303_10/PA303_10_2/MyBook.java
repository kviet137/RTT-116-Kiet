package HomeWork.M303_10.PA303_10_2;

class MyBook extends Book {
    // Implement the abstract method from the Book class
    @Override
    void setTitle(String s) {
        title = s;  // Set the title inherited from the Book class
    }
}
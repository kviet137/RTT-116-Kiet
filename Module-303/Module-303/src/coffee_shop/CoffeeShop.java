package coffee_shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoffeeShop {
    private Scanner scanner = new Scanner(System.in);
    private List<Product> products = new ArrayList<>();
    private List<Product> cart = new ArrayList<>();


    private void initProducts() {
        Product p1 = new Product("Small Coffee", 4.57, 0);
        products.add(p1);
        Product p2 = new Product("Large Coffee", 7.99, 0);
        products.add(p2);
        Product p3 = new Product("Sugar Cookie", 5.89, 0);
        products.add(p3);
        Product p4 = new Product("Egg Sandwich", 6.49, 0);
        products.add(p4);
    }


    private void printProductMenu() {
        for (int count = 0; count < products.size(); count++) {
            Product p = products.get(count);
            // count + 1 the complier will recognize the math and increment the value of count
            // before using it to create the string that is printed
            System.out.println((count + 1) + ") " + p.getName() + " \t " + p.getPrice());
        }
        // give some white space after print
        System.out.println("");
    }


    private int printMainMenu() throws InvalidInputException {
        System.out.println("1) See product menu");
        System.out.println("2) Purchase product");
        //System.out.println("3) View Cart");
        System.out.println("3) Checkout");
        System.out.println("4) Exit");

        int selection = readNumberFromUser("Enter Selection: ");
        return selection;
    }

    private int readNumberFromUser(String question) throws InvalidInputException{
        System.out.print(question);
        try {
            int selection = scanner.nextInt();
            return selection;
        } catch (Exception e){
            throw new InvalidInputException("Invalid Input: " + e.getMessage());

        }finally {
            scanner.nextLine();
        }

    }

    public void addProductToCart() throws InvalidInputException {
        // 1 display the items for sale
        printProductMenu();
        int selection= readNumberFromUser("Enter product number: ");;


        // we want to check that the user has entered a valid product number
        if (isProductSelectionValid(selection)) {
            int quantity= readNumberFromUser("How many would you like to add?: ");
            //check if the users enter a valid inputs of the amount

            Product p = products.get(selection - 1);

            if (!cart.contains(p)) {
                cart.add(p);
            }

            if (quantity >=0) {
                quantity = p.getQuantity() + quantity;
                p.setQuantity(quantity);
            } else{
                System.out.println("Please enter a valid quantity");
            }
            System.out.println("Added " + p.getQuantity() + " " + p.getName() + " to your cart.\n");
        } else {
            System.out.println("Invalid item selection");
        }
    }

    private boolean isProductSelectionValid (int selectedProduct){
        if (selectedProduct >= 1 && selectedProduct  <= products.size()){
            return true;
        }
        return false;
    }

    public void checkout() {
        //!!!!!!!!!!!!!!!!!!!!need to empty the cart and reset the quantity for all products!!!!!!!!!!!!!!!!
        System.out.println("==== Items in your cart ====");

        // list the items in the cart
        double subtotal = 0.0;
        for (Product item : cart) {
            System.out.println(item.getName() + "\tx" + item.getQuantity() + " \t $" + item.getPrice());
            subtotal = subtotal + (item.getPrice() * item.getQuantity());
        }
        System.out.println("");
        System.out.println("Subtotal\t\t $" + subtotal);

        // assume there is a 9% sales tax to be applied to the order
        // calculate tax
        double tax = subtotal * 0.09;
        System.out.printf("Tax\t\t\t\t $%.2f%n", tax);

        // calculate total amount
        // adding an addtional () will cause it to do the math
        double total = (subtotal + tax);
        System.out.printf("Total\t\t\t $%.2f%n\n", total);
    }

    public void start(){
        // this becomes similar to the main method in that it will be where our project starts and runs
        // 1) initialize the products for sale
        initProducts();

        // repeat forever until the user enters selection 4 which will exit the program
        while (true) {
            try {
                // print the menu and get back the user selected input
                int selection = printMainMenu();

                if (selection == 1) {
                    // print the product menu
                    printProductMenu();
                } else if (selection == 2) {
                    // purchase product / add to cart
                    addProductToCart();
                }
//            else if (selection == 3) {
//                System.out.println("not yet implemented");
//               //view cart
//            }
                else if (selection == 3) {
                    // checkout
                    checkout();
                } else if (selection == 4) {
                    System.out.println("Good bye");
                    // we are exiting with a value of 0 means successful exit
                    // this ends the program
                    System.exit(0);
                } else {
                    System.out.println("Invalid Selection " + selection + "\n");
                }
            }catch (InvalidInputException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args)  {
        CoffeeShop cs = new CoffeeShop();
        cs.start();
    }
}



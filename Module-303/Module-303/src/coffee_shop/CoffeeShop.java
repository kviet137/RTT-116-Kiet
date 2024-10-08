package coffee_shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoffeeShop {

    // we will use this is a couple functions to read input from the user
    private Scanner scanner = new Scanner(System.in);

    // this is a class level variable that will contain our list of products for sale
    // best practice is to define these at the top of the class
    private List<Product> products = new ArrayList<>();

    // this will hold the products that we are going to purchase
    private List<Product> cart = new ArrayList<>();
    int quantity;

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

    private int printMainMenu() {
        System.out.println("1) See product menu");
        System.out.println("2) Purchase product");
        System.out.println("3) View Cart");
        System.out.println("4) Checkout");
        System.out.println("5) Exit");

        System.out.print("\nEnter Selection :");

        try {
            int selection = scanner.nextInt();
            return selection;
        } catch (Exception e) {
            System.out.println("Invalid selection " + e.getMessage());
            return -1;
        } finally {
            scanner.nextLine();
        }
    }

    public void addProductToCart() {
        // 1 display the items for sale
        printProductMenu();

        // 2 prompt the user to enter an item # to buy
        System.out.print("Enter product number:");
        int selection = scanner.nextInt();
        scanner.nextLine();



        // we want to check that the user has entered a valid product number
        if (selection >= 1 && selection <= products.size()) {
            System.out.print("How many would you like to add?:");
            quantity = scanner.nextInt();
            scanner.nextLine();

            Product p = products.get(selection - 1);
            if (quantity >=1){
                p.setQuantity(quantity);
            }
            else if (quantity == 0){
                p.setQuantity(quantity);
                System.out.println("You are removing " + p.getName() + " from cart");
            }else{
                System.out.println("Please enter a valid quantity");
            }


            // 3 add to the cart array
            // we are subtracting 1 from the user input to get the real position in the array
            // because most people do not have a concept of the 0th item in a list

            for (int i = 0; i < quantity; i++) {
                if (cart.contains(p)) {
                    continue;
                }else{
                    cart.add(p);
                }


            }
            System.out.println("Added " + p.getQuantity() + " " + p.getName() + " to your cart.\n");

        } else {
            System.out.println("Invalid item selection");
        }

    }

    public void checkout() {
        System.out.println("==== Items in your cart ====");

        // list the items in the cart
      double subtotal = 0.0;
        for (Product item : cart) {
            System.out.println(item.getName() + "\tx" + item.getQuantity() + " \t $" + item.getPrice());
            subtotal = subtotal + item.getPrice();
        }



        System.out.println("");
        System.out.println("Subtotal\t\t $" + subtotal);

        // assume there is a 9% sales tax to be applied to the order
        // calculate tax
        double tax = subtotal * 0.09;
        System.out.println("Tax\t\t\t\t $" + tax);

        // calculate total amount
        // adding an addtional () will cause it to do the math
        double total = (subtotal + tax);
        System.out.println("Total\t\t\t $" + total + "\n");
    }

    public void start() {
        // this becomes similar to the main method in that it will be where our project starts and runs
        // 1) initialize the products for sale
        initProducts();

        // repeat forever until the user enters selection 4 which will exit the program
        while (true) {
            // print the menu and get back the user selected input
            int selection = printMainMenu();

            if (selection == 1) {
                // print the product menu
                printProductMenu();
            } else if (selection == 2) {
                // purchase product / add to cart
                addProductToCart();
            }else if (selection == 3) {
                System.out.println("not yet implemented");
               //view cart
            }
            else if (selection == 4) {
                // checkout
                checkout();
            } else if (selection == 5) {
                System.out.println("Good bye");

                // we are exiting with a value of 0 means successful exit
                // this ends the program
                System.exit(0);
            } else {
                System.out.println("Invalid command entered " + selection + "\n");
            }
        }

    }

    public static void main(String[] args) {
        CoffeeShop cs = new CoffeeShop();
        cs.start();
    }
}



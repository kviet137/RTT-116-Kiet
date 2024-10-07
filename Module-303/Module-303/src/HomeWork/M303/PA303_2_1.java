package HomeWork.M303;

public class PA303_2_1 {
    public static void main (String [] args){

        //1.Write a program that declares two integer variables, assigns an integer
        // to each, and adds them together. Assign the sum to a variable.
        // Print out the result.

        int question1Int1;
        int question1Int2;
        question1Int1 = 22;
        question1Int2 = 100;
        int question1Sum = question1Int1 + question1Int2;
        System.out.println("#1: "+ question1Sum);

        //2.Write a program that declares two double variables, assigns a number
        // to each, and adds them together. Assign the sum to a variable. Print
        // out the result.

        double question2Double1;
        double question2Double2;
        question2Double1 = 3.3;
        question2Double2 = 20.2;
        double question2Sum = question2Double1 + question2Double2;
        System.out.println("#2: "+ question2Sum);

        //3.Write a program that declares an integer variable and a double variable,
        // assigns numbers to each, and adds them together. Assign the sum to a
        // variable. Print out the result. What variable type must the sum be?

        int question3IntVariable;
        double question3DoubleVariable;
        question3IntVariable = 45;
        question3DoubleVariable = 66.6;
        System.out.println("#3: the variable type must be type double: "+ question3IntVariable + question3DoubleVariable);

        //4.Write a program that declares two integer variables, assigns an integer
        // to each, and divides the larger number by the smaller number. Assign
        // the result to a variable. Print out the result. Now change the larger
        // number to a decimal. What happens? What corrections are needed?

        double question4DoubleVariable;
        int question4intVariable4b;
        question4DoubleVariable = 100.0;
        question4intVariable4b = 22;
        double question4Result = question4DoubleVariable/question4intVariable4b;
        System.out.println(question4Result);//needed to change the result variable to type double


        //5.Write a program that declares two double variables, assigns a number
        // to each, and divides the larger by the smaller number. Assign the
        // result to a variable. Print out the result. Now, cast the result to
        // an integer. Print out the result again.

        double question5Variable1;
        double question5Variable2;
        question5Variable1 = 33.3;
        question5Variable2 = 77.77;
        double question5result1 = question5Variable2/question5Variable1;
        System.out.println(question5result1);

        int castedResult = (int)question5result1;
        System.out.println("castedResult :"+castedResult);

        //6.Write a program that declares two integer variables, x and y, and assigns
        // the number 5 to x and the number 6 to y. Declare a variable q and assign
        // y/x to it and print q. Now, cast y to a double and assign it to q. Print
        // q again.
        int x;
        int y;

        x = 5;
        y = 6;

        double q = y/x;
        System.out.println(q);
        q = (double)y;
        System.out.println(q);

        //7.Write a program that declares a named constant and uses it in a calculation.
        // Print the result.
        double radius = 45;
        double area = radius* radius * 3.14;
        System.out.println(area);


        //8.Write a program where you create three variables that represent products at
        // a cafe. The products could be beverages like coffee, cappuccino, espresso,
        // green tea, etc. Assign prices to each product. Create two more variables
        // called subtotal and totalSale and complete an “order” for three items of
        // the first product, four items of the second product, and two items of the
        // third product. Add them all together to calculate the subtotal. Create a
        // constant called SALES_TAX and add sales tax to the subtotal to obtain the
        // totalSale amount. Be sure to format the results to two decimal places.

        double coffeePrice = 3.50;
        double cappuccinoPrice = 4.75;
        double greenTeaPrice = 2.80;
        double subtotal;
        double totalSale;

        int coffeeQty = 3;
        int cappuccinoQty = 4;
        int greenTeaQty = 2;

        double saleTax  = 0.07;

        subtotal = (coffeeQty * coffeePrice) + (cappuccinoQty * cappuccinoPrice) + (greenTeaQty * greenTeaPrice);
        totalSale = subtotal + (subtotal * saleTax);
        System.out.println("Subtotal :" + subtotal);
        System.out.println("Total Sale :" + totalSale);




    }
}

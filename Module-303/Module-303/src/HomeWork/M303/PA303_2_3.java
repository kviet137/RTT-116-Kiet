package HomeWork.M303;

public class PA303_2_3 {
    public static void main (String [] args) {
        //1.Write a program that declares an integer a variable x, assigns the value 2
        // to it, and prints out the binary string version of the
        // number(Integer.toBinaryString(x)).Now, use the left shift operator ( <<)to
        // shift by 1 and assign the result to x.Before printing the results,
        // write a comment with the predicted decimal value and binary string.
        // Now, print out x in decimal form and in binary notation. Perform the
        // preceding exercise with the following values:
        //9
        //17
        //88

        int x = 2;
        System.out.println("initial value of x: " + x);
        System.out.println("binary : " + Integer.toBinaryString(x));

        x = x << 1;

        System.out.println("after left shift by 1:");
        System.out.println("decimal: " + x);
        System.out.println("binary: " + Integer.toBinaryString(x));

        System.out.println();

        // Value is 9
        x = 9;
        System.out.println("initial value of x: " + x);
        System.out.println("binary : " + Integer.toBinaryString(x));


        x = x << 1;

        System.out.println("after left shift by 1:");
        System.out.println("decimal: " + x);
        System.out.println("binary: " + Integer.toBinaryString(x));

        System.out.println();

        // Value is 17
        x = 17;
        System.out.println("initial value of x: " + x);
        System.out.println("binary : " + Integer.toBinaryString(x));


        x = x << 1;

        System.out.println("after left shift by 1:");
        System.out.println("decimal: " + x);
        System.out.println("binary: " + Integer.toBinaryString(x));

        System.out.println();

        // Value is 88
        x = 88;
        System.out.println("initial value of x: " + x);
        System.out.println("binary : " + Integer.toBinaryString(x));


        x = x << 1;

        System.out.println("after left shift by 1:");
        System.out.println("decimal: " + x);
        System.out.println("binary: " + Integer.toBinaryString(x));

        //2.Write a program that declares a variable x, and assigns 150 to it, and
        // prints out the binary string version of the number.Now use the right shift
        // operator ( >>)to shift by 2 and assign the result to x.Write a comment
        // indicating what you anticipate the decimal and binary values to be.Now
        // print the value of x and the binary string. Perform the preceding exercise
        // with the following values:
        //225
        //1555
        //32456

        // Value is 150
        int x2 = 150;
        System.out.println("initial value of x: " + x2);
        System.out.println("binary : " + Integer.toBinaryString(x2));


        x2 = x2 >> 2;

        System.out.println("after right shift by 2:");
        System.out.println("decimal: " + x2);
        System.out.println("binary: " + Integer.toBinaryString(x2));

        System.out.println();

        // value is 225
        x2 = 225;
        System.out.println("initial value of x: " + x2);
        System.out.println("binary : " + Integer.toBinaryString(x2));


        x2 = x2 >> 2;

        System.out.println("after right shift by 2:");
        System.out.println("decimal: " + x2);
        System.out.println("binary: " + Integer.toBinaryString(x2));

        System.out.println();

        //value is 1555
        x2 = 1555;
        System.out.println("initial value of x: " + x2);
        System.out.println("binary : " + Integer.toBinaryString(x2));

        x2 = x2 >> 2;

        System.out.println("after right shift by 2:");
        System.out.println("decimal: " + x2);
        System.out.println("binary: " + Integer.toBinaryString(x2));

        System.out.println();

        // value is 32456
        x2 = 32456;
        System.out.println("initial value of x: " + x2);
        System.out.println("binary : " + Integer.toBinaryString(x2));


        x2 = x2 >> 2;
        // Predicted value: 8114 (Binary: 1111110110010)
        System.out.println("after right shift by 2:");
        System.out.println("decimal: " + x2);
        System.out.println("binary: " + Integer.toBinaryString(x2));


        //3.Write a program that declares three int variables:x, y, and z.Assign 7
        // to x and 17 to y.Write a comment that indicates what you predict will
        // be the result of the bitwise and operation on x and y.Now use the bitwise
        // AND( &) operator to derive the decimal and binary values, and assign the
        // result to z.

        int x3 = 7;
        int y3 = 17;
        int z3;

        z3 = x3 & y3;


        System.out.println("x in decimal: " + x3 + " and binary: " + Integer.toBinaryString(x3));
        System.out.println("y in decimal: " + y3 + " and binary: " + Integer.toBinaryString(y3));
        System.out.println("z (x & y) in decimal: " + z3 + " and binary: " + Integer.toBinaryString(z3));

        //4.Now, with the preceding values, use the bitwise and operator to calculate
        // the “or”value between x and y.As before, write a comment that indicates
        // what you predict the values to be before printing them out.

        z3 = x3 | y3;
        System.out.println("x in decimal: " + x3 + " and binary: " + Integer.toBinaryString(x3));
        System.out.println("y in decimal: " + y3 + " and binary: " + Integer.toBinaryString(y3));
        System.out.println("z (x | y) in decimal: " + z3 + " and binary: " + Integer.toBinaryString(z3));


        //5.Write a program that declares an integer variable, assigns a number, and
        //uses a postfix increment operator to increase the value.Print the value
        // before and after the increment operator.

        int number5 = 10;
        System.out.println(number5);

        number5++;
        System.out.println(number5);


        //6.Write a program that demonstrates at least three ways to increment a
        // variable by 1 and does this multiple times.Assign a value to an integer
        // variable, print it, increment by 1, print it again, increment by 1, and
        // then print it again.

        int number6 = 5;
        System.out.println(number6);

        number6++;
        System.out.println(number6);

        ++number6;
        System.out.println(number6);

        number6 += 1;
        System.out.println(number6);


        //7.Write a program that declares two integer variables:x, and y, and then
        // assigns 5 to x and 8 to y.Create another variable sum and assign the value
        // of++ x added to y, and print the result.Notice the value of the sum (should
        // be 14).Now change the increment operator to postfix(x++) and re -run the
        // program.Notice what the value of the sum is.The first configuration
        // incremented x, and then calculated the sum, while the second
        // configuration calculated the sum, and then incremented x.

        int x7 = 5;
        int y7 = 8;
        int sum7 = ++x7 + y7;

        System.out.println("Using prefix increment (++x):");
        System.out.println(x7);
        System.out.println(y7);
        System.out.println(sum7);

        x7 = 5;
        sum7 = x7++ + y7;

        System.out.println("\nUsing postfix increment (x7++):");
        System.out.println(x7);
        System.out.println(y7);
        System.out.println(sum7);
    }
}

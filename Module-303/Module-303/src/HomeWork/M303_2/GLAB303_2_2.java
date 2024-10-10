package HomeWork.M303_2;

public class GLAB303_2_2 {
    public static void main(String[] args) {
        //AutoTypeConversion
        int x = 20;
        double y = 40.5;
        long p = 30;
        float q = 10.60f;
        // int z = x + y; (1) // Error; cannot convert from double to int.
        double z = x + y;
        System.out.println("Sum of two numbers: " + z);

        // long r = p - q; // (2) // Error; cannot convert from float to long.
        float r = p - q;
        System.out.println("Subtraction of two numbers: " + r);

        //AutoPromoteTest
        byte b = 42;
        char c = 'a';
        short s = 1024;
        int i = 50000;
        float f = 5.67f;
        double d = .1234;
        // Expression:
        double result = (f * b) + (i / c) - (d * s);
        //Result after all the promotions are done.
        System.out.println("result = " + result);

        //ExplicitTest
        double d1 = 100.04;
        // explicit type casting
        long l1 = (long) d1;
        int i1 = (int) l1;
        System.out.println("Double value " + d1);
        System.out.println("Long value " + l1);
        System.out.println("Int value " + i1);

        byte b1;
        int z1 = 257;
        double dou = 323.142;
        System.out.println("Conversion of int to byte.");
        b1 = (byte) z1;
        System.out.println("z = " + z1 + " b = " + b1);
        System.out.println("Conversion of double to int.");

        z1 = (int) dou;
        System.out.println("dou = " + dou + " b = " + z1);
        System.out.println("Conversion of double to byte.");

        b1 = (byte) dou;
        System.out.println("dou = " + dou + " b = " + b1);


    }
}

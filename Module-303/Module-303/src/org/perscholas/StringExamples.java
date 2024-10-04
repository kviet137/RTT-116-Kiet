package org.perscholas;

import java.text.DecimalFormat;
import java.util.StringJoiner;

public class StringExamples {
    public static void main(String[] args) {
        String s = "abc123def";

        System.out.println(s.charAt(0));
        System.out.println(s.charAt(5));
        //System.out.println(s.charAt(6)); //will throw exception

        System.out.println(s.replace("c", "f"));
        System.out.println(s.replaceAll("\\d", "56"));

        String filename = "someimage.jpg";
        System.out.println(filename.substring(0, filename.lastIndexOf(".")));

        String s1 = "abc";
        String s2 = "abc";
        String s3 = new String("abc");
        String s4 = "ABC";
        String s5 = new String("ABC");
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1.equalsIgnoreCase(s4));
        System.out.println(s1.equalsIgnoreCase(s5));

        // =================== String Buffer ===================

        StringBuffer sb = new StringBuffer();

        sb.append("abc");
        sb.append("123");

        sb.insert(1,"K");

        sb.replace(3,4,"Zxy");

        System.out.println(sb);

        StringBuffer kba = new StringBuffer("ABC");
        kba.replace(0,7,"DEFG").insert(0,"123456");
        kba.reverse().delete(0,5);


        //================= String ==================
        StringJoiner sj1 = new StringJoiner("&","{","}");
        StringJoiner sj2 = new StringJoiner(":","[","]");

        sj1.add("eric");
        sj1.add("jess");

        System.out.println(sj1);

        sj2.add("jeff");
        sj2.add("kiet");

        System.out.println(sj2);


        //====================formatting================================
        int i = 1024;
        byte b = 127;
        double d = 1.232, tiny = d / 1000000.0;
        boolean bool = true;
        System.out.format(" This is an integer: %d and this is a byte: %d.\r\n", i, b);
        System.out.format(" This is a double: %.4f and this is tiny: %.4e.\r\n", d, tiny);
        System.out.format(" And this is a String: %s", "This is a string.\r\n");


        //========================Decimal Formatting=====================

        String pattern = "&~##,###,#####,###.##";
        double number = 123456789012345.12345;

        DecimalFormat numberFormat = new DecimalFormat(pattern);
        System.out.println(numberFormat.format(number));
    }
}

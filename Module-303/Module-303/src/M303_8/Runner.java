package M303_8;

public class Runner {
    public static void main(String[] args) {
        Square s1 = new Square();
        Square s2 = new Square('t', 'h');
        System.out.println(s1);
        System.out.println(s2);

        //s1.privateAvailable(); this is an error because the function is set to private
        s1.publicAvailable();
        s1.partlyAvailable();


    }
}

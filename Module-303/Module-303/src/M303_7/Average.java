package M303_7;

public class Average {
    public static void main(String[] args){
        double[] values = {1.2,6.5,3.2};
        double oldSum = 0;
        double newSum = 0;

        //old style for loop
        for (int position = 0; position < values.length; position++){
            oldSum = oldSum + values[position];

        }
        System.out.println("old: " + oldSum);

        //new style for loop
        for (double v : values) { //for each v in values
            newSum = newSum + v;
        }
        System.out.println("new: "+newSum);
    }
}

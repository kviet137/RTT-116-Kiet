package M303_5;

public class DynamicArray {
    public static double[] insert(double[] array, int position, double value){

        double[] result = new double[array.length + 1];

        for (int pos = 0; pos <position; pos++){
            result[pos] = array[pos];
        }
        result[position] = value;

        for (int pos = position; pos <array.length; pos++){
            result[pos + 1] = array[pos];

        }
    return  result;
    }

    public static void main(String[] args){
        double [] numbers = {1,2,3,4,5,6,7,8,9,10};
        numbers = insert(numbers, 3, 3.5);

    }
}

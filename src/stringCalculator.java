
import java.util.HashMap;
import java.util.Map;

public class stringCalculator {


    public stringCalculator(){}


    /**
     /**
     * Parse string and add numbers found, if possible
     * numbers must be positive, negative numbers throw exception
     * @param numbers: string of numbers separated by a comma
     * @return : int value (the value of the numbers added together)
     */
    public static int add(String numbers) {
//        if (numbers.equals("")) {
//            return 0;
//        }
        return -1;
    }

    /**
     * Testing for add() function
     * Prints to console
     */
    public static void testing() {

        int result;
        int numErrors = 0;
        HashMap<Integer, String[]> inputs = new HashMap<>();
        inputs.put(0, new String[]{"", "Empty String"});


        for (Map.Entry<Integer, String[]> entry : inputs.entrySet()){
            result = add(entry.getValue()[0]);
            if (result != (int)entry.getKey()) {
                numErrors ++;
                System.out.println("Error " + numErrors +
                        "\ninput: " + entry.getValue()[0] +
                        "\nExpected Output: " + entry.getKey() +
                        "\nActual Output: " + result +
                        "\nReason for test: " + entry.getValue()[1]);
            }
        }

        System.out.println("\n\nTesting Complete\nNumber of errors: " + numErrors);
    }

    public static void main(String[] args) {

        testing();
    }

}

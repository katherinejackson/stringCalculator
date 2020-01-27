
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
        String[] stringArray;
        int total = 0;
        if (numbers.equals("")) {
            return 0;
        }
        try {
            stringArray = numbers.split(",");
            for (String entry: stringArray) {
                total += Integer.parseInt(entry.strip());
            }
        }
        catch (Exception e){
            System.out.println("Exception thrown: " + e.toString());
        }
        return total;
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
        inputs.put(1, new String[]{"1", "Single number in string"});
        inputs.put(8, new String[]{"1,2,5", "Basic 3 item string"});
        inputs.put(6, new String[]{"  1,\t 2, \n  3  ", "white space including tab and newline characters"});

        for (Map.Entry<Integer, String[]> entry : inputs.entrySet()){
            result = add(entry.getValue()[0]);
            if (result != (int)entry.getKey()) {
                numErrors ++;
                System.out.println("Error " + numErrors +
                        "\ninput: " + entry.getValue()[0] +
                        "\nExpected Output: " + entry.getKey() +
                        "\nActual Output: " + result +
                        "\nReason for test: " + entry.getValue()[1] + "\n\n");
            }
        }

        System.out.println("***** Testing Complete *****\nNumber of errors: " + numErrors);
    }

    public static void main(String[] args) {
        testing();
    }

}

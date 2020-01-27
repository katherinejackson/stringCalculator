
import java.util.HashMap;
import java.util.Map;

public class stringCalculator {


    public stringCalculator(){}


    /**
     /**
     * Parse string and add numbers found, if possible
     * numbers must be positive, negative numbers throw exception
     * @param numbers: String of numbers separated by ","
     *               OR
     *               string of numbers separated deliminator specified at the beginning of the string
     *               format: “//[delimiter]\n[delimiter separated numbers]”
     * @return : int value (the value of the numbers added together)
     */
    public static int add(String numbers) {
        String[] stringArray;
        int total = 0;
        if (numbers.equals("")) {
            return 0;
        }

        if (numbers.startsWith("//")) {
            return customAdd(numbers);
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

    private static int customAdd(String numbers) {
        String[] stringArray;
        int total = 0;

        int index = numbers.indexOf("\n");
//        System.out.println(index);
        CharSequence delim = numbers.subSequence(2, index);
//        System.out.println(delim);

        try {
            stringArray = numbers.split((String) delim);
            for (int i = 1; i < stringArray.length; i++) {
                total += Integer.parseInt(stringArray[i].strip());
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

        //testing for Q1, Q2
        inputs.put(0, new String[]{"", "Empty String"});
        inputs.put(1, new String[]{"1", "Single number in string"});
        inputs.put(8, new String[]{"1,2,5", "Basic 3 item string"});
        inputs.put(6, new String[]{"  1,\t 2, \n  3  ", "white space including tab and newline characters"});

        // testing for Q3
        inputs.put(2, new String[]{"//&\n1&1", "two numbers separated by single &"});
        inputs.put(13, new String[]{"//@\n2@3@8", "three numbers separated by @"});
        inputs.put(3, new String[]{"//&&\n1&&2", "separated by double &&"});



        for (Map.Entry<Integer, String[]> entry : inputs.entrySet()){
            result = add(entry.getValue()[0]);
            if (result != entry.getKey()) {
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

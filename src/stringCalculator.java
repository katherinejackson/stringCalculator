// Katherine Jackson

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class stringCalculator {

    /**
     /**
     * Parse string and add numbers found, if possible
     * numbers must be positive, negative numbers throw exception
     * @param numbers: String of numbers separated by ","
     *               OR
     *               string of numbers separated deliminator specified at the beginning of the string
     *               format: “//[delimiter]\n[delimiter separated numbers]”
     * @return : int value (the value of the numbers added together)
     * @throws Exception : throws exception if negative number found
     */
    public static int add(String numbers) throws Exception{
        String[] stringArray;
        int total = 0;

        if (numbers.equals("")) {
            return 0;
        }

        // determine where to split, and make into string array
        if (numbers.startsWith("//")) {
            stringArray = customAdd(numbers);
        }
        else {
            stringArray = numbers.split(",");
        }

        // parse ints and add to total
        try {
            for (String entry: stringArray) {
                if (Integer.parseInt(entry.strip()) < 0) {
                    throw new Exception("Negative numbers are not allowed.  " +
                            "Negative number found: " + Integer.parseInt(entry.strip()));
                }
                total += Integer.parseInt(entry.strip());
            }
        }
        catch (NumberFormatException e){
            System.out.println(e.toString());
        }
        return total;
    }

    /**
     * Helper function; parse string with custom deliminators
     * @param numbers : String; format: “//[delimiter]\n[delimiter separated numbers]”
     * @return : String array of numbers found
     */
    private static String[] customAdd(String numbers){
        String[] stringArray;

        int index = numbers.indexOf("\n");
        CharSequence delim = numbers.subSequence(2, index);

        stringArray = numbers.split((String) delim);
        return Arrays.copyOfRange(stringArray, 1, stringArray.length);

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

        // testing for Q4
        inputs.put(-1, new String[]{"-1, -1", "two neg numbers separated by default delim"});
        inputs.put(-2, new String[]{"//@\n-2@3@8", "one neg number, one positive number, separated by custom delim"});


        for (Map.Entry<Integer, String[]> entry : inputs.entrySet()){
            try {
                result = add(entry.getValue()[0]);
                if (result != entry.getKey()) {
                    numErrors++;
                    System.out.println("Error " + numErrors +
                            "\ninput: " + entry.getValue()[0] +
                            "\nExpected Output: " + entry.getKey() +
                            "\nActual Output: " + result +
                            "\nReason for test: " + entry.getValue()[1] + "\n\n");
                }
            }
            catch (Exception e){
                System.out.println(e.toString());
            }
        }

        System.out.println("***** Testing Complete *****\nNumber of errors: " + numErrors);
    }

    public static void main(String[] args) {
        testing();
    }

}

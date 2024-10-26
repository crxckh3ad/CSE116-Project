package ratings;

import java.util.ArrayList;
import java.util.HashMap;

public class ProblemSet {

    // TODO: Implement this method to return the average of all the numbers in the input ArrayList
    //       If the ArrayList is empty, return 0.0
    //
    // Examples
    // [1.0,2.0,3.0] returns 2.0
    // [-5.0,5.0] returns 0.0
    // [6.5,6.5,8.5,8.5] returns 7.5
    // [] returns 0.0

    public static double average(ArrayList<Double> numbers) {
        double total = 0;
        double avg = 0.0;
        if (numbers.isEmpty()==false) {
            for (int x = 0; x < numbers.size(); x++) {
                total += numbers.get(x);
            }
            avg = total / numbers.size();
        }
        return avg;
    }

    // TODO: Write a public static method named sumOfDigits that takes an int as a parameter and
    //       returns the sum of the digits of the input as an int
    //
    // Examples
    // 123 returns 6
    // 57 returns 12
    // -36 returns 9

    public static int sumOfDigits(int value){
        value= Math.abs(value);
        int total= 0;
        while (value> 0){
            total += value % 10;
            value /= 10;
        }
        return total;
    }
    // TODO: Write a public static method named bestKey that takes a HashMap of String to Integer
    //       as a parameter and returns a key mapping to the largest Integer. Ties can be broken arbitrarily.
    //       If the HashMap is empty, return the empty String
    //
    // Examples
    // {"CSE": 100, "MTH": 90, "MGT": 10} returns "CSE"
    // {"cat": 5, "dog": 5, "fox": 4} can return either "cat" or "dog"
    // {} returns ""
    public static String bestKey(HashMap<String,Integer> hashMap){

        int highest=-999;
        String out ="";
        if (hashMap.isEmpty()==false) {
            for (String key : hashMap.keySet()) {
                int value = hashMap.get(key);
                if (value > highest) {
                    highest = value;
                    out = key;
                }
            }

        }
        return (out);
    }
}







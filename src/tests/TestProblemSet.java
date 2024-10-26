package tests;

import org.junit.Test;
import ratings.ProblemSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class TestProblemSet {
    @Test
    public void testAverage() {
        ArrayList<Double> arr1 = new ArrayList<>();
        arr1.add(1.0);
        arr1.add(2.0);
        arr1.add(3.0);
        double result1 =ProblemSet.average(arr1);
        assertEquals(2.0,result1,0.001);

        ArrayList<Double> arr2 = new ArrayList<>();
        arr2.add(-5.0);
        arr2.add(5.0);
        arr2.add(0.0);
        arr2.add(0.0);
        double result2 =ProblemSet.average(arr2);
        assertEquals(0.0,result2,0.001);

        ArrayList<Double> arr3 = new ArrayList<>();
        arr3.add(6.5);
        arr3.add(6.5);
        arr3.add(8.5);
        arr3.add(8.5);
        double result3 =ProblemSet.average(arr3);
        assertEquals(7.5,result3,0.001);

        ArrayList<Double> arr4 = new ArrayList<>();
        double result4 =ProblemSet.average(arr4);
        assertEquals(0.0,result4,0.001);

        ArrayList<Double> arr5 = new ArrayList<>();
        arr5.add(-5.0);
        arr5.add(-5.0);
        arr5.add(-5.0);
        arr5.add(-5.0);
        double result5 =ProblemSet.average(arr5);
        assertEquals(-5.0,result5,0.001);

        ArrayList<Double> arr6 = new ArrayList<>();
        arr6.add(5.0);
        double result6 =ProblemSet.average(arr6);
        assertEquals(5.0,result6,0.001);
    }
    @Test
    public void testSumOfDigits() {
        int result1=ProblemSet.sumOfDigits(123);
        assertEquals(6,result1 );
        int result2 = ProblemSet.sumOfDigits(57);
        assertEquals(12,result2);
        int result3 = ProblemSet.sumOfDigits(999);
        assertEquals(27,result3);
        int result4 = ProblemSet.sumOfDigits(-36);
        assertEquals(9,result4);
    }
    @Test
    public void TestbestKey(){
        HashMap<String,Integer> hash1=new HashMap<>();
        hash1.put("CSE", 100);
        hash1.put("MTH", 90);
        hash1.put("MGT", 10);
        String result= ProblemSet.bestKey(hash1);
        assertEquals(result,"CSE");

        HashMap<String,Integer> hash2=new HashMap<>();
        hash2.put("cat", 5);
        hash2.put("dog", 5);
        hash2.put("fox", 4);
        String result2= ProblemSet.bestKey(hash2);
        assertTrue(result2.equals("cat") || result2.equals("dog"));

        HashMap<String,Integer> hash3=new HashMap<>();
        String result3= ProblemSet.bestKey(hash3);
        assertEquals(result3,"");

        HashMap<String,Integer> hash4=new HashMap<>();
        hash4.put("cat", -5);
        hash4.put("dog", -5);
        hash4.put("fox", -4);
        String result4= ProblemSet.bestKey(hash4);
        assertEquals(result4,"fox");
    }


}
    // TODO: Write testing for all 3 methods of the ratings.ProblemSet class
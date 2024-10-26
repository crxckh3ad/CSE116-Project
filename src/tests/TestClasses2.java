package tests;

import org.junit.Test;
import ratings.Movie;
import ratings.Rating;
import ratings.Song;
import ratings.datastructures.Comparator;
import ratings.datastructures.LinkedListNode;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestClasses2 {
    public boolean compareArrayListsIgnoreCase(ArrayList<String> arr1,ArrayList<String> arr2){
        boolean check = true;
        if (arr1.size()==arr2.size()){
            for(int x=0; x<arr1.size(); x++){
                int i =arr1.get(x).compareToIgnoreCase(arr2.get(x));
                if (i!=0){
                    check=false;
                }
            }
        }else{
            check=false;
        }
        return check;
    }
    @Test
    public void testGetCastMovie(){
        ArrayList<String> st= new ArrayList<>();
        st.add("Tim");
        st.add("zen");
        Movie starwars = new Movie("Star wars",st);
        ArrayList<String> expected = new ArrayList<>();
        expected.add("tim");
        expected.add("zen");
        assertTrue(compareArrayListsIgnoreCase(starwars.getCast(),expected));

        ArrayList<String> st2= new ArrayList<>();
        st2.add("Tim");
        st2.add("zen hook");
        Movie starwars2 = new Movie("Star wars",st2);
        ArrayList<String> expected2 = new ArrayList<>();
        expected2.add("tim");
        expected2.add("zen hook");
        assertTrue(compareArrayListsIgnoreCase(starwars2.getCast(),expected2));
    }
    @Test
    public void TestbayesianAverageRating(){
        Rating r1 = new Rating("r1", 4);
        Rating r2 = new Rating("r2", 5);
        Rating r3 = new Rating("r3", 3);

        Song s1 = new Song("500lb","tecca","1");
        s1.addRating(r1);
        s1.addRating(r2);
        s1.addRating(r3);
        assertEquals(4.0, s1.bayesianAverageRating(2,4), 0.01);

        ArrayList<String> dune= new ArrayList<>();
        dune.add("Tim");
        dune.add("zen");
        Movie m1 = new Movie("dune",dune);
        m1.addRating(r1);
        m1.addRating(r2);
        m1.addRating(r3);
        assertEquals(4.0,  m1.bayesianAverageRating(2,4), 0.01);


        Rating r4 = new Rating("r4", -1);
        Rating r5 = new Rating("r5", 5);
        Rating r6 = new Rating("r6", -1);

        Song s2 = new Song("wasted", "juice", "999");
        s2.addRating(r4);
        s2.addRating(r5);
        s2.addRating(r6);

        Movie m2 = new Movie("dune",dune);
        m2.addRating(r4);
        m2.addRating(r5);
        m2.addRating(r6);

        assertEquals(3.0, s2.bayesianAverageRating(2,2), 0.01);
        assertEquals(3.0, m2.bayesianAverageRating(2,2), 0.01);

        assertEquals(5.0, s2.bayesianAverageRating(0,2), 0.01);
        assertEquals(5.0, m2.bayesianAverageRating(0,2), 0.01);
        assertEquals(0.0, s2.bayesianAverageRating(-1,2), 0.01);
        assertEquals(0.0, m2.bayesianAverageRating(-1,2), 0.01);

        Song s3 = new Song("500lb","tecca","2");
        Movie m3 = new Movie("dune",dune);
        assertEquals(0.0,s3.bayesianAverageRating(0,2),0.01);
        assertEquals(0.0,s3.bayesianAverageRating(0,2),0.01);
        assertEquals(2.0,s3.bayesianAverageRating(2,2),0.01);
        assertEquals(2.0,s3.bayesianAverageRating(2,2),0.01);



        assertEquals(0.0, s1.bayesianAverageRating(2,-4), 0.01);
        assertEquals(0.0, m1.bayesianAverageRating(2,-4), 0.01);

    }

}

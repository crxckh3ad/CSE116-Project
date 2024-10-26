package tests;

import ratings.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;
import ratings.datastructures.Comparator;
import ratings.datastructures.LinkedListNode;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestClasses3 {
    public boolean compareRatableArrayLists(ArrayList<Ratable> r1,ArrayList<Ratable> r2){
        if (r1.size()!=r2.size()){
            return false;
        }
        for(int x=0;x<r1.size();x++){
            String t1=r1.get(x).getTitle();
            String t2=r2.get(x).getTitle();
            assertEquals(t1,t2);
        }
        return true;
    }
    @Test
    public void test1() {
        ArrayList<Ratable> exp=new ArrayList<>();
        MediaLibrary m=new MediaLibrary();
        m.populateLibrary("data/songs_test_1.csv","data/movies_test_1.csv","data/movie_ratings_test_1.csv");
        ArrayList<Ratable> act=m.topKRatables(3);
        /*

        Movie m1=new Movie("Jumanji",new ArrayList<>(Arrays.asList("Rock","Jack","Peter")));
        //m1.addRating(new Rating("66",4));
        Movie m2=new Movie("Home Alone",new ArrayList<>(Arrays.asList("Donald","Park","Tree")));
         */
        Song s2 =new Song("Endless Fashion","Lil Uzi Vert","B");
        s2.addRating(new Rating("117",5));
        s2.addRating(new Rating("248",5));
        s2.addRating(new Rating("333",2));
        exp.add(s2);
        Movie m3=new Movie("Nemo",new ArrayList<>(Arrays.asList("Nemo","Dory","Shark")));
        exp.add(m3);
        Song s1=new Song("Flashing Lights","Kanye West","A");
        s1.addRating(new Rating("66",4));
        exp.add(s1);
        /*
        Song s3 =new Song("MELTDOWN","Travis Scott","C");
        s3.addRating(new Rating("41",4));
        Song s4 =new Song("FPS","Drake","D");
        s4.addRating(new Rating("21",2));
        Song s5 =new Song("IDGAF","Yeat","E");
        s5.addRating(new Rating("10",1));
         */
        assertTrue(compareRatableArrayLists(exp,act));
    }

    @Test
    public void test2() {
        ArrayList<Ratable> exp=new ArrayList<>();
        MediaLibrary m=new MediaLibrary();
        m.populateLibrary("data/songs_test_1.csv","data/movies_test_1.csv","data/movie_ratings_test_1.csv");
        ArrayList<Ratable> act=m.topKRatables(10);


        Song s2 =new Song("Endless Fashion","Lil Uzi Vert","B");
        s2.addRating(new Rating("117",5));
        s2.addRating(new Rating("248",5));
        s2.addRating(new Rating("333",2));
        exp.add(s2);
        Movie m3=new Movie("Nemo",new ArrayList<>(Arrays.asList("Nemo","Dory","Shark")));
        exp.add(m3);
        Song s1=new Song("Flashing Lights","Kanye West","A");
        s1.addRating(new Rating("66",4));
        exp.add(s1);
        Song s3 =new Song("MELTDOWN","Travis Scott","C");
        s3.addRating(new Rating("41",4));
        exp.add(s3);
        Movie m2=new Movie("Home Alone",new ArrayList<>(Arrays.asList("Donald","Park","Tree")));
        exp.add(m2);
        Song s4 =new Song("FPS","Drake","D");
        s4.addRating(new Rating("21",2));
        exp.add(s4);
        Movie m1=new Movie("Jumanji",new ArrayList<>(Arrays.asList("Rock","Jack","Peter")));
        //m1.addRating(new Rating("66",4));
        exp.add(m1);
        Song s5 =new Song("IDGAF","Yeat","E");
        s5.addRating(new Rating("10",1));
        exp.add(s5);
        assertTrue(compareRatableArrayLists(exp,act));
    }
}

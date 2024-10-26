package tests;

import org.junit.Test;
import ratings.DegreesOfSeparation;
import ratings.Movie;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class TestDataStructures3 {
    @Test
    public void test1() {
        Movie m1=new Movie("1",new ArrayList<>(Arrays.asList("Radin","Paul","Him")));
        Movie m2=new Movie("2",new ArrayList<>(Arrays.asList("Paul","Po","Shrek")));
        Movie m3=new Movie("3",new ArrayList<>(Arrays.asList("Shrek","Rock","Pikachu")));
        Movie m4=new Movie("4",new ArrayList<>(Arrays.asList("Fred","Charizard","Mew")));
        ArrayList<Movie> movies= new ArrayList<>(Arrays.asList(m1,m2,m3,m4));

        DegreesOfSeparation x= new DegreesOfSeparation(movies);

        assertEquals(0,x.degreesOfSeparation("Radin","Radin"));
        assertEquals(1,x.degreesOfSeparation("Radin","Paul"));
        assertEquals(2,x.degreesOfSeparation("Radin","Po"));
        assertEquals(3,x.degreesOfSeparation("Radin","Pikachu"));
        assertEquals(-1,x.degreesOfSeparation("Radin","Mew"));
        assertEquals(-1,x.degreesOfSeparation("Radin","Fred"));
        assertEquals(2,x.degreesOfSeparation("Po","Pikachu"));
    }
}

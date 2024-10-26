package tests;

import org.junit.Test;

import ratings.Rating;
import ratings.Reviewer;
import ratings.Song;

import static org.junit.Assert.*;

public class TestClasses1 {
//use assertTrue for test cases

    public boolean compareSongs(Song song1,Song song2) {

        assertEquals(song1.getTitle(),song2.getTitle());
        assertEquals(song1.getArtist(),song2.getArtist());
        assertEquals(song1.getSongID(),song2.getSongID());
        return true;
    }

    public boolean compareRatings(Rating rating1,Rating rating2) {

        assertEquals(rating1.getRating(),rating2.getRating());
        assertEquals(rating1.getReviewerID(),rating2.getReviewerID());
        return true;
    }

    public boolean compareReviewers(Reviewer r1,Reviewer r2) {

        assertEquals(r1.getReviewerID(),r2.getReviewerID());
        return true;
    }
    @Test
    public void testCompareSongs(){
        Song song1=new Song("Go","Laroi","1");
        Song song2=new Song("Go","Laroi","1");
        assertTrue(compareSongs(song1,song2));
        song1.setSongID("2");
        assertEquals("2",song1.getSongID());
        song1.setArtist("Post");
        assertEquals("Post",song1.getArtist());
        song1.setTitle("Dream");
        assertEquals("Dream",song1.getTitle());

    }
    @Test
    public void testRating(){
        Rating rating1 = new Rating("2A",4);
        Rating rating2 = new Rating("2A",4);
        assertTrue(compareRatings(rating1,rating2));
        Rating rating3 = new Rating("21",-2);
        rating3.setReviewerID("");
        assertEquals("",rating3.getReviewerID());
        rating3.setReviewerID("44");
        assertEquals("44",rating3.getReviewerID());
        rating1.setRating(3);
        assertEquals(3,rating1.getRating());
        rating2.setRating(8);
        assertEquals(-1,rating2.getRating());
        rating1.setRating(-3);
        assertEquals(-1,rating1.getRating());
        rating1.setRating(0);
        assertEquals(-1,rating1.getRating());
        rating1.setRating(5);
        assertEquals(5,rating1.getRating());

    }
    @Test
    public void testReviewer(){
        Reviewer r1=new Reviewer("12e");
        Reviewer r2=new Reviewer("12e");
        assertTrue(compareReviewers(r1,r2));
        r1.setReviewerID("3a");
        assertEquals("3a",r1.getReviewerID());
        int x=r1.rateSong(5).getRating();
        assertEquals(5,x);
        x=r1.rateSong(1).getRating();
        assertEquals(1,x);
        x=r1.rateSong(0).getRating();
        assertEquals(-1,x);
        x=r1.rateSong(6).getRating();
        assertEquals(-1,x);
        x=r1.rateSong(-3).getRating();
        assertEquals(-1,x);
        Rating y=r1.rateSong(3);
        assertEquals("3a",y.getReviewerID());



    }
}

package tests;

import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.ls.LSOutput;
import ratings.FileReader;
import ratings.Movie;
import ratings.Rating;
import ratings.Song;
import ratings.datastructures.LinkedListNode;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;
import static ratings.FileReader.readSongs;
import static tests.TestDataStructures1.compareListsOfRatings;


public class TestFiles {
    public static boolean compare(Movie m1, Movie m2) {
        if (!m1.getTitle().equals(m2.getTitle())) {
            return false;
        }
        ArrayList<String> c1 = m1.getCast();
        ArrayList<String> c2 = m2.getCast();
        if (c1.size() != c2.size()) {
            return false;
        }
        for (int x = 0; x < c1.size(); x++) {
            if (!c1.get(x).equals(c2.get(x))) {
                return false;
            }
        }
        LinkedListNode<Rating> allRatings1 = m1.getRatings();
        LinkedListNode<Rating> allRatings2 = m2.getRatings();
        while (allRatings1 != null && allRatings2 != null) {
            if (allRatings1.getValue().getRating() != allRatings2.getValue().getRating()) {
                return false;
            }
            allRatings1 = allRatings1.getNext();
            allRatings2 = allRatings2.getNext();
        }
        return allRatings1 == null && allRatings2 == null;
    }

    public static boolean compareMovieArrayLists(ArrayList<Movie> m1, ArrayList<Movie> m2) {
        if (m1.size() != m2.size()) {
            return false;
        }
        for (Movie first : m1) {
            boolean temp = false;
            for (Movie second : m2) {
                if (compare(first, second)) {
                    temp = true;
                }
            }
            if (!temp) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void song_test_0() {
        ArrayList<Song> actualSongs = FileReader.readSongs("data/songs_.csv");
        ArrayList<Song> expectedSongs = new ArrayList<>();
        assertEquals(expectedSongs, actualSongs);
    }

    @Test
    public void movie_test_0() {
        ArrayList<Movie> actualMovie = FileReader.readMovies("data/movie_.csv");
        ArrayList<Movie> expectedMovie = new ArrayList<>();
        assertEquals(expectedMovie, actualMovie);
    }
    @Test
    public void movie_ratings_test_0() {
        ArrayList<Movie> movie = FileReader.readMovies("data/movie_.csv");
        ArrayList<Movie> actualMovieRatings = FileReader.readMovieRatings(movie,"data/me.csv");
        ArrayList<Movie> expectedMovieRatings = new ArrayList<>();

        assertEquals(expectedMovieRatings, actualMovieRatings);
    }


    @Test
    public void song_test_1() {
        ArrayList<Song> songs = readSongs("data/songs_test_1.csv");
        //A,Kanye West,Flashing Lights,66,4
        //B,Lil Uzi Vert,Endless Fashion,117,5
        //B,Lil Uzi Vert,Endless Fashion,248,5
        //B,Lil Uzi Vert,Endless Fashion,333,2
        //C,Travis Scott,MELTDOWN,41,4
        //D,Drake,FPS,21,2
        //E,Yeat,IDGAF,10,1


        HashMap<String,Song> songMap =new HashMap<>();
        Song s1=new Song("Flashing Lights","Kanye West","A");
        songMap.put("Flashing Lights",s1);
        s1.addRating(new Rating("66",4));
        Song s2 =new Song("Endless Fashion","Lil Uzi Vert","B");
        songMap.put("Endless Fashion",s2);
        s2.addRating(new Rating("117",5));
        s2.addRating(new Rating("248",5));
        s2.addRating(new Rating("333",2));
        Song s3 =new Song("MELTDOWN","Travis Scott","C");
        songMap.put("MELTDOWN",s3);
        s3.addRating(new Rating("41",4));
        Song s4 =new Song("FPS","Drake","D");
        songMap.put("FPS",s4);
        s4.addRating(new Rating("21",2));
        Song s5 =new Song("IDGAF","Yeat","E");
        songMap.put("IDGAF",s5);
        s5.addRating(new Rating("10",1));
        assertEquals(5,songs.size());

        for (Song song: songs){
            String key = song.getTitle();
            if(songMap.containsKey(key)){
                Song expSong=songMap.get(key);
                assertEquals(expSong.getSongID(),song.getSongID());
                assertEquals(expSong.getTitle(),song.getTitle());
                assertEquals(expSong.getArtist(),song.getArtist());
                LinkedListNode<Rating> r1= expSong.getRatings();
                LinkedListNode<Rating> r2= song.getRatings();

                while (r1!=null && r2!=null) {
                    assertEquals(r1.getValue().getReviewerID(), r2.getValue().getReviewerID());
                    assertEquals(r1.getValue().getRating(),r2.getValue().getRating());
                    r1=r1.getNext();
                    r2=r2.getNext();
                }


                //compareListsOfRatings(r1,r2);
            }else{
                fail();
            }
        }

    }

    @Test
    public void song_test_3() {
        ArrayList<Song> songs = readSongs("data/songs_test_3.csv");
        //B,Lil Uzi Vert,Endless Fashion,117,5
        //B,Lil Uzi Vert,Endless Fashion,248,5
        //B,Lil Uzi Vert,Endless Fashion,333,2


        HashMap<String,Song> songMap =new HashMap<>();
        Song s2 =new Song("Endless Fashion","Lil Uzi Vert","B");
        songMap.put("Endless Fashion",s2);
        s2.addRating(new Rating("117",5));
        s2.addRating(new Rating("248",5));
        s2.addRating(new Rating("333",2));

        assertEquals(1,songs.size());

        for (Song song: songs){
            String key = song.getTitle();
            if(songMap.containsKey(key)){
                Song expSong=songMap.get(key);
                assertEquals(expSong.getSongID(),song.getSongID());
                assertEquals(expSong.getTitle(),song.getTitle());
                assertEquals(expSong.getArtist(),song.getArtist());
                LinkedListNode<Rating> r1= expSong.getRatings();
                LinkedListNode<Rating> r2= song.getRatings();
                int x=0;
                while (r1!=null && r2!=null) {
                    assertEquals(r1.getValue().getReviewerID(), r2.getValue().getReviewerID());
                    assertEquals(r1.getValue().getRating(),r2.getValue().getRating());
                    r1=r1.getNext();
                    r2=r2.getNext();
                    x++;
                }
                assertTrue(x==3);


                //compareListsOfRatings(r1,r2);
            }else{
                fail();
            }
        }

    }

    @Test
    public void song_test_2() {
        ArrayList<Song> songs = readSongs("data/songs_test_2.csv");
        //A,Kanye West,Flashing Lights,66,4
        //B,Lil Uzi Vert,Endless Fashion,117,5
        //B,Lil Uzi Vert,Endless Fashion,248,5
        //C,Travis Scott,MELTDOWN,41,4
        //D,Drake,FPS,21,2
        //E,Yeat,IDGAF,10,1
        //E,Yeat,IDGAF,33,5


        HashMap<String,Song> songMap =new HashMap<>();
        Song s1=new Song("Flashing Lights","Kanye West","A");
        songMap.put("Flashing Lights",s1);
        s1.addRating(new Rating("66",4));
        Song s2 =new Song("Endless Fashion","Lil Uzi Vert","B");
        songMap.put("Endless Fashion",s2);
        s2.addRating(new Rating("117",5));
        Song s3 =new Song("MELTDOWN","Travis Scott","C");
        songMap.put("MELTDOWN",s3);
        s3.addRating(new Rating("41",4));
        Song s4 =new Song("FPS","Drake","D");
        songMap.put("FPS",s4);
        s4.addRating(new Rating("10",2));
        Song s5 =new Song("IDGAF","Yeat","E");
        songMap.put("IDGAF",s5);
        s5.addRating(new Rating("10",1));
        s5.addRating(new Rating("33",5));
        assertEquals(5,songs.size());

        for (Song song: songs){
            String key = song.getTitle();
            if(songMap.containsKey(key)){
                Song expSong=songMap.get(key);
                assertEquals(expSong.getSongID(),song.getSongID());
                assertEquals(expSong.getTitle(),song.getTitle());
                assertEquals(expSong.getArtist(),song.getArtist());
                LinkedListNode<Rating> r1= expSong.getRatings();
                LinkedListNode<Rating> r2= song.getRatings();
                while (r1!=null && r2!=null) {
                    assertEquals(r1.getValue().getReviewerID(), r2.getValue().getReviewerID());
                    assertEquals(r1.getValue().getRating(),r2.getValue().getRating());
                    r1=r1.getNext();
                    r2=r2.getNext();
                }
            }else{
                fail();
            }
        }

    }
    //Jumanji,Rock,Jack,Peter
    //Home Alone,Donald,Park,Tree
    //Nemo,Nemo,Dory,Shark


    @Test
    public void movie_test_1() {
        ArrayList<Movie> movies = FileReader.readMovies("data/movies_test_1.csv");

        HashMap<String,Movie> movieMap =new HashMap<>();
        //Jumanji,Rock,Jack,Peter
        //Home Alone,Donald,Park,Tree
        //Nemo,Nemo,Dory,Shark
        Movie m1=new Movie("Jumanji",new ArrayList<>(Arrays.asList("Rock","Jack","Peter")));
        movieMap.put("Jumanji",m1);
        //m1.addRating(new Rating("66",4));
        Movie m2=new Movie("Home Alone",new ArrayList<>(Arrays.asList("Donald","Park","Tree")));
        movieMap.put("Home Alone",m2);
        Movie m3=new Movie("Nemo",new ArrayList<>(Arrays.asList("Nemo","Dory","Shark")));
        movieMap.put("Nemo",m3);
        assertEquals(3,movies.size());


        for (Movie movie: movies){
            String key=movie.getTitle();
            if(movieMap.containsKey(key)){
                Movie expMovie=movieMap.get(key);
                assertEquals(expMovie.getTitle(),movie.getTitle());

                for( int x=0;x<expMovie.getCast().size();x++){
                    assertEquals(expMovie.getCast().get(x),movie.getCast().get(x));
                }
            }else {
                fail();
            }
        }

    }

    @Test
    public void movie_test_2() {
        ArrayList<Movie> movies = FileReader.readMovies("data/movies_test_2.csv");

        HashMap<String,Movie> movieMap =new HashMap<>();
        //Jumanji,Rock,Jack,Peter
        //Home Alone,Donald,Park,Tree
        //Nemo,Nemo,Dory,Shark
        Movie m1=new Movie("Jumanji",new ArrayList<>(Arrays.asList("Rock","Jack","Peter")));
        movieMap.put("Jumanji",m1);
        //m1.addRating(new Rating("66",4));
        Movie m2=new Movie("Home Alone",new ArrayList<>(Arrays.asList("Donald","Park","Tree")));
        movieMap.put("Home Alone",m2);
        Movie m3=new Movie("Nemo",new ArrayList<>(Arrays.asList("Nemo","Dory","Shark","Harry")));
        movieMap.put("Nemo",m3);
        //Avengers,Iron,Super,Aqua,Bat
        Movie m4=new Movie("Avengers",new ArrayList<>(Arrays.asList("Iron","Super","Aqua","Bat")));
        movieMap.put("Avengers",m4);
        assertEquals(4,movies.size());

        for (Movie movie: movies){
            String key=movie.getTitle();
            if(movieMap.containsKey(key)){
                Movie expMovie=movieMap.get(key);
                assertEquals(expMovie.getTitle(),movie.getTitle());

                for( int x=0;x<expMovie.getCast().size();x++){
                    assertEquals(expMovie.getCast().get(x),movie.getCast().get(x));
                }
            }else{
                fail();
            }
        }

    }


    //Jumanji,A,2
    //Home Alone,B,3
    //Nemo,C,4

    @Test
    public void movie_rating_test_1() {
        ArrayList<Movie> movies = FileReader.readMovies("data/movies_test_1.csv");
        ArrayList<Movie> movieRatings = FileReader.readMovieRatings(movies,"data/movie_ratings_test_1.csv");

        //Jumanji,A,2   #movieRating file
        //Home Alone,B,3
        //Nemo,C,4
        //Shrek,D,5
        //Nemo,E,4

        //Jumanji,Rock,Jack,Peter
        //Home Alone,Donald,Park,Tree  #movie
        //Nemo,Nemo,Dory,Shark

        HashMap<String,Movie> movieRatingMap =new HashMap<>();

        Movie m1=new Movie("Jumanji",new ArrayList<>(Arrays.asList("Rock","Jack","Peter")));
        m1.addRating(new Rating("A",2));
        movieRatingMap.put("Jumanji",m1);
        Movie m2=new Movie("Home Alone",new ArrayList<>(Arrays.asList("Donald","Park","Tree")));
        m2.addRating(new Rating("B",3));
        movieRatingMap.put("Home Alone",m2);
        Movie m3=new Movie("Nemo",new ArrayList<>(Arrays.asList("Nemo","Dory","Shark")));
        m3.addRating(new Rating("C",4));
        m3.addRating(new Rating("E",4));
        movieRatingMap.put("Nemo",m3);
        assertEquals(3,movieRatings.size());



        for (Movie movie: movieRatings){
            if (!movieRatingMap.containsKey(movie.getTitle())){
                fail();
            }


            Movie expMovie=movieRatingMap.get(movie.getTitle());
            assertEquals(expMovie.getTitle(),movie.getTitle());
            if(movieRatingMap.containsKey(movie.getTitle())){
                for( int x=0;x<expMovie.getCast().size();x++){
                    assertEquals(expMovie.getCast().get(x),movie.getCast().get(x));
                }
                LinkedListNode<Rating> r1= expMovie.getRatings();
                LinkedListNode<Rating> r2= movie.getRatings();
                while (r1!=null && r2!=null) {
                    assertEquals(r1.getValue().getReviewerID(), r2.getValue().getReviewerID());
                    assertEquals(r1.getValue().getRating(),r2.getValue().getRating());
                    r1=r1.getNext();
                    r2=r2.getNext();
                }
                compareListsOfRatings(r1,r2);
            }else{
                fail();
            }
        }

    }


    @Test
    public void movie_rating_test_3() {
        ArrayList<Movie> movies = FileReader.readMovies("data/movies_test_4.csv");
        ArrayList<Movie> movieRatings = FileReader.readMovieRatings(movies,"data/movie_ratings_test_3.csv");

        // #movieRating file
        //Nemo,C,4
        //Nemo,E,4

        //movie file
        //Nemo,Nemo,Dory,Shark

        HashMap<String,Movie> movieRatingMap =new HashMap<>();


        Movie m3=new Movie("Nemo",new ArrayList<>(Arrays.asList("Nemo","Dory","Shark")));
        m3.addRating(new Rating("C",4));
        m3.addRating(new Rating("E",4));
        movieRatingMap.put("Nemo",m3);


        for (Movie movie: movieRatings){
            Movie expMovie=movieRatingMap.get(movie.getTitle());
            assertEquals(expMovie.getTitle(),movie.getTitle());
            if(movieRatingMap.containsKey(movie.getTitle())){
                for( int x=0;x<expMovie.getCast().size();x++){
                    assertEquals(expMovie.getCast().get(x),movie.getCast().get(x));
                }
                LinkedListNode<Rating> r1= expMovie.getRatings();
                LinkedListNode<Rating> r2= movie.getRatings();

                int y=0;
                while (r1!=null && r2!=null) {
                    assertEquals(r1.getValue().getReviewerID(), r2.getValue().getReviewerID());
                    assertEquals(r1.getValue().getRating(),r2.getValue().getRating());
                    r1=r1.getNext();
                    r2=r2.getNext();
                    y++;
                }
                assertTrue(y==2);

            }else{
                fail();
            }
        }

    }

}




package ratings;

import ratings.datastructures.LinkedListNode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FileReader {
    public static ArrayList<String> readFile(String filename) {
        try {
            return new ArrayList<>(Files.readAllLines(Paths.get(filename)));
        } catch (IOException e) {

            return new ArrayList<>();
        }
    }

    public static ArrayList<Song> readSongs(String filename) {
        ArrayList<Song> allSongs = new ArrayList<>();
        ArrayList<String> lines = readFile(filename);
        //lines.remove(0);  //removes header
        for (String line : lines) {
            ArrayList<String> splits = new ArrayList<>(Arrays.asList(line.split(",")));
            String SongID = splits.get(0);
            String artist = splits.get(1);
            String title = splits.get(2);
            String reviewerID = splits.get(3);
            Rating rating = new Rating(reviewerID, Integer.parseInt(splits.get(4)));
            boolean found = false;
            for (Song x : allSongs) {
                String ID = x.getSongID();
                if (ID.equals(SongID)) {
                    x.addRating(rating);
                    found = true;
                    break;
                }
            }
            if (found == false) {
                Song song = new Song(title, artist, SongID);
                song.addRating(rating);
                allSongs.add(song);

            }
        }
        return allSongs;
    }


    public static ArrayList<Movie> readMovies(String filename) {
        ArrayList<Movie> allMovies = new ArrayList<>();
        ArrayList<String> lines = readFile(filename);
        //lines.remove(0);
        for (String line : lines) {
            ArrayList<String> splits = new ArrayList<>(Arrays.asList(line.split(",")));
            String title = splits.get(0);
            splits.remove(0);
            ArrayList<String> cast = new ArrayList<>(splits);
            Movie movie = new Movie(title, cast);
            allMovies.add(movie);
        }
        return allMovies;
    }


    public static ArrayList<Movie> readMovieRatings(ArrayList<Movie> input, String filename) {
        HashMap<String, Movie> MovieMap = new HashMap<>();
        ArrayList<Movie> out = new ArrayList<>();
        for (Movie movie : input) {
            MovieMap.put(movie.getTitle(), movie);
        }

        ArrayList<String> lines = readFile(filename);
        for (String line : lines) {
            ArrayList<String> splits = new ArrayList<>(Arrays.asList(line.split(",")));
            String title = splits.get(0);
            String reviewerID = splits.get(1);
            Rating rating = new Rating(reviewerID, Integer.parseInt(splits.get(2)));
            Movie m = MovieMap.get(title);
            if (m != null) {
                m.addRating(rating);
            }
        }
        for (Movie movie : MovieMap.values()) {
            if (movie.getRatings() != null && movie.getRatings().getValue() != null) {
                out.add(movie);
            }
        }


        return out;
    }
}








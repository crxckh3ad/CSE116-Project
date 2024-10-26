package ratings;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

import static ratings.FileReader.*;
import static ratings.Ratable.*;

public class MediaLibrary {
    private ArrayList<Ratable> ratables;

    public MediaLibrary() {

    }

    public void populateLibrary(String songR, String movie, String movieR) {
        this.ratables = new ArrayList<>();
        ArrayList<Song> songRatings = readSongs(songR);
        ArrayList<Movie> movies = readMovies(movie);
        
        ArrayList<Movie> movieRatings = readMovieRatings(movies, movieR);
        for (Ratable song : songRatings) {
            this.ratables.add(song);
        }
        for (Ratable movie1 : movieRatings) {
            this.ratables.add(movie1);
        }
        System.out.println(this.ratables);


    }


    public ArrayList<Ratable> topKRatables(int k) {
        ArrayList<Ratable> out = new ArrayList<>();
        ratables.sort(new Comparator<Ratable>(){
            @Override
            public int compare(Ratable r1, Ratable r2) {
                double t1 = r1.bayesianAverageRating(2,3);
                double t2 = r2.bayesianAverageRating(2,3);
                return Double.compare(t2,t1);
            }
        });
        if (k>ratables.size()){
            return ratables;
        }
        for (int x= 0;x<k; x++) {
            out.add(ratables.get(x));
        }
        System.out.println(out);
        return out;
    }

}

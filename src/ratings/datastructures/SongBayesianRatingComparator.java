package ratings.datastructures;

import ratings.Song;

public class SongBayesianRatingComparator extends Comparator<Song> {
    @Override
    public boolean compare(Song a, Song b) {
        double t1 = a.bayesianAverageRating(2,3);
        double t2 = b.bayesianAverageRating(2,3);
        if (t1>t2) {
            return true;
        }
        return false;
    }

}

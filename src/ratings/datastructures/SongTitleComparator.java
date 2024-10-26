package ratings.datastructures;

import ratings.Song;

public class SongTitleComparator extends Comparator<Song> {
    @Override
    public boolean compare(Song a, Song b) {
        String t1 = a.getTitle();
        String t2 = b.getTitle();
        int check = t2.compareToIgnoreCase(t1);
        if (check > 0) {
            return true;
        }
        return false;
    }


}

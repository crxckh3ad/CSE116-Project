package ratings;

import ratings.datastructures.LinkedListNode;

public class Song extends Ratable{
    private String artist;
    private String SongID;

    public Song(String title,String artist, String SongID) {
        setTitle(title);
        this.artist = artist;
        this.SongID = SongID;
    }


    public String getArtist() {
        return this.artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getSongID() {
        return this.SongID;
    }

    public void setSongID(String SongID) {
        this.SongID = SongID;
    }



}

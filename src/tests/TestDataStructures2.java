package tests;

import org.junit.Test;
import ratings.Playlist;
import ratings.Ratable;
import ratings.Song;
import ratings.datastructures.BinaryTreeNode;
import ratings.datastructures.Comparator;
import ratings.datastructures.LinkedListNode;
import ratings.datastructures.SongTitleComparator;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestDataStructures2{

    public boolean compareSongTrees(BinaryTreeNode<Song> r1, BinaryTreeNode<Song> r2){
        if (r1 ==null && r2 ==null){
            return true;
        }
        if (r1 ==null || r2 ==null){
            return false;
        }
        if (!r1.getValue().getTitle().equalsIgnoreCase(r2.getValue().getTitle()) ||
                !r1.getValue().getArtist().equalsIgnoreCase(r2.getValue().getArtist())||
                !r1.getValue().getSongID().equals(r2.getValue().getSongID())){
            return false;
        }
        Ratable s1 =r1.getValue();
        Ratable s2 =r2.getValue();
        if (s1 !=null && s2 !=null){
            assertEquals(s1.averageRating(), s2.averageRating(), 0.001);
            if (Math.abs(s1.averageRating() - s2.averageRating()) > 0.001){
                return false;
            }
        }
        return compareSongTrees(r1.getLeft(), r2.getLeft()) && compareSongTrees(r1.getRight(), r2.getRight());
    }

    @Test
    public void testSongTitleComparator(){
        Comparator<Song> comparator =new SongTitleComparator();
        Playlist playlist =new Playlist(comparator);

        Song s1 =new Song("Bandit", "Don", "1");
        Song s2 =new Song("lb", "Tecca", "2");
        Song s3 =new Song("Carnival", "Ye", "3");
        Song s4 =new Song("D Know", "Travis", "4");
        Song s5 =new Song("Iffy", "Sik", "5");

        playlist.addSong(s2);
        playlist.addSong(s3);
        playlist.addSong(s1);
        playlist.addSong(s4);
        playlist.addSong(s5);

        BinaryTreeNode<Song> actual =playlist.getSongTree();

        Playlist playlist2 =new Playlist(comparator);
        playlist2.addSong(s4);
        playlist2.addSong(s3);
        playlist2.addSong(s2);
        playlist2.addSong(s1);
        playlist2.addSong(s5);


        BinaryTreeNode<Song> expected =playlist.getSongTree();
        compareSongTrees(actual, expected);
        LinkedListNode<Song> songList =playlist.getSongList();

        String[] expOrder ={"Bandit","Carnival","D Know","Iffy", "lb"};
        LinkedListNode<Song> songlist =songList;
        int x =0;
        while (songlist !=null){
            assertEquals(expOrder[x],songlist.getValue().getTitle());
            songlist =songlist.getNext();
            x++;
        }

        Song[] expSongs ={s1,s3,s2,s4,s5};
        for (Song expSong : expSongs){
            LinkedListNode<Song> songlist2 =songList;
            boolean Found =false;
            while (songlist2 !=null){
                if (songlist2.getValue() ==expSong){
                    Found =true;
                    break;
                }
                songlist2 = songlist2.getNext();
            }
            assertTrue(Found);
        }
    }

}
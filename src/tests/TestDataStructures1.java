package tests;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import ratings.Rating;
import ratings.Song;
import ratings.Reviewer;
import ratings.datastructures.LinkedListNode;

public class TestDataStructures1 {
    public static boolean compareListsOfRatings(LinkedListNode<Rating> l1, LinkedListNode<Rating> l2) {
        if (l1 ==null && l2 ==null){
            return true;
        }
        if (l1 ==null || l2 ==null){
            return false;
        }

        while (l1 !=null && l2 !=null) {
            if (ratingEquals(l1.getValue(),l2.getValue())==false){
                return false;
            }
            l1 =l1.getNext();
            l2 =l2.getNext();
        }
        return l1 ==null && l2 ==null;
    }

    private static boolean ratingEquals(Rating r1, Rating r2) {
        return r1.getRating() == r2.getRating() && r1.getReviewerID().equals(r2.getReviewerID());
    }

    @Test
    public void testAverageRating() {
        Rating r1 = new Rating("r1", 3);
        Rating r2 = new Rating("r2", 4);
        Rating r3 = new Rating("r3", 5);

        Song s1 = new Song("trash", "Post", "23");
        s1.addRating(r1);
        s1.addRating(r2);
        s1.addRating(r3);

        assertEquals(4.0, s1.averageRating(), 0.01);

        Rating r4 = new Rating("r4", -1);
        Rating r5 = new Rating("r5", -1);
        Rating r6 = new Rating("r6", 5);

        Song s2 = new Song("trash", "Post", "23");
        s2.addRating(r4);
        s2.addRating(r5);
        s2.addRating(r6);
        assertEquals(5, s2.averageRating(), 0.01);

        Rating r7 = new Rating("r7", -1);
        Rating r8 = new Rating("r8", -1);
        Rating r9 = new Rating("r9", -1);

        Song s3 = new Song("trash", "Post", "23");
        s3.addRating(r7);
        s3.addRating(r8);
        s3.addRating(r9);
        assertEquals(0.0, s3.averageRating(), 0.01);

    }

    @Test
    public void testRemoveRatingByReviewer() {
        Rating r4 = new Rating("r4", 3);
        Rating r5 = new Rating("r5", 25);
        Rating r6 = new Rating("r6", 0);
        LinkedListNode<Rating> first = new LinkedListNode<>(r4,null);
        first = new LinkedListNode<>(r5,first);
        first = new LinkedListNode<>(r6,first);

        Song s2 = new Song("Go", "Laroi", "23");
        s2.setRatings(first);
        Reviewer reviewer = new Reviewer("r5");
        s2.removeRatingByReviewer(reviewer);
        LinkedListNode<Rating> expected = new LinkedListNode<>(r4,null);
        expected = new LinkedListNode<>(r6,expected);
        assertTrue(compareListsOfRatings(s2.getRatings(), expected));


        Rating r7 = new Rating("r7", 1);
        Rating r8 = new Rating("r8", 222);
        Rating r9 = new Rating("r9", 4);
        LinkedListNode<Rating> first2 = new LinkedListNode<>(r7,null);
        first2 = new LinkedListNode<>(r8,first2);
        first2 = new LinkedListNode<>(r9,first2);

        Song s3 = new Song("WLR", "CArti", "53");
        s3.setRatings(first2);
        Reviewer reviewer2 = new Reviewer("r9");
        s3.removeRatingByReviewer(reviewer2);
        LinkedListNode<Rating> expected2 = new LinkedListNode<>(r7,null);
        expected2 = new LinkedListNode<>(r8,expected2);
        assertTrue(compareListsOfRatings(s3.getRatings(), expected2));

        Rating r10 = new Rating("r10", 5);
        Rating r11 = new Rating("r11", 45);
        Rating r12 = new Rating("r12", 9);
        LinkedListNode<Rating> first3 = new LinkedListNode<>(r10,null);
        first3 = new LinkedListNode<>(r11,first3);
        first3 = new LinkedListNode<>(r12,first3);

        Song s4 = new Song("poe", "ice", "97");
        s4.setRatings(first3);
        Reviewer reviewer3 = new Reviewer("r10");
        s4.removeRatingByReviewer(reviewer3);
        LinkedListNode<Rating> expected3 = new LinkedListNode<>(r11,null);
        expected3 = new LinkedListNode<>(r12,expected3);
        assertTrue(compareListsOfRatings(s4.getRatings(), expected3));

    }
}
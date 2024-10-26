package ratings;

import ratings.datastructures.LinkedListNode;

public class Ratable {
    private String title;
    private LinkedListNode<Rating> allRatings;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public void addRating(Rating r) {
        if (r.getRating() != -1){
            if (allRatings ==null) {
                allRatings =new LinkedListNode<>(r, null);
            } else {
                LinkedListNode<Rating> first =allRatings;
                while (first.getNext() !=null) {
                    first = first.getNext();
                }
                first.setNext(new LinkedListNode<>(r,null));
            }
        }
    }
    public LinkedListNode<Rating> getRatings() {
        return allRatings;
    }
    public void setRatings(LinkedListNode<Rating> ratings) {
        this.allRatings = ratings;
    }

    public double averageRating() {
        double sum = 0.0;
        double count = 0.0;
        if (allRatings == null) {
            return 0.0;
        }
        LinkedListNode<Rating> first =allRatings;
        while (first !=null) {
            int ratingValue =first.getValue().getRating();
            if (ratingValue !=-1) {
                sum +=ratingValue;
                count+=1;
            }
            first =first.getNext();
        }
        double avg =sum/count;
        return avg;
    }
    private LinkedListNode<Rating> removeHelper(LinkedListNode<Rating> first,String reviewerID) {
        if (first ==null) {
            return null;
        }else if (first.getValue().getReviewerID().equals(reviewerID)) {
            return first.getNext();
        }
        first.setNext(removeHelper(first.getNext(),reviewerID));
        return first;
    }

    public void removeRatingByReviewer(Reviewer reviewer) {
        allRatings = removeHelper(allRatings, reviewer.getReviewerID());
    }
    public double bayesianAverageRating(int ExtraNum,int ExtraVal){

        if (ExtraVal>5 || ExtraVal<1){
            return 0.0;
        }
        if (allRatings==null && ExtraNum>0){
        return(ExtraVal);
        }
        if(ExtraNum<0){
            return 0.0;
        }
        double sum =ExtraVal*ExtraNum;
        double count =ExtraNum;

        LinkedListNode<Rating> first =allRatings;
        while (first != null) {
            int ratingValue = first.getValue().getRating();
            if (ratingValue !=-1) {
                sum += ratingValue;
                count+=1;
            }
            first =first.getNext();
        }
        if (count ==ExtraNum) {
            return 0.0;
        }
        double avg=sum/count;
        return avg;
    }
}



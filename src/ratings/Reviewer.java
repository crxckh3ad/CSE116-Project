package ratings;

public class Reviewer {
    private String ReviewerID;

    public Reviewer(String ReviewerID){
        this.ReviewerID=ReviewerID;
    }

    public String getReviewerID(){
        return this.ReviewerID;
    }
    public void setReviewerID(String ReviewerID){
        this.ReviewerID=ReviewerID;
    }
    public Rating rateSong(int ratingValue){
        if (ratingValue<1){
            ratingValue=-1;
        }
        if (ratingValue>5){
            ratingValue=-1;
        }
        Rating reviewer=new Rating(this.ReviewerID,ratingValue);
        return reviewer;

    }


}

package ratings;

public class Rating {
    private String reviewerID;
    private int rating;

    public Rating(String reviewerID, int rating) {
        if (rating > 0) {
            if (rating < 6) {
                this.rating = rating;
            } else {
                this.rating = -1;
            }
        } else {
            this.rating = -1;
        }

        this.reviewerID = reviewerID;
    }

    public String getReviewerID() {
        return this.reviewerID;
    }

    public void setReviewerID(String reviewerID) {
        this.reviewerID = reviewerID;
    }

    public int getRating() {
        return this.rating;
    }

    public void setRating(int rating) {
        if (rating > 0) {
            if (rating < 6) {
                this.rating = rating;
            } else {
                this.rating = -1;
            }
        } else {
            this.rating = -1;
        }
    }
}

package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Review {
    @Id
    private String ReviewId;
    private String bookingId;
    private double Rating;
    private String comment;
    private String date;

    protected Review(){}

    private Review(Builder builder){
        this.ReviewId = builder.ReviewId;
        this.bookingId = builder.bookingId;
        this.Rating = builder.Rating;
        this.comment = builder.comment;
        this.date = builder.date;
    }

    public String getReviewId() {
        return ReviewId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public double getRating() {
        return Rating;
    }

    public String getComment() {
        return comment;
    }

    public String getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return Double.compare(Rating, review.Rating) == 0 && Objects.equals(ReviewId, review.ReviewId) && Objects.equals(bookingId, review.bookingId) && Objects.equals(comment, review.comment) && Objects.equals(date, review.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ReviewId, bookingId, Rating, comment, date);
    }

    @Override
    public String toString() {
        return "Review{" +
                "ReviewId='" + ReviewId + '\'' +
                ", bookingId='" + bookingId + '\'' +
                ", Rating=" + Rating +
                ", comment='" + comment + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public static class Builder {
        private String ReviewId;
        private String bookingId;
        private double Rating;
        private String comment;
        private String date;

        public Builder setReviewId(String reviewId) {
            ReviewId = reviewId;
            return this;
        }

        public Builder setBookingId(String bookingId) {
            this.bookingId = bookingId;
            return this;
        }

        public Builder setRating(double rating) {
            Rating = rating;
            return this;
        }

        public Builder setComment(String comment) {
            this.comment = comment;
            return this;
        }

        public Builder setDate(String date) {
            this.date = date;
            return this;
        }
        public Builder copy(Review review){
            this.ReviewId = review.ReviewId;
            this.bookingId = review.bookingId;
            this.Rating = review.Rating;
            this.comment = review.comment;
            this.date = review.date;
            return this;
        }
        public Review build(){return new Review(this);}
    }

}

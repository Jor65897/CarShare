package za.ac.cput.repository;

import za.ac.cput.domain.CarInformation;
import za.ac.cput.domain.Review;
import java.util.ArrayList;
import java.util.List;

public class ReviewRepository implements IReviewRepository {

    private static ReviewRepository repository = null;
    private List<Review> reviewList;

    private ReviewRepository() {
        reviewList = new ArrayList<>();
    }

    public static ReviewRepository getRepository() {
        if (repository == null) {
            repository = new ReviewRepository();
        }
        return repository;
    }

    @Override
    public Review create(Review review) {
        boolean success = reviewList.add(review);
        if (success) {
            return review;
        }
        return null;
    }

    @Override
    public Review read(Review review) {
        for (Review r : reviewList) {
            if (r.equals(review)) {
                return r;
            }
        }
        return null;
    }

    @Override
    public Review read(String id) {
        for (Review r : reviewList) {
            if (r.getReviewId().equals(id)) {
                return r;
            }
        }
        return null;
    }

    @Override
    public Review update(Review review) {
        Review oldReview = read(review.getReviewId());
        if (oldReview != null) {
            reviewList.remove(oldReview);
            reviewList.add(review);
            return review;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        Review reviewToDelete = read(id);
        if (reviewToDelete != null) {
            reviewList.remove(reviewToDelete);
            return true;
        }
        return false;
    }

    @Override
    public List<Review> getallstuff() {
        return new ArrayList<>(reviewList);
    }

    @Override
    public List<CarInformation> getAll() {
        return getAll();
    }
}



package za.ac.cput.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Review;
import static org.junit.jupiter.api.Assertions.*;

class ReviewRepositoryTest {

    private ReviewRepository repository;
    private Review review;

    @BeforeEach
    void setUp() {
        repository = ReviewRepository.getRepository();
        review = new Review.Builder()
                .setReviewId("1")
                .setBookingId("101")
                .setRating(4.5)
                .setComment("Great experience")
                .setDate("2024-05-20")
                .build();
    }

    @Test
    void create() {
        Review createdReview = repository.create(review);
        assertNotNull(createdReview);
        assertEquals(review, createdReview);
    }

    @Test
    void read() {
        repository.create(review);
        Review retrievedReview = repository.read(review.getReviewId());
        assertNotNull(retrievedReview);
        assertEquals(review, retrievedReview);
    }

    @Test
    void update() {
        repository.create(review);
        Review updatedReview = new Review.Builder()
                .copy(review)
                .setRating(5.0)
                .build();
        Review result = repository.update(updatedReview);
        assertNotNull(result);
        assertEquals(updatedReview, result);
    }

    @Test
    void delete() {
        repository.create(review);
        boolean success = repository.delete(review.getReviewId());
        assertTrue(success);
        assertNull(repository.read(review.getReviewId()));
    }

    @Test
    void getAll() {
        repository.create(review);
        assertEquals(1, repository.getAll().size());
    }
}

package com.review.review.MicroService.Review;

import java.util.List;

public interface ReviewService {

    List<Review> getAllReviews(long companyId);

    boolean addReview(long companyId, Review review);

    Review getReviewById(long reviewId);

    boolean updateReview(long reviewId,Review review);

    boolean deleteReview(long reviewId);
}

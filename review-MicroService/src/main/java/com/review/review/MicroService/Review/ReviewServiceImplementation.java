package com.review.review.MicroService.Review;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImplementation implements ReviewService{



    @Autowired
    ReviewRepository reviewRepository;
    @Override

    public List<Review> getAllReviews(long companyId) {

        return reviewRepository.findByCompanyId(companyId);
    }



    @Override
    public Review getReviewById( long reviewId) {

        return reviewRepository.findById(reviewId).orElse(null);
    }

    @Override
    public boolean addReview(long companyId, Review review) {

        if(review !=null){
            review.setCompanyId(companyId);
            reviewRepository.save(review);
            return true;
        }

//        company.getReviewList().add(review); //not sure about it

        return false;
    }

    @Override
    public boolean updateReview( long reviewId, Review review) {
        Review review1=reviewRepository.findById(reviewId).orElse(null);
        if(review1!=null){
            review.setCompanyId(review1.getCompanyId());
            review.setId(reviewId);
            reviewRepository.save(review);
            return true;
        }
        return false;

    }

    @Override
    public boolean deleteReview(long reviewId) {

        if(reviewRepository.existsById(reviewId)) {
            reviewRepository.deleteById(reviewId);

            return true;

        }

        return false;

    }
}

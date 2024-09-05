package com.review.review.MicroService.Review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//        GET / companies/ {companyld}/reviews
//        POST / companies/ {company ld}/ reviews
//        GET / companies/ {company ld}/ reviews-L{reviewld}
//        PUT / companies/ {companyld}/reviews/{reviewld}
//        DELETE / companies/ {companyld}/reviews/{reviewld}

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

@GetMapping
public ResponseEntity<List<Review>> findAllReview(@RequestParam long companyId){
    return ResponseEntity.ok(reviewService.getAllReviews(companyId));
}

@GetMapping("/{id}")
public ResponseEntity<Review> reviewById(@PathVariable long id){

    Review review=reviewService.getReviewById(id);
    if(review==null)
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    return new ResponseEntity<>(review,HttpStatus.OK);
}

@PostMapping
public ResponseEntity<String> createReviews(@RequestParam long companyId,@RequestBody Review review){

    boolean flag=reviewService.addReview(companyId,review);
    if (flag)
        return new ResponseEntity<>(String.format("Review created for company id %s",companyId),HttpStatus.CREATED);
    return new ResponseEntity<>(String.format("Company id %s not found",companyId),HttpStatus.NOT_FOUND);
}
@PutMapping("/{id}")
    public ResponseEntity<String> updateReview(@PathVariable long id,@RequestBody Review review){
    boolean flag= reviewService.updateReview(id,review);
    if(flag)
        return new ResponseEntity<>("Updated Review",HttpStatus.ACCEPTED);
    return new ResponseEntity<>("NOt found",HttpStatus.NOT_FOUND);
}
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReview(@PathVariable long id){
        boolean flag= reviewService.deleteReview(id);
        if(flag)
            return new ResponseEntity<>("Deleted Review",HttpStatus.ACCEPTED);
        return new ResponseEntity<>("NOt found",HttpStatus.NOT_FOUND);
    }


}

package com.geektext.geektext;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    private final RatingRepository ratingRepository;

    public RatingController(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @PostMapping
    public ResponseEntity<String> createRating(@RequestBody Rating rating) {
        if (rating.getUserId() == null || rating.getBookId() == null) {
            return ResponseEntity.badRequest().body("User ID and Book ID are required");
        }
        if (rating.getRatingValue() < 1 || rating.getRatingValue() > 5) {
            return ResponseEntity.badRequest().body("Rating must be between 1 and 5");
        }
        ratingRepository.save(rating);
        return ResponseEntity.ok("Rating submitted successfully");
    }
}
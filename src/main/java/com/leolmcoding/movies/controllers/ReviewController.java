package com.leolmcoding.movies.controllers;

import com.leolmcoding.movies.documents.Review;
import com.leolmcoding.movies.dtos.ReviewRequestDTO;
import com.leolmcoding.movies.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("reviews")
public class ReviewController {
    private ReviewService reviewService;
    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody ReviewRequestDTO reviewRequestDTO){
        return new ResponseEntity<Review>(reviewService.createReview(reviewRequestDTO.body(),reviewRequestDTO.imdbId()), HttpStatus.CREATED);
    }
}

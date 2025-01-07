package com.example.demo.controllers;

import com.example.demo.dto.ReviewDto;
import com.example.demo.exception.PokemonNotFoundException;
import com.example.demo.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }


    @PostMapping("review/:id/create/")
    public ResponseEntity<ReviewDto> createReview(
            @RequestBody ReviewDto reviewDto,
            @PathVariable int id
    ) throws PokemonNotFoundException {
        return new ResponseEntity<>(reviewService.createReview(id, reviewDto), HttpStatus.CREATED);
    }

    @GetMapping("review")
    public ResponseEntity<List<ReviewDto>> getAllReviews(
            @PathVariable int id
    ){
        return new ResponseEntity<>(reviewService.getAllReviewsByPokemonId(id), HttpStatus.OK);
    }
}

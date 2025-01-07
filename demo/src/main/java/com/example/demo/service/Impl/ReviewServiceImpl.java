package com.example.demo.service.Impl;

import com.example.demo.dto.ReviewDto;
import com.example.demo.exception.PokemonNotFoundException;
import com.example.demo.models.Pokemon;
import com.example.demo.models.Review;
import com.example.demo.repository.PokemonRepository;
import com.example.demo.repository.ReviewRepository;
import com.example.demo.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final PokemonRepository pokemonRepository;
    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository, PokemonRepository pokemonRepository) {
        this.reviewRepository = reviewRepository;
        this.pokemonRepository = pokemonRepository;
    }

    @Override
    public ReviewDto createReview(int PokemonId, ReviewDto reviewDto) throws PokemonNotFoundException {
        Review review = mapToEntity(reviewDto);

        Pokemon pokemon = pokemonRepository.findById(PokemonId).orElseThrow(() -> new PokemonNotFoundException("Pokemon Not found"));
        review.setPokemon(pokemon);

        Review newReview = reviewRepository.save(review);

        return mapToDto(newReview);
    }

    @Override
    public List<ReviewDto> getAllReviewsByPokemonId(int PokemonId) {
        List<Review> reviews = reviewRepository.findByPokemonId(PokemonId);
        return reviews.stream().map(r -> mapToDto(r)).collect(Collectors.toList());
    }

    private ReviewDto mapToDto(Review review) {
        ReviewDto reviewDto = new ReviewDto();
        reviewDto.setId(review.getId());
        reviewDto.setTitle(review.getTitle());
        reviewDto.setContent(review.getContent());
        reviewDto.setStars(review.getStars());
        return  reviewDto;
    }

    private Review mapToEntity(ReviewDto reviewDto) {
        Review review = new Review();
        review.setTitle(reviewDto.getTitle());
        review.setContent(reviewDto.getContent());
        review.setStars(reviewDto.getStars());
        return review;
    }
}

package com.example.demo.service;

import com.example.demo.dto.PokemonDto;
import com.example.demo.dto.ReviewDto;
import com.example.demo.exception.PokemonNotFoundException;

import java.util.List;

public interface ReviewService {
    ReviewDto createReview(int PokemonId, ReviewDto reviewDto) throws PokemonNotFoundException;
    List<ReviewDto> getAllReviewsByPokemonId(int PokemonId);
}

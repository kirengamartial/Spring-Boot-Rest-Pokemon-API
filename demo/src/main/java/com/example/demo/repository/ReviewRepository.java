package com.example.demo.repository;

import com.example.demo.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByPokemonId(int pokemonId);
}

package com.example.demo.service;

import com.example.demo.dto.PokemonDto;
import com.example.demo.dto.PokemonResponse;
import com.example.demo.exception.PokemonNotFoundException;

public interface PokemonService {
    PokemonDto createPokemon(PokemonDto pokemonDto);
    PokemonResponse getAllPokemons(int pageNo, int pageSize);
    PokemonDto getSinglePokemon(int id) throws PokemonNotFoundException;
    PokemonDto updatePokemon(PokemonDto pokemonDto, int id) throws PokemonNotFoundException;
    void deletePokemon(int id) throws PokemonNotFoundException;
}

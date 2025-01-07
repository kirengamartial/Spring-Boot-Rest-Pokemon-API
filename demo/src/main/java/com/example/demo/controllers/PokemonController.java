package com.example.demo.controllers;

import com.example.demo.dto.PokemonDto;
import com.example.demo.dto.PokemonResponse;
import com.example.demo.exception.PokemonNotFoundException;
import com.example.demo.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class PokemonController {

    private final PokemonService pokemonService;


    @Autowired
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @PostMapping("pokemon")
    public ResponseEntity<PokemonDto> createPokemon(
            @RequestBody PokemonDto pokemonDto
    ) {
        return new ResponseEntity<>(pokemonService.createPokemon(pokemonDto), HttpStatus.CREATED);
    }

    @GetMapping("pokemon")
    public ResponseEntity<PokemonResponse> getAllPokemon(
            @RequestParam(name = "PageNo", defaultValue = "0", required = false) int PageNo,
            @RequestParam(name = "PageSize", defaultValue = "10", required = false) int PageSize
    ) {
        return new ResponseEntity<>(pokemonService.getAllPokemons(PageNo, PageSize), HttpStatus.OK);
    }

    @GetMapping("pokemon/:id")
    public ResponseEntity<PokemonDto> getPokemon(
            @PathVariable int id
    ) throws PokemonNotFoundException {
        return new ResponseEntity<>(pokemonService.getSinglePokemon(id), HttpStatus.OK);
    }

    @PutMapping("pokemon/:id")
    public ResponseEntity<PokemonDto> updatePokemon(
            @PathVariable int id,
            @RequestBody PokemonDto pokemonDto
    ) throws PokemonNotFoundException {
        return new ResponseEntity<>(pokemonService.updatePokemon(pokemonDto, id), HttpStatus.OK);
    }

    @DeleteMapping("pokemon/:pokemonId/delete")
    public ResponseEntity<String> deletePokemon(
            @PathVariable(name = "id") int id
    ) throws PokemonNotFoundException {
        pokemonService.deletePokemon(id);
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }

}

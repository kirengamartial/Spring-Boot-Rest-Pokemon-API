package com.example.demo.exception;

public class PokemonNotFoundException extends Exception{
    private  static final Long serialVersionUID = 1L;

    public PokemonNotFoundException(String message) {
        super(message);
    }
}

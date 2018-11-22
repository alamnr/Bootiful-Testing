package com.example.demo.controller;

import com.example.demo.domain.Beer;
import com.example.demo.repository.BeerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;

@RestController
public class BeerRestController {

    private final BeerRepository repository;

    public BeerRestController(BeerRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/beers")
    private Collection<Beer> getBeers(){
        return this.repository.findAll();
    }
}

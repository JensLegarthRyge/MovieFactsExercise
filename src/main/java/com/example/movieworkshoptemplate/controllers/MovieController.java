package com.example.movieworkshoptemplate.controllers;

import com.example.movieworkshoptemplate.services.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {
    //Controller methods
    @GetMapping("/")
    public String index(){
        return "Hello World welcome to my application";
    }

    @GetMapping("/getFirst")
    public String getFirst(){
        return MovieService.getFirstMovieFromList();
    }

    @GetMapping("/getRandom")
    public String getRandom(){
        return MovieService.getRandomMovieTitleFromList();
    }

    @GetMapping("getTenSortByPopularity")
    public String getTenSortByPopularity(){
        return MovieService.getTenSortByPopularity();
    }

    @GetMapping("howManyWonAnAward")
    public String howManyWonAnAward(){
        return MovieService.howManyWonAnAward();
    }
}

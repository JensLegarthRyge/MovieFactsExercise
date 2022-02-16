package com.example.movieworkshoptemplate.services;

import com.example.movieworkshoptemplate.models.Movie;
import com.example.movieworkshoptemplate.repositories.MovieDataRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MovieService {
    public static String getFirstMovieFromList(){
        ArrayList<Movie> allMovies = MovieDataRepository.getAllMoviesList();
        return allMovies.get(0).getTitle();
    }

    public static String getRandomMovieTitleFromList(){
        ArrayList<Movie> allMovies = MovieDataRepository.getAllMoviesList();
        Random rand = new Random();
        int randomMovieNumber = rand.nextInt(allMovies.size());
        return allMovies.get(randomMovieNumber).getTitle();
    }

    public static Movie getRandomMovieFromList(){
        ArrayList<Movie> allMovies = MovieDataRepository.getAllMoviesList();
        Random rand = new Random();
        int randomMovieNumber = rand.nextInt(allMovies.size());
        return allMovies.get(randomMovieNumber);
    }

    public static String getTenSortByPopularity(){

        ArrayList<Movie> tenRandomMovies = new ArrayList<Movie>();
        for (int i = 0; i < 10; i++) {
            Movie randomMovie = getRandomMovieFromList();
            tenRandomMovies.add(randomMovie);
        }

        Collections.sort(tenRandomMovies);

        String listToReturn="<h1 style=\"color:#CA0000\">Ten random movies sorted by popularity</h1>";
        for (Movie currentMovie:tenRandomMovies) {
            listToReturn+="<b>Title:</b> "+currentMovie.getTitle()+"<br>";
            listToReturn+="<b>Popularity</b>: "+currentMovie.getPopularity();
            listToReturn+="<br><br>";
        }
        return listToReturn;
    }

    public static String howManyWonAnAward() {
        ArrayList<Movie> allMovies = MovieDataRepository.getAllMoviesList();

        int result = 0;

        for (Movie currentMovie : allMovies) {
            if (currentMovie.isAwardWinner()) {
                result++;
            }
        } return "<h1>"+result+" out of the "+allMovies.size()+" movies won awards</h1>";
    }
}

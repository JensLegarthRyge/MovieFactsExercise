package com.example.movieworkshoptemplate.repositories;

import com.example.movieworkshoptemplate.models.Movie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieDataRepository {
    //Methods to get data from file

    public static ArrayList<Movie> getAllMoviesList(){
        ArrayList<Movie> allMovies = new ArrayList<Movie>();
        File movies = new File("resources/imdb-data.csv");
        try {
            Scanner sc = new Scanner(movies);
            sc.nextLine();
            //filters out first row
            while(sc.hasNext()){
                String currentMovie = sc.nextLine();
                String[] currentMovieSplit = currentMovie.split(";");
                allMovies.add(Movie.createMovieFromStringArray(currentMovieSplit));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return allMovies;
    }

}

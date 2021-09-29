package com.example.movieapplication.repositories;

import java.io.File;

public class MovieApplicationRepositories {
    private static File movieFacts = new File("src/main/resources/imdb-data.csv");

    public MovieApplicationRepositories(){}

    public File getMovieFacts(){
        return movieFacts;
    }


}

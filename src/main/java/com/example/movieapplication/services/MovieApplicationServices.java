package com.example.movieapplication.services;

import com.example.movieapplication.repositories.MovieApplicationRepositories;
import com.example.movieapplication.models.Movie;

import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class MovieApplicationServices {
    private final MovieApplicationRepositories movieData = new MovieApplicationRepositories();
    private static ArrayList<Movie> movieList = new ArrayList<>();
    private static final ArrayList<Movie> awardList = new ArrayList<>();
    private final Random rand = new Random();


    public MovieApplicationServices(){
        loadMoviesFromFile();
    }

    public static ArrayList<Movie> getMovieList(){
        return movieList;
    }


    private void loadMoviesFromFile() {
        ArrayList<Movie> movies = new ArrayList<>();
        try {
                BufferedReader reader = new BufferedReader(new FileReader(movieData.getMovieFacts()));
                String line;
                String headerLine = reader.readLine();
                while((line = reader.readLine()) != null){
                    String[] movieStrings = line.split(";");
                    Movie movie = new Movie();
                    movie.setYear(Integer.parseInt(movieStrings[0]));
                    movie.setLengthInMin(Integer.parseInt(movieStrings[1]));
                    movie.setTitle(movieStrings[2]);
                    movie.setSubject(movieStrings[3]);
                    movie.setPopularity(Integer.parseInt(movieStrings[4]));
                    if(movieStrings[5].equals("Yes")){
                        movie.setAward(true);
                        awardList.add(movie);
                    }else {
                        movie.setAward(false);
                    }
                    movies.add(movie);
                }
                movieList = movies;
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public String getFirstMovie(){
        ArrayList<Movie> list = getMovieList();
        Movie firstMovie = list.get(0);
        return firstMovie.toString();
    }

    public Movie getRandomMovie() {
        int r = rand.nextInt(getMovieList().size());
        return getMovieList().get(r);
    }

    public ArrayList<Movie> getTenRandom(){
        ArrayList<Movie> tenList = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            Movie m = getRandomMovie();
            tenList.add(m);
        }
        Collections.sort(tenList);
    return tenList;
    }

    public String tenRandomString(){
        getTenRandom();
        String s = "10 movies sorted";
        for(int i = 0; i < 10; i++){
            s = s +"<br>" + getTenRandom().get(i) + "<br>";
        }
        return s;
    }

    public int howManyAwards(){
        return awardList.size();
    }

}

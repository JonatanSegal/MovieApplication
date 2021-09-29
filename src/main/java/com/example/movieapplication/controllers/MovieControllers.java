package com.example.movieapplication.controllers;


import com.example.movieapplication.services.MovieApplicationServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


@RestController
public class MovieControllers {
    private final MovieApplicationServices movieApplicationServices = new MovieApplicationServices();

    @GetMapping("/")
    public String welcome(){
        return "Welcome to my movie fact application";
    }

    @GetMapping("/GetFirst")
    public String firstMovie(){
        return movieApplicationServices.getFirstMovie();
    }

    @GetMapping("/Get-Random")
    public String random(){
        return movieApplicationServices.getRandomMovie().toString();
    }

    @GetMapping("/TenRandom")
    public String tenlist(){
        return movieApplicationServices.tenRandomString();
    }
    @GetMapping("/Awards")
    public int awardList(){
        return movieApplicationServices.howManyAwards();
    }

}

package com.example.movieapplication.models;

public class Movie implements Comparable<Movie> {
    private int year;
    private int lengthInMin;
    private String title;
    private String subject;
    private int popularity;
    private boolean award;

    public Movie(){}

    public String awardString(){
        if(isAward()){
            return "Yes";
        }
        return "No";
    }


    @Override
    public String toString(){
        return "Release year: " + getYear() +","+
                "Runtime: " + getLengthInMin() +","+
                "Realese year: " + getYear() +","+
                "Title: " + getTitle() +","+
                "Subject: "+ getSubject() +","+
                "<b>Popularity: "+ getPopularity()+"</b>,"+
                "Award: " + awardString();
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getLengthInMin() {
        return lengthInMin;
    }
    public void setLengthInMin(int lengthInMin) {
        this.lengthInMin = lengthInMin;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public int getPopularity() {
        return popularity;
    }
    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }
    public boolean isAward() {
        return award;
    }
    public void setAward(boolean award) {
        this.award = award;
    }

    @Override
    public int compareTo(Movie m) {
        if(popularity < m.getPopularity()){
            return -1;
        }else if(popularity > m.getPopularity()){
            return 1;
        }
        return 0;
    }
}

package com.example.movieworkshoptemplate.models;


public class Movie implements Comparable<Movie> {
    private int year;
    private int length;
    private String title;
    private String subject;
    private int popularity;
    private boolean isAwardWinner;

    public Movie(int year, int length, String title, String subject, int popularity, String isAwardWinner) {
        this.year = year;
        this.length = length;
        this.title = title;
        this.subject = subject;
        this.popularity = popularity;
        this.isAwardWinner= isAwardWinner.toLowerCase().equals("yes");
    }

    public static Movie createMovieFromStringArray(String[] movieSplit){
        int year = Integer.parseInt(movieSplit[0]);
        int length = Integer.parseInt(movieSplit[1]);
        String title = movieSplit[2];
        String subject = movieSplit[3];
        int popularity = Integer.parseInt(movieSplit[4]);
        String isAwardWinner = movieSplit[5];

        return new Movie(year,length,title,subject,popularity,isAwardWinner);
    }

    public String getTitle() {
        return title;
    }

    public boolean isAwardWinner() {
        return isAwardWinner;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "year=" + year +
                ", length=" + length +
                ", title='" + title + '\'' +
                ", subject='" + subject + '\'' +
                ", popularity=" + popularity +
                ", isAwardWinner=" + isAwardWinner +
                '}';
    }

    public int getPopularity() {
        return popularity;
    }

    @Override
    public int compareTo(Movie o) {
        if (this.popularity>(o.getPopularity())) {
            return 1;
        }else if (this.popularity<(o.getPopularity())){
            return -1;
        } else return 0;
    }
}

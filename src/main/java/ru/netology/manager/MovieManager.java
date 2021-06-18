package ru.netology.manager;

import ru.netology.domain.Movie;

public class MovieManager {

    private Movie[] movies = new Movie[0];
    private int numLast = 10;

    public MovieManager() {
    }

    public MovieManager(int numLast) {
        this.numLast = numLast;
    }

    public void add(Movie item) {
        int newLength = movies.length + 1;
        Movie[] tmp = new Movie[newLength];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        tmp[newLength - 1] = item;
        movies = tmp;
    }

    public Movie[] getLast() {
        return null;
    }

}

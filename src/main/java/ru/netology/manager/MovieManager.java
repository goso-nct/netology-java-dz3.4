package ru.netology.manager;

import ru.netology.domain.Movie;

public class MovieManager {

    private Movie[] movies = new Movie[0];
    private int lastLimit = 10;

    public MovieManager() {
    }

    public MovieManager(int lastLimit) {
        this.lastLimit = lastLimit;
    }

    public void add(Movie item) {
        if (getIndexById(item.getId()) == -1) {
            int newLength = movies.length + 1;
            Movie[] tmp = new Movie[newLength];
            System.arraycopy(movies,0, tmp,0, movies.length);
            tmp[newLength - 1] = item;
            movies = tmp;
        }
    }

    public int getIndexById(int id) {
        for (int i=0; i < movies.length; i++) {
            if (movies[i].getId() == id)
                return i;
        }
        return -1;
    }

    public void removeById(int id) {
        int index = getIndexById(id);
        if (index != -1) {
            int newLength = movies.length - 1;
            Movie[] tmp = new Movie[newLength];
            if (index == 0) {
                System.arraycopy(movies, 1, tmp, 0, newLength);
            } else if (index == newLength) {
                System.arraycopy(movies, 0, tmp, 0, newLength);
            } else {
                System.arraycopy(movies, 0, tmp, 0, index);
                System.arraycopy(movies, index + 1, tmp, index, newLength - index);
            }
            movies = tmp;
        }
    }

    public Movie[] getAll() {
        // reverse by condition
        int len = movies.length;
        Movie[] tmp = new Movie[len];
        for (int i = 0, j = len-1; i < len; i++, j--) {
            tmp[i] = movies[j];
        }
        return tmp;
    }

    public Movie[] getLast() {
        int len = lastLimit > movies.length ? movies.length : lastLimit;
        Movie[] tmp = new Movie[len];
        for (int i = 0, j = movies.length - 1; i < len; i++, j--) {
            tmp[i] = movies[j];
        }
        return tmp;
    }

    // for Tests

    MovieManager(Movie[] movies) {
        this.movies = movies;
    }

    Movie[] getMovies() {
        return movies;
    }

    void setMovies(Movie[] movies) {
        this.movies = movies;
    }
}

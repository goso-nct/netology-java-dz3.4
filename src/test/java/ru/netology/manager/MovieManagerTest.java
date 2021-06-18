package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class MovieManagerTest {

    Movie m1  = new Movie(1, "move 1", 100);
    Movie m2  = new Movie(2, "move 2", 100);
    Movie m3  = new Movie(3, "move 3", 100);
    Movie m4  = new Movie(4, "move 4", 100);
    Movie m5  = new Movie(5, "move 5", 100);
    Movie m6  = new Movie(6, "move 6", 100);
    Movie m7  = new Movie(7, "move 7", 100);
    Movie m8  = new Movie(8, "move 8", 100);
    Movie m9  = new Movie(9, "move 9", 100);
    Movie m10 = new Movie(10, "move 10", 100);
    Movie m11 = new Movie(11, "move 11", 100);
    Movie m12 = new Movie(12, "move 12", 100);

    @Test
    void add_shouldAdd() {
        Movie[] actual = { m1, m2 };
        MovieManager mm = new MovieManager(actual);
        mm.add(m3);
        actual = mm.getMovies();
        Movie[] expected = { m1, m2, m3 };
        assertArrayEquals(expected, actual);
    }

    @Test
    void add_shouldDontAdd() {
        Movie[] actual = { m1, m2, m3 };
        MovieManager mm = new MovieManager(actual);
        mm.add(m3);
        actual = mm.getMovies();
        Movie[] expected = { m1, m2, m3 };
        assertArrayEquals(expected, actual);
    }

    @Test
    void getIndexById_shouldFind() {
        Movie[] movies = { m1, m2, m3, m4, m5 };
        MovieManager mm = new MovieManager(movies);
        int actual = mm.getIndexById(4);
        assertEquals(3, actual);
    }

    @Test
    void getIndexById_shouldDontFind() {
        Movie[] movies = { m1, m2, m3, m4, m5 };
        MovieManager mm = new MovieManager(movies);
        int actual = mm.getIndexById(10);
        assertEquals(-1, actual);
    }

    @Test
    void removeById_shouldRemoveFirst() {
        Movie[] actual = { m1, m2, m3, m4 };
        MovieManager mm = new MovieManager(actual);
        mm.removeById(1);
        actual = mm.getMovies();
        Movie[] expected = { m2, m3, m4 };
        assertArrayEquals(expected, actual);
    }

    @Test
    void removeById_shouldRemoveMiddle() {
        Movie[] actual = { m1, m2, m3, m4 };
        MovieManager mm = new MovieManager(actual);
        mm.removeById(3);
        actual = mm.getMovies();
        Movie[] expected = { m1, m2, m4 };
        assertArrayEquals(expected, actual);
    }

    @Test
    void removeById_shouldRemoveLast() {
        Movie[] actual = { m1, m2, m3, m4 };
        MovieManager mm = new MovieManager(actual);
        mm.removeById(4);
        actual = mm.getMovies();
        Movie[] expected = { m1, m2, m3 };
        assertArrayEquals(expected, actual);
    }

    @Test
    void removeById_shouldDontRemove() {
        Movie[] actual = { m1, m2, m3, m4 };
        MovieManager mm = new MovieManager(actual);
        mm.removeById(5);
        actual = mm.getMovies();
        Movie[] expected = { m1, m2, m3, m4 };
        assertArrayEquals(expected, actual);
    }

    @Test
    void getAll() {
        Movie[] actual = { m1, m2, m3, m4 };
        MovieManager mm = new MovieManager(actual);
        actual = mm.getAll();
        Movie[] expected = { m4, m3, m2, m1 };
        assertArrayEquals(expected, actual);
    }

    @Test
    void getLast() {
    }
}
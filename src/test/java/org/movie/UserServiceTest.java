package org.movie;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {

    private MovieService movieService;

    @Before
    public void setup() {
        movieService = new MovieService();
        movieService.addMovie(new Movie("The Godfather", "Marlon Brando", "Crime", "1972", "9.2"));
        movieService.addMovie(new Movie("The Dark Knight", "Christian Bale", "Action", "2008", "9.0"));
    }

    @Test
    public void testSuccessfulUserRegistration() {
        User user = movieService.registerUser("ihashib2@gmail.com");

        assertNotNull(user);
        assertEquals("ihashib2@gmail.com", user.getEmail());
        assertTrue(user.getFavorites().isEmpty());
    }

    @Test
    public void testAddMovieToFavorites() {
        User user = movieService.registerUser("ihashib2@gmail.com");
        Movie movie = movieService.getMovieDetails("The Godfather");

        movieService.addMovieToFavorites("ihashib2@gmail.com", movie);

        assertTrue(user.getFavorites().contains(movie));
        assertEquals(1, user.getFavorites().size());
    }

    @Test
    public void testRemoveMovieFromFavorites() {
        User user = movieService.registerUser("ihashib2@gmail.com");
        Movie movie = movieService.getMovieDetails("The Dark Knight");
        user.addFavorite(movie);

        movieService.removeMovieFromFavorites("ihashib2@gmail.com", movie);

        assertFalse(user.getFavorites().contains(movie));
        assertTrue(user.getFavorites().isEmpty());
    }

    @Test
    public void testGetFavorites() {
        User user = movieService.registerUser("ihashib2@gmail.com");
        Movie movie1 = movieService.getMovieDetails("The Godfather");
        Movie movie2 = movieService.getMovieDetails("The Dark Knight");
        user.addFavorite(movie1);
        user.addFavorite(movie2);

        assertEquals(2, user.getFavorites().size());
        assertTrue(user.getFavorites().contains(movie1));
        assertTrue(user.getFavorites().contains(movie2));
    }

    @Test
    public void testAddDuplicateMovieToFavorites() {
        User user = movieService.registerUser("ihashib2@gmail.com");
        Movie movie = movieService.getMovieDetails("The Godfather");
        user.addFavorite(movie);
        user.addFavorite(movie); // Adding the same movie twice

        assertEquals(1, user.getFavorites().size());
    }

    @Test
    public void testRemovingNonExistentMovieFromFavorites() {
        User user = movieService.registerUser("ihashib2@gmail.com");
        Movie nonExistentMovie = new Movie("Non-Existent Movie", "", "", "", "");

        movieService.removeMovieFromFavorites("ihashib2@gmail.com", nonExistentMovie);

        assertTrue(user.getFavorites().isEmpty());
    }
}

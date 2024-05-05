package org.movie;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MovieServiceTest {

    private MovieService movieService;

    @Before
    public void setup() {
        movieService = new MovieService();
        movieService.addMovie(new Movie("The Shawshank Redemption", "Morgan Freeman", "Drama", "1994", "9.3"));
        movieService.addMovie(new Movie("The Godfather", "Marlon Brando", "Crime", "1972", "9.2"));
        movieService.addMovie(new Movie("The Dark Knight", "Christian Bale", "Action", "2008", "9.0"));
    }

    @Test
    public void testSearchMoviesByTitle() {
        List<Movie> results = movieService.searchMovies("Shawshank", "title");
        assertEquals(1, results.size());
        assertEquals("The Shawshank Redemption", results.get(0).getTitle());
    }

    @Test
    public void testSearchMoviesByCast() {
        List<Movie> results = movieService.searchMovies("Morgan Freeman", "cast");
        assertEquals(1, results.size());
        assertEquals("The Shawshank Redemption", results.get(0).getTitle());
    }

    @Test
    public void testSearchMoviesByCategory() {
        List<Movie> results = movieService.searchMovies("Action", "category");
        assertEquals(1, results.size());
        assertTrue(results.stream().anyMatch(m -> m.getTitle().equals("The Dark Knight")));
    }

    @Test
    public void testGetMovieDetails() {
        Movie movie = movieService.getMovieDetails("The Godfather");
        assertNotNull(movie);
        assertEquals("The Godfather", movie.getTitle());
        assertEquals("Marlon Brando", movie.getCast());
    }

    @Test
    public void testAddMovieToFavorites() {
        User user = movieService.registerUser("ihashib2@gmail.com");
        Movie movie = movieService.getMovieDetails("The Godfather");

        movieService.addMovieToFavorites("ihashib2@gmail.com", movie);
        assertTrue(user.getFavorites().contains(movie));
    }
}
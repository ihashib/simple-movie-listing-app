package org.movie;

import org.junit.Before;
import org.junit.Test;


public class UserServiceTest {

    private MovieService movieService;

    @Before
    public void setup() {
        movieService = new MovieService();
        // TODO: Add movies

    }

    @Test
    public void testSuccessfulUserRegistration() {
        // TODO: test user registration
    }

    @Test
    public void testAddMovieToFavorites() {
        // TODO: Test add movie to fav
    }

    @Test
    public void testRemoveMovieFromFavorites() {
        // TODO
    }

    @Test
    public void testGetFavorites() {
        // TODO
    }
}


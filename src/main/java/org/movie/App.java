package org.movie;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        MovieService movieService = new MovieService();

        movieService.addMovie(new Movie("The Shawshank Redemption", "Morgan Freeman", "Drama", "1994", "9.3"));
        movieService.addMovie(new Movie("The Godfather", "Marlon Brando", "Crime", "1972", "9.2"));
        movieService.addMovie(new Movie("The Dark Knight", "Christian Bale", "Action", "2008", "9.0"));

        // Register a user
        User user = movieService.registerUser("ihashib2@gmail.com");

        // Search for movies
        List<Movie> actionMovies = movieService.searchMovies("Crime", "category");
        System.out.println("Action Movies:");
        actionMovies.forEach(movie -> System.out.println(movie.getTitle()));

        // Add movie to favorites
        Movie favoriteMovie = movieService.getMovieDetails("The Dark Knight");
        if (favoriteMovie != null) {
            movieService.addMovieToFavorites(user.getEmail(), favoriteMovie);
        }

        // Get user's favorites
        List<Movie> favorites = movieService.getFavorites(user.getEmail());
        System.out.println("\nUser's Favorites:");
        favorites.forEach(movie -> System.out.println(movie.getTitle()));
    }
}

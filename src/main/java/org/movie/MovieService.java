package org.movie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MovieService {
    private List<Movie> movies;
    private Map<String, User> users;

    public MovieService() {
        movies = new ArrayList<>();
        users = new HashMap<>();
    }

    // Registers a new user
    public User registerUser(String email) {
        User user = new User(email);
        users.put(email, user);
        return user;
    }

    // Adds a new movie to the service
    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    // Searches for movies based on a search term and a field to search by
    public List<Movie> searchMovies(String searchTerm, String searchBy) {
        return movies.stream()
                .filter(movie -> {
                    switch (searchBy.toLowerCase()) {
                        case "title": return movie.getTitle().toLowerCase().contains(searchTerm.toLowerCase());
                        case "cast":  return movie.getCast().toLowerCase().contains(searchTerm.toLowerCase());
                        case "category": return movie.getCategory().toLowerCase().contains(searchTerm.toLowerCase());
                        default:  return false;
                    }
                })
                .collect(Collectors.toList());
    }

    // Returns details of a movie based on its title
    public Movie getMovieDetails(String title) {
        return movies.stream()
                .filter(movie -> movie.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
    }

    // Adds a movie to a user's favorite list
    public void addMovieToFavorites(String email, Movie movie) {
        User user = users.get(email);
        if (user != null) {
            user.addFavorite(movie);
        } else {
            throw new IllegalArgumentException("User not found: " + email);
        }
    }

    // Removes a movie from a user's favorite list
    public void removeMovieFromFavorites(String email, Movie movie) {
        User user = users.get(email);
        if (user != null) {
            user.removeFavorite(movie);
        }
    }

    // Retrieves a user's favorite movies
    public List<Movie> getFavorites(String email) {
        User user = users.get(email);
        return user != null ? user.getFavorites() : new ArrayList<>();
    }

    // Searches within a user's favorite movies
    public List<Movie> searchFavorites(String email, String searchTerm, String searchBy) {
        User user = users.get(email);
        if (user == null) {
            return new ArrayList<>();
        }
        return new ArrayList<>(user.getFavorites());
    }
}


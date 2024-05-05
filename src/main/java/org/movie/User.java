package org.movie;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String email;
    private List<Movie> favorites;

    public User(String email) {
        this.email = email;
        this.favorites = new ArrayList<>();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public List<Movie> getFavorites() {
        return favorites;
    }

    public void addFavorite(Movie movie) {
        if (!favorites.contains(movie)) {
            favorites.add(movie);
        }
    }

    public void removeFavorite(Movie movie) {
        favorites.remove(movie);
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", favorites=" + favorites +
                '}';
    }
}


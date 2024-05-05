package org.movie;

public class Movie {
    private String title;
    private String cast;
    private String category;
    private String releaseDate;
    private String budget;

    public Movie(String title, String cast, String category, String releaseDate, String budget) {
        this.title = title;
        this.cast = cast;
        this.category = category;
        this.releaseDate = releaseDate;
        this.budget = budget;
    }

    public String getTitle() {
        return title;
    }

    public String getCast() {
        return cast;
    }

    public String getCategory() {
        return category;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getBudget() {
        return budget;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", cast='" + cast + '\'' +
                ", category='" + category + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", budget='" + budget + '\'' +
                '}';
    }
}


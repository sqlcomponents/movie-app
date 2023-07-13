package org.example;

import org.example.model.Movie;

import java.time.LocalDateTime;

public final class MovieBuilder {
    private Short id;
    private String title;
    private String directedBy;
    private String genre;
    private Short yearOfRelease;
    private Double rating;
    private String createdBy;
    private LocalDateTime createdAt;
    private String modifiedBy;
    private LocalDateTime modifiedAt;

    private MovieBuilder() {
    }

    public static MovieBuilder aMovie() {
        return new MovieBuilder();
    }

    public MovieBuilder id(Short id) {
        this.id = id;
        return this;
    }

    public MovieBuilder title(String title) {
        this.title = title;
        return this;
    }

    public MovieBuilder directedBy(String directedBy) {
        this.directedBy = directedBy;
        return this;
    }

    public MovieBuilder genre(String genre) {
        this.genre = genre;
        return this;
    }

    public MovieBuilder yearOfRelease(Short yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
        return this;
    }

    public MovieBuilder rating(Double rating) {
        this.rating = rating;
        return this;
    }

    public MovieBuilder createdBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public MovieBuilder createdAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public MovieBuilder modifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public MovieBuilder modifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
        return this;
    }

    public Movie build() {
        Movie movie = new Movie();
        movie.setId(id);
        movie.setTitle(title);
        movie.setDirectedBy(directedBy);
        movie.setGenre(genre);
        movie.setYearOfRelease(yearOfRelease);
        movie.setRating(rating);
        movie.setCreatedBy(createdBy);
        movie.setCreatedAt(createdAt);
        movie.setModifiedBy(modifiedBy);
        movie.setModifiedAt(modifiedAt);
        return movie;
    }
}

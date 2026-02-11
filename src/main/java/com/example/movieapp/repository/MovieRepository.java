package com.example.movieapp.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.example.movieapp.dto.Movie;

@Repository
public class MovieRepository {

    private List<Movie> movies = new ArrayList<>();

    public Movie save(Movie movie) {
        movies.add(movie);
        return movie;
    }

    public Movie findById(int id) {
        return movies.stream()
                .filter(movie -> movie.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
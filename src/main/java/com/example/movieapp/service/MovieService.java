package com.example.movieapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movieapp.dto.Movie;
import com.example.movieapp.repository.MovieRepository;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public Movie addMovie(Movie movie) {

        
        if (movie.getName() == null || movie.getName().trim().isEmpty()) {
            throw new RuntimeException("Movie name is required");
        }

        if (movie.getPrice() <= 0) {
            throw new RuntimeException("Price must be greater than zero");
        }

        return movieRepository.save(movie);
    }

    public Movie getMovieById(int id) {

        Movie movie = movieRepository.findById(id);

        if (movie == null) {
            throw new RuntimeException("Movie not found with ID: " + id);
        }

        return movie;
    }
}
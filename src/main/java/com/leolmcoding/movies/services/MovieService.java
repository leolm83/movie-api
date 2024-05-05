package com.leolmcoding.movies.services;

import com.leolmcoding.movies.documents.Movie;
import com.leolmcoding.movies.repositories.MovieRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private MovieRepository movieRepository;
    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> allMovies(){
        return movieRepository.findAll();
    }
    public Optional<Movie> singleMovie(ObjectId objectId){
        return movieRepository.findById(objectId);
    }
    public Optional<Movie> singleMovieByImdb(String imdbId){
        return movieRepository.findByImdbId(imdbId);
    }
}

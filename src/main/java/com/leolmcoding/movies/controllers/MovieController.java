package com.leolmcoding.movies.controllers;

import com.leolmcoding.movies.documents.Movie;
import com.leolmcoding.movies.repositories.MovieRepository;
import com.leolmcoding.movies.services.MovieService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("movies")
public class MovieController {
    @Autowired
    private MovieService movieService;
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        return
                new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable ObjectId objectId){
        Optional<Movie> movie = movieService.singleMovie(objectId);
        if(movie.isPresent()){
            return new ResponseEntity<>(movie.get(),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new Movie(),HttpStatus.NOT_FOUND);
        }

    }
    @GetMapping("/imdb/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable String imdbId){
        Optional<Movie> movie = movieService.singleMovieByImdb(imdbId);
        if(movie.isPresent()){
            return new ResponseEntity<>(movie.get(),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new Movie(),HttpStatus.NOT_FOUND);
        }

    }

}

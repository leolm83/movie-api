package com.leolmcoding.movies.repositories;

import com.leolmcoding.movies.documents.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends MongoRepository<Movie, Object> {

    Optional<Movie> findByImdbId(String imdbId);
}

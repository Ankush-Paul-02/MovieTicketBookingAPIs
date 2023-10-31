package com.devmare.movieticketbookingapis.services;

import com.devmare.movieticketbookingapis.payloads.DTO.MovieDTO;

import java.util.List;

public interface MovieService {

    MovieDTO createMovie(MovieDTO movieDTO, Integer showId);

    MovieDTO getMovieById(Integer movieId);

    List<MovieDTO> getAllMovies();

    MovieDTO updateMovie(MovieDTO movieDTO, Integer movieId);

    void deleteMovie(Integer movieId);
}

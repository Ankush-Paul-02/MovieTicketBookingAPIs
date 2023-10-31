package com.devmare.movieticketbookingapis.controllers;

import com.devmare.movieticketbookingapis.payloads.AppApiResponse;
import com.devmare.movieticketbookingapis.payloads.DTO.MovieDTO;
import com.devmare.movieticketbookingapis.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class MovieController {

    @Autowired
    private MovieService movieService;

    //! http://localhost:8081/api/v1/show/{showId}/movie
    @PostMapping("/show/{showId}/movie")
    public ResponseEntity<MovieDTO> createMovie(
            @RequestBody MovieDTO movieDTO,
            @PathVariable Integer showId
    ) {
        MovieDTO newMovie = movieService.createMovie(movieDTO, showId);
        return new ResponseEntity<>(newMovie, HttpStatus.CREATED);
    }

    //! http://localhost:8081/api/v1/movie/{movieId}
    @GetMapping("/movie/{movieId}")
    public ResponseEntity<MovieDTO> getMovieById(
            @PathVariable Integer movieId
    ) {
        return ResponseEntity.ok(movieService.getMovieById(movieId));
    }

    //! http://localhost:8081/api/v1/movie/
    @GetMapping("/movie/")
    public ResponseEntity<List<MovieDTO>> getAllMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    //! http://localhost:8081/api/v1/movie/{movieId}
    @PutMapping("/movie/{movieId}")
    public ResponseEntity<MovieDTO> updateMovie(
            @PathVariable Integer movieId,
            @RequestBody MovieDTO movieDTO
    ) {
        return ResponseEntity.ok(movieService.updateMovie(movieDTO, movieId));
    }

    //! http://localhost:8081/api/v1/movie/{movieId}
    @DeleteMapping("/movie/{movieId}")
    public ResponseEntity<AppApiResponse> deleteMovie(@PathVariable Integer movieId) {
        movieService.deleteMovie(movieId);
        return new ResponseEntity<>(new AppApiResponse("Movie deleted successfully!", true), HttpStatus.OK);
    }
}
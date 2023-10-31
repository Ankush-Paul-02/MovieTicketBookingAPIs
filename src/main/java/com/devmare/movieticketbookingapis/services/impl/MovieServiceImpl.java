package com.devmare.movieticketbookingapis.services.impl;

import com.devmare.movieticketbookingapis.configuration.ModelMapperConfiguration;
import com.devmare.movieticketbookingapis.entities.Movie;
import com.devmare.movieticketbookingapis.entities.Show;
import com.devmare.movieticketbookingapis.exceptions.ResourceNotFoundException;
import com.devmare.movieticketbookingapis.payloads.DTO.MovieDTO;
import com.devmare.movieticketbookingapis.repositories.MovieRepository;
import com.devmare.movieticketbookingapis.repositories.ShowRepository;
import com.devmare.movieticketbookingapis.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ModelMapperConfiguration modelMapperConfiguration;

    @Override
    public MovieDTO createMovie(MovieDTO movieDTO, Integer showId) {
        Show show = showRepository.findById(showId).orElseThrow(() -> new ResourceNotFoundException("Show ", "id: ", showId));
        Movie movie = modelMapperConfiguration.modelMapper().map(movieDTO, Movie.class);
        movie.getShow().add(show);
        Movie newMovie = movieRepository.save(movie);
        return modelMapperConfiguration.modelMapper().map(newMovie, MovieDTO.class);
    }

    @Override
    public MovieDTO getMovieById(Integer movieId) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(() -> new ResourceNotFoundException("Movie ", "id: ", movieId));
        return modelMapperConfiguration.modelMapper().map(movie, MovieDTO.class);
    }

    @Override
    public List<MovieDTO> getAllMovies() {
        List<Movie> movieList = movieRepository.findAll();
        return movieList
                .stream()
                .map(
                        movie -> modelMapperConfiguration
                                .modelMapper()
                                .map(movie, MovieDTO.class)
                ).toList();
    }

    @Override
    public MovieDTO updateMovie(MovieDTO movieDTO, Integer movieId) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(() -> new ResourceNotFoundException("Movie ", "id: ", movieId));
        movie.setTitle(movieDTO.getTitle());
        movie.setDescription(movieDTO.getDescription());
        movie.setLanguage(movieDTO.getLanguage());
        movie.setCountry(movieDTO.getCountry());
        movie.setReleaseDate(movieDTO.getReleaseDate());
        Movie updatedMovie = movieRepository.save(movie);
        return modelMapperConfiguration.modelMapper().map(updatedMovie, MovieDTO.class);
    }

    @Override
    public void deleteMovie(Integer movieId) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(() -> new ResourceNotFoundException("Movie ", "id: ", movieId));
        movieRepository.delete(movie);
    }
}

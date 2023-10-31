package com.devmare.movieticketbookingapis.repositories;

import com.devmare.movieticketbookingapis.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}

package com.devmare.movieticketbookingapis.repositories;

import com.devmare.movieticketbookingapis.entities.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Integer> {
}

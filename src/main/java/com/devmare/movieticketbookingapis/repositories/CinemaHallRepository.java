package com.devmare.movieticketbookingapis.repositories;

import com.devmare.movieticketbookingapis.entities.Cinema;
import com.devmare.movieticketbookingapis.entities.CinemaHall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CinemaHallRepository extends JpaRepository<CinemaHall, Integer> {
    List<CinemaHall> findByCinema(Cinema cinema);
}

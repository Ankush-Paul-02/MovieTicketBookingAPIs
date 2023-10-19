package com.devmare.movieticketbookingapis.services;

import com.devmare.movieticketbookingapis.entities.CinemaHall;
import com.devmare.movieticketbookingapis.payloads.DTO.CinemaDTO;
import com.devmare.movieticketbookingapis.payloads.DTO.CinemaHallDTO;

import java.util.List;

public interface CinemaHallService {
    CinemaHallDTO createCinemaHall(CinemaHallDTO cinemaHall, Integer ic);

    CinemaHallDTO getCinemaHallById(Integer id);

    CinemaHallDTO updateCinemaHall(CinemaHallDTO cinemaHall, Integer id);

    void deleteCinemaHall(Integer id);

    List<CinemaHallDTO> getAllCinemasHalls();
}

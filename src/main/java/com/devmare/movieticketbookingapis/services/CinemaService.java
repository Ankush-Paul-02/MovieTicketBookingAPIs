package com.devmare.movieticketbookingapis.services;

import com.devmare.movieticketbookingapis.payloads.DTO.CinemaDTO;
import com.devmare.movieticketbookingapis.payloads.DTO.CinemaHallDTO;

import java.util.List;

public interface CinemaService {
    CinemaDTO createCinema(CinemaDTO cinemaDTO);

    CinemaDTO getCinemaById(Integer id);

    CinemaDTO updateCinema(CinemaDTO cinema, Integer id);

    void deleteCinema(Integer id);

    List<CinemaDTO> getAllCinemas();

    List<CinemaHallDTO> getAllCinemaHalls(Integer id);
}

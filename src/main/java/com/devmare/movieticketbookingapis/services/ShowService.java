package com.devmare.movieticketbookingapis.services;

import com.devmare.movieticketbookingapis.payloads.DTO.ShowDTO;

import java.util.List;

public interface ShowService {

    ShowDTO createShow(ShowDTO showDTO, Integer cinemaHallId);

    ShowDTO getShowById(Integer id);

    List<ShowDTO> getAllShows();

    ShowDTO updateShow(ShowDTO showDTO, Integer showId);

    void deleteShow(Integer showId);

}

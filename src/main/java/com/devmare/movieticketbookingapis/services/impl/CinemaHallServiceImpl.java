package com.devmare.movieticketbookingapis.services.impl;

import com.devmare.movieticketbookingapis.configuration.ModelMapperConfiguration;
import com.devmare.movieticketbookingapis.entities.Cinema;
import com.devmare.movieticketbookingapis.entities.CinemaHall;
import com.devmare.movieticketbookingapis.exceptions.ResourceNotFoundException;
import com.devmare.movieticketbookingapis.payloads.DTO.CinemaHallDTO;
import com.devmare.movieticketbookingapis.repositories.CinemaHallRepository;
import com.devmare.movieticketbookingapis.repositories.CinemaRepository;
import com.devmare.movieticketbookingapis.services.CinemaHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaHallServiceImpl implements CinemaHallService {

    @Autowired
    private CinemaHallRepository cinemaHallRepository;

    @Autowired
    private CinemaRepository cinemaRepository;

    @Autowired
    private ModelMapperConfiguration modelMapperConfiguration;

    @Override
    public CinemaHallDTO createCinemaHall(CinemaHallDTO cinemaHallDTO, Integer id) {

        Cinema cinema = cinemaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cinema ", "id: ", id));

        CinemaHall cinemaHall = modelMapperConfiguration.modelMapper().map(cinemaHallDTO, CinemaHall.class);
        cinemaHall.setCinema(cinema);
        CinemaHall createdCinemaHall = cinemaHallRepository.save(cinemaHall);
        return modelMapperConfiguration.modelMapper().map(createdCinemaHall, CinemaHallDTO.class);
    }

    @Override
    public CinemaHallDTO getCinemaHallById(Integer id) {
        return null;
    }

    @Override
    public CinemaHallDTO updateCinemaHall(CinemaHallDTO cinemaHall, Integer id) {
        return null;
    }

    @Override
    public void deleteCinemaHall(Integer id) {

    }

    @Override
    public List<CinemaHallDTO> getAllCinemasHalls() {
        return null;
    }
}

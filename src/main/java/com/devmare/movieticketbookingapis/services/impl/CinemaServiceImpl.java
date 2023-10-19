package com.devmare.movieticketbookingapis.services.impl;

import com.devmare.movieticketbookingapis.configuration.ModelMapperConfiguration;
import com.devmare.movieticketbookingapis.entities.Cinema;
import com.devmare.movieticketbookingapis.entities.CinemaHall;
import com.devmare.movieticketbookingapis.exceptions.ResourceNotFoundException;
import com.devmare.movieticketbookingapis.payloads.DTO.CinemaDTO;
import com.devmare.movieticketbookingapis.payloads.DTO.CinemaHallDTO;
import com.devmare.movieticketbookingapis.repositories.CinemaHallRepository;
import com.devmare.movieticketbookingapis.repositories.CinemaRepository;
import com.devmare.movieticketbookingapis.services.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaServiceImpl implements CinemaService {

    @Autowired
    private CinemaRepository cinemaRepository;

    @Autowired
    private CinemaHallRepository cinemaHallRepository;

    @Autowired
    private ModelMapperConfiguration modelMapperConfiguration;

    @Override
    public CinemaDTO createCinema(CinemaDTO cinemaDTO) {
        Cinema cinema = modelMapperConfiguration.modelMapper().map(cinemaDTO, Cinema.class);
        Cinema createdCinema = cinemaRepository.save(cinema);
        return modelMapperConfiguration.modelMapper().map(createdCinema, CinemaDTO.class);
    }

    @Override
    public CinemaDTO getCinemaById(Integer id) {
        Cinema cinema = cinemaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cinema ", "id: ", id));
        return modelMapperConfiguration.modelMapper().map(cinema, CinemaDTO.class);
    }

    @Override
    public List<CinemaDTO> getAllCinemas() {
        List<Cinema> cinemaList = cinemaRepository.findAll();
        return cinemaList
                .stream()
                .map(
                        cinema -> modelMapperConfiguration
                                .modelMapper()
                                .map(cinema, CinemaDTO.class)
                )
                .toList();
    }

    @Override
    public List<CinemaHallDTO> getAllCinemaHalls(Integer id) {
        Cinema cinema = cinemaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cinema ", "id: ", id));
        List<CinemaHall> cinemaHalls = cinemaHallRepository.findByCinema(cinema);
        return cinemaHalls
                .stream()
                .map(
                        hall -> modelMapperConfiguration
                                .modelMapper()
                                .map(hall, CinemaHallDTO.class)
                ).toList();
    }

    @Override
    public CinemaDTO updateCinema(CinemaDTO cinemaDTO, Integer id) {
        Cinema cinema = cinemaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cinema ", "id: ", id));
        cinema.setName(cinemaDTO.getName());
        cinema.setTotalCinemaHalls(cinemaDTO.getTotalCinemaHalls());
        Cinema updatedCinema = cinemaRepository.save(cinema);
        return modelMapperConfiguration.modelMapper().map(updatedCinema, CinemaDTO.class);
    }

    @Override
    public void deleteCinema(Integer id) {
        Cinema cinema = cinemaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cinema ", "id: ", id));
        cinemaRepository.delete(cinema);
    }
}

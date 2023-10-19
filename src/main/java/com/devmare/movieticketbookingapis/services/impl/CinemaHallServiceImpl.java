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
        CinemaHall cinemaHall = cinemaHallRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cinema hall ", "id: ", id));
        return modelMapperConfiguration.modelMapper().map(cinemaHall, CinemaHallDTO.class);
    }

    @Override
    public List<CinemaHallDTO> getAllCinemasHalls() {
        List<CinemaHall> cinemaHallList = cinemaHallRepository.findAll();
        return cinemaHallList
                .stream()
                .map(
                        hall -> modelMapperConfiguration
                                .modelMapper()
                                .map(hall, CinemaHallDTO.class)
                ).toList();
    }

    @Override
    public CinemaHallDTO updateCinemaHall(CinemaHallDTO cinemaHallDTO, Integer id) {
        CinemaHall cinemaHall = cinemaHallRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cinema hall ", "id: ", id));
        cinemaHall.setName(cinemaHallDTO.getName());
        cinemaHall.setTotalSeats(cinemaHallDTO.getTotalSeats());
        CinemaHall updatedCinemaHall = cinemaHallRepository.save(cinemaHall);
        return modelMapperConfiguration.modelMapper().map(updatedCinemaHall, CinemaHallDTO.class);
    }

    @Override
    public void deleteCinemaHall(Integer id) {
        CinemaHall cinemaHall = cinemaHallRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cinema hall ", "id: ", id));
        cinemaHallRepository.delete(cinemaHall);
    }
}

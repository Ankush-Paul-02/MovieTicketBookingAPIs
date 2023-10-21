package com.devmare.movieticketbookingapis.services.impl;

import com.devmare.movieticketbookingapis.configuration.ModelMapperConfiguration;
import com.devmare.movieticketbookingapis.entities.CinemaHall;
import com.devmare.movieticketbookingapis.entities.Show;
import com.devmare.movieticketbookingapis.exceptions.ResourceNotFoundException;
import com.devmare.movieticketbookingapis.payloads.DTO.ShowDTO;
import com.devmare.movieticketbookingapis.repositories.CinemaHallRepository;
import com.devmare.movieticketbookingapis.repositories.ShowRepository;
import com.devmare.movieticketbookingapis.services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ShowServiceImpl implements ShowService {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private CinemaHallRepository cinemaHallRepository;

    @Autowired
    private ModelMapperConfiguration modelMapperConfiguration;

    @Override
    public ShowDTO createShow(ShowDTO showDTO, Integer cinemaHallId) {
        CinemaHall cinemaHall = cinemaHallRepository.findById(cinemaHallId).orElseThrow(() -> new ResourceNotFoundException("Cinema hall ", "id: ", cinemaHallId));
        Show show = modelMapperConfiguration.modelMapper().map(showDTO, Show.class);
        show.setCreatedOn(new Date());
        show.setCinemaHall(cinemaHall);
        Show newShow = showRepository.save(show);
        return modelMapperConfiguration.modelMapper().map(newShow, ShowDTO.class);
    }

    @Override
    public ShowDTO getShowById(Integer showId) {
        Show show = showRepository.findById(showId).orElseThrow(() -> new ResourceNotFoundException("Show ", "id: ", showId));
        return modelMapperConfiguration.modelMapper().map(show, ShowDTO.class);
    }

    @Override
    public List<ShowDTO> getAllShows() {
        List<Show> showList = showRepository.findAll();
        return showList
                .stream()
                .map(
                        show -> modelMapperConfiguration
                                .modelMapper()
                                .map(show, ShowDTO.class)
                ).toList();
    }

    @Override
    public ShowDTO updateShow(ShowDTO showDTO, Integer showId) {
        Show show = showRepository.findById(showId).orElseThrow(() -> new ResourceNotFoundException("Show ", "id: ", showId));
        show.setStartTime(showDTO.getStartTime());
        show.setEndTime(showDTO.getEndTime());
        Show updateShow = showRepository.save(show);
        return modelMapperConfiguration.modelMapper().map(updateShow, ShowDTO.class);
    }

    @Override
    public void deleteShow(Integer showId) {
        Show show = showRepository.findById(showId).orElseThrow(() -> new ResourceNotFoundException("Show ", "id: ", showId));
        showRepository.delete(show);
    }
}

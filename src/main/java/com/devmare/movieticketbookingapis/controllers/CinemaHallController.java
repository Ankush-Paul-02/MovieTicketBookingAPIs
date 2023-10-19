package com.devmare.movieticketbookingapis.controllers;

import com.devmare.movieticketbookingapis.payloads.DTO.CinemaHallDTO;
import com.devmare.movieticketbookingapis.services.CinemaHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
public class CinemaHallController {

    @Autowired
    private CinemaHallService cinemaHallService;

    //! http://localhost:8081/api/v1/cinema/{cinemaId}/cinemaHall
    @PostMapping("/cinema/{cinemaId}/cinemaHall")
    public ResponseEntity<CinemaHallDTO> createCinemaHall(
            @RequestBody CinemaHallDTO cinemaHallDTO,
            @PathVariable Integer cinemaId
    ) {
        CinemaHallDTO newCinemaHallDTO = cinemaHallService.createCinemaHall(cinemaHallDTO, cinemaId);
        return new ResponseEntity<>(newCinemaHallDTO, HttpStatus.CREATED);
    }

}

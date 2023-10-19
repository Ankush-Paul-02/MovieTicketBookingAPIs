package com.devmare.movieticketbookingapis.controllers;

import com.devmare.movieticketbookingapis.payloads.AppApiResponse;
import com.devmare.movieticketbookingapis.payloads.DTO.CinemaHallDTO;
import com.devmare.movieticketbookingapis.services.CinemaHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    //! http://localhost:8081/api/v1/cinemaHall/{cinemaHallId}
    @GetMapping("/cinemaHall/{cinemaHallId}")
    public ResponseEntity<CinemaHallDTO> getCinemaHallById(
            @PathVariable Integer cinemaHallId
    ) {
        return ResponseEntity.ok(cinemaHallService.getCinemaHallById(cinemaHallId));
    }

    //! http://localhost:8081/api/v1/cinemaHall/
    @GetMapping("/cinemaHall/")
    public ResponseEntity<List<CinemaHallDTO>> getAllCinemaHall() {
        return ResponseEntity.ok(cinemaHallService.getAllCinemasHalls());
    }

    //! http://localhost:8081/api/v1/cinemaHall/{cinemaHallId}
    @PutMapping("/cinemaHall/{cinemaHallId}")
    public ResponseEntity<CinemaHallDTO> updateCinemaHall(
            @RequestBody CinemaHallDTO cinemaHallDTO,
            @PathVariable Integer cinemaHallId
    ) {
        return ResponseEntity.ok(cinemaHallService.updateCinemaHall(cinemaHallDTO, cinemaHallId));
    }

    //! http://localhost:8081/api/v1/cinemaHall/{cinemaHallId}
    @DeleteMapping("/cinemaHall/{cinemaHallId}")
    public ResponseEntity<AppApiResponse> deleteCinemaHall(
            @PathVariable Integer cinemaHallId
    ) {
        cinemaHallService.deleteCinemaHall(cinemaHallId);
        return new ResponseEntity<>(new AppApiResponse("Cinema hall deleted successfully!", true), HttpStatus.OK);
    }
}

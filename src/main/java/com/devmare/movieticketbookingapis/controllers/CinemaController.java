package com.devmare.movieticketbookingapis.controllers;

import com.devmare.movieticketbookingapis.payloads.AppApiResponse;
import com.devmare.movieticketbookingapis.payloads.DTO.CinemaDTO;
import com.devmare.movieticketbookingapis.payloads.DTO.CinemaHallDTO;
import com.devmare.movieticketbookingapis.services.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;


    //! http://localhost:8081/api/v1/cinema/
    @PostMapping("/cinema/")
    public ResponseEntity<CinemaDTO> createCinema(
            @RequestBody CinemaDTO cinemaDTO
    ) {
        CinemaDTO newCinemaDTO = cinemaService.createCinema(cinemaDTO);
        return new ResponseEntity<>(newCinemaDTO, HttpStatus.CREATED);
    }

    //! http://localhost:8081/api/v1/cinema/{cinemaId}
    @GetMapping("/cinema/{cinemaId}")
    public ResponseEntity<CinemaDTO> getCinemaById(
            @PathVariable Integer cinemaId
    ) {
        return ResponseEntity.ok(cinemaService.getCinemaById(cinemaId));
    }

    //! http://localhost:8081/api/v1/cinema/
    @GetMapping("/cinema/")
    public ResponseEntity<List<CinemaDTO>> getAllCinemas() {
        return ResponseEntity.ok(cinemaService.getAllCinemas());
    }

    //! http://localhost:8081/api/v1/cinema/{cinemaId}/cinemaHalls
    @GetMapping("/cinema/{cinemaId}/cinemaHalls")
    public ResponseEntity<List<CinemaHallDTO>> getAllCinemasHalls(
            @PathVariable Integer cinemaId
    ) {
        List<CinemaHallDTO> cinemaHalls = cinemaService.getAllCinemaHalls(cinemaId);
        return new ResponseEntity<>(cinemaHalls, HttpStatus.OK);
    }

    //! http://localhost:8081/api/v1/cinema/{cinemaId}
    @PutMapping("/cinema/{cinemaId}")
    public ResponseEntity<CinemaDTO> updateCinema(
            @RequestBody CinemaDTO cinemaDTO,
            @PathVariable Integer cinemaId
    ) {
        return ResponseEntity.ok(cinemaService.updateCinema(cinemaDTO, cinemaId));
    }

    //! http://localhost:8081/api/v1/cinema/{cinemaId}
    @DeleteMapping("/cinema/{cinemaId}")
    public ResponseEntity<AppApiResponse> deleteCinema(
            @PathVariable Integer cinemaId
    ) {
        cinemaService.deleteCinema(cinemaId);
        return new ResponseEntity<>(new AppApiResponse("Cinema deleted successfully!", true), HttpStatus.OK);
    }
}

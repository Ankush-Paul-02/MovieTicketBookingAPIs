package com.devmare.movieticketbookingapis.controllers;

import com.devmare.movieticketbookingapis.payloads.AppApiResponse;
import com.devmare.movieticketbookingapis.payloads.DTO.ShowDTO;
import com.devmare.movieticketbookingapis.services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class ShowController {

    @Autowired
    private ShowService showService;

    //! http://localhost:8081/api/v1/cinemaHall/{cinemaHallId}/show
    @PostMapping("/cinemaHall/{cinemaHallId}/show")
    public ResponseEntity<ShowDTO> createShow(
            @RequestBody ShowDTO showDTO,
            @PathVariable Integer cinemaHallId
    ) {
        ShowDTO newShowDTO = showService.createShow(showDTO, cinemaHallId);
        return new ResponseEntity<>(newShowDTO, HttpStatus.CREATED);
    }

    //! http://localhost:8081/api/v1/show/{showId}
    @GetMapping("/show/{showId}")
    public ResponseEntity<ShowDTO> getShowById(@PathVariable Integer showId) {
        return ResponseEntity.ok(showService.getShowById(showId));
    }

    //! http://localhost:8081/api/v1/show/
    @GetMapping("/show/")
    public ResponseEntity<List<ShowDTO>> getAllShow() {
        return ResponseEntity.ok(showService.getAllShows());
    }

    //! http://localhost:8081/api/v1/show/{showId}
    @PutMapping("/show/{showId}")
    public ResponseEntity<ShowDTO> updateShow(
            @RequestBody ShowDTO showDTO,
            @PathVariable Integer showId
    ) {
        return ResponseEntity.ok(showService.updateShow(showDTO, showId));
    }

    //! http://localhost:8081/api/v1/show/{showId}
    @DeleteMapping("/show/{showId}")
    public ResponseEntity<AppApiResponse> deleteShow(
            @PathVariable Integer showId
    ) {
        showService.deleteShow(showId);
        return new ResponseEntity<>(new AppApiResponse("Show deleted successfully!", true), HttpStatus.OK);
    }
}

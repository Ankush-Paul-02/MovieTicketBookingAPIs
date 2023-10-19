package com.devmare.movieticketbookingapis.payloads.DTO;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CinemaDTO {

    private Integer id;

    @NotEmpty
    private String name;

    @NotEmpty
    private Integer totalCinemaHalls;

    private List<CinemaHallDTO> cinemaHallDTOs;
}

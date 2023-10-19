package com.devmare.movieticketbookingapis.payloads.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CinemaHallDTO {

    private Integer cinemaHallId;

    @NotNull
    private String name;

    @NotNull
    private Integer totalSeats;
}

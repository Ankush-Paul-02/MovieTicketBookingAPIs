package com.devmare.movieticketbookingapis.payloads.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {

    private Integer movieId;

    private String title;
    private String description;
    private String language;
    private Date releaseDate;
    private String country;
}

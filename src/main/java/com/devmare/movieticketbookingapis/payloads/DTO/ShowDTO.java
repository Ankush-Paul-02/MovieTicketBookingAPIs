package com.devmare.movieticketbookingapis.payloads.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShowDTO {

    private Integer showId;

    private Date createdDate;

    @NotNull
    private Date startTime;
    @NotNull
    private Date endTime;
}

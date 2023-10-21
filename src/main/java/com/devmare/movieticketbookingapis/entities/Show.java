package com.devmare.movieticketbookingapis.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "shows")
@Data
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer showId;

    private Date createdOn;
    private Date startTime;
    private Date endTime;

    @ManyToOne
    @JoinColumn(name = "cinemaHallId")
    private CinemaHall cinemaHall;
}

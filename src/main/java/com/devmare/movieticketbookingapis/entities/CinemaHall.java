package com.devmare.movieticketbookingapis.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cinemaHall")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CinemaHall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cinemaHallId;

    private String name;
    private Integer totalSeats;

    @ManyToOne
    @JoinColumn(name = "id")
    private Cinema cinema;
}

package com.devmare.movieticketbookingapis.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "movies")
@Data
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movieId;

    private String title;
    private String description;
    private String language;
    private Date releaseDate;
    private String country;

    @ManyToMany
    @JoinTable(
            name = "movie_show",
            joinColumns = @JoinColumn(name = "movieId"),
            inverseJoinColumns = @JoinColumn(name = "showId")
    )
    private List<Show> show = new ArrayList<>();
}

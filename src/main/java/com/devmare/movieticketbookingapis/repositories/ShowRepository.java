package com.devmare.movieticketbookingapis.repositories;

import com.devmare.movieticketbookingapis.entities.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<Show, Integer> {
}

package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Movie;
import java.util.Optional;


@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
  Optional<Movie> findByNombre(String nombre);

  
}

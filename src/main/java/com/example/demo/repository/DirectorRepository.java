package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Director;
import java.util.Optional;


@Repository
public interface DirectorRepository extends JpaRepository<Director, Long> {
  Optional<Director> findByname(String nombre);

  
}

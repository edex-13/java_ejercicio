package com.example.demo.dto.Director;

import java.util.List;
import java.util.Optional;

import com.example.demo.dto.Movie.MovieDTO;

public record DirectorDTO(
  String nombre,

  List<MovieDTO> movies


) {
}
package com.example.demo.dto;

import java.util.List;

import com.example.demo.model.Movie;

public record UserDTO(
  String name,
  String email,
  int edad ,
  List<Movie> movies
) {}
package com.example.demo.dto;

import java.util.List;

import com.example.demo.model.Movie;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record UserPrivateDTO(

  @NotNull
  @NotBlank
  @Size(min = 3 , max = 20)
  String name,
  
  
  @NotNull
  @NotBlank
  @Email
  String email,
  
  @Positive
  @Max(100)
  int edad ,


  List<MoviePrivateDTO> movies

) {}
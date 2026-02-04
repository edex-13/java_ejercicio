package com.example.demo.dto;



import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MoviePrivateDTO(

  Long id,

  @NotNull
  @NotBlank
  String nombre,
  
  
  @NotNull
  @NotBlank
  int duracion

) {}
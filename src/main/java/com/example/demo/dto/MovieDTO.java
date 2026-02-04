package com.example.demo.dto;



import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MovieDTO(

  @NotNull
  @NotBlank
  String nombre,
  
  
  @NotNull
  @Min(value = 1, message = "La duración debe ser al menos de 1 minuto")
  int duracion

) {}
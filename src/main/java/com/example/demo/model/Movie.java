package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.List;


@Entity
@Table(name = "movie")
public class Movie {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id; 

  private int duracion;

  @Column(nullable = false , unique = true , length = 100)
  private String nombre;

  @ManyToMany(mappedBy="movies")
  private List<User> user;


  @ManyToOne
  @JoinColumn(name = "director_nombre")
  private Director director;

  
  public Movie(int duracion, String nombre) {
    this.duracion = duracion;
    this.nombre = nombre;
  }

  public Movie() {
  }
  
  public int getDuracion() {
    return duracion;
  }
  public void setDuracion(int duracion) {
    this.duracion = duracion;
  }
  public String getNombre() {
    return nombre;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  

  
}

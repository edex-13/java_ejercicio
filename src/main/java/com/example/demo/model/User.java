package com.example.demo.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false, unique = true)
  private String email;

  private int edad;


  @ManyToMany
  @JoinTable(
    name = "usuarios_peliculas_favoritas",
    joinColumns =  @JoinColumn(name = "usuario_id"),
    inverseJoinColumns = @JoinColumn(name = "movie_id" )
  )
  private List<Movie> movies;

  

  protected User() {
  }

  // constructor útil (opcional pero recomendado)
  public User(String name, String email, int edad) {
    this.name = name;
    this.email = email;
    this.edad = edad;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public int getEdad() {
    return edad;
  }

  public void setEdad(int edad) {
    this.edad = edad;
  }

  public List<Movie> getMovies() {
    return movies;
  }

  public void setMovies(List<Movie> movies) {
    this.movies = movies;
  }










}

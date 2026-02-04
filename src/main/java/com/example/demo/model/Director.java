package com.example.demo.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "director")
public class Director {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;


  @Column(nullable = false  , unique = true)
  private String name;


  @OneToMany(mappedBy = "director")
  private List<Movie> movies;


  public Director(String name) {
    this.name = name;
  }


  public Director() {
  }


  public Long getId() {
    return id;
  }


  public void setId(Long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public List<Movie> getMovies() {
    return movies;
  }


  public void setMovies(List<Movie> movies) {
    this.movies = movies;
  }
  
}

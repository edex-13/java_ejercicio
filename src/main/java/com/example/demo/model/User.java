package com.example.demo.model;

import java.util.List;


public class User {
  private String ID ;

  private String name ;
  private String email ;
  private int edad ;
  private List<Movie> movies ;

  public User(String ID ,String name, String email, int edad, List<Movie> movies) {
    this.ID = ID;
    this.name = name;
    this.email = email;
    this.edad = edad;
    this.movies = movies;
  }

  public String getID() {
    return ID;
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
  public List<Movie> getmovies() {
    return movies;
  }
  public void setmovies(List<Movie> movies) {
    this.movies = movies;
  }
  
}

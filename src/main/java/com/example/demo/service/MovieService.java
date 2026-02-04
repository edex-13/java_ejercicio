package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

import com.example.demo.dto.MovieDTO;
import com.example.demo.dto.MoviePrivateDTO;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.MovieRepository;
import com.example.demo.model.Movie;

@Service
public class MovieService {

 private final MovieRepository movieRepository;

  public MovieService(MovieRepository movieRepository){
    this.movieRepository = movieRepository;
    
 
  }

  public MovieDTO find_movie_by_id(Long id){

    Movie movie = this.movieRepository.findById(id).orElseThrow(() ->
                new UserNotFoundException("Usuario con id " + id + " no encontrado")
            );

    return new MovieDTO(movie.getNombre() , movie.getDuracion());


  }
  
  public List<MoviePrivateDTO> getMovies (){

    List<Movie> movies = this.movieRepository.findAll();
    return movies.stream()
      .map(movie -> new MoviePrivateDTO(movie.getId() , movie.getNombre()  , movie.getDuracion()))
      .toList();
  }

  public MovieDTO getMovieByname( String name){

    Movie movie =movieRepository.findByNombre(name)
        .orElseThrow(() ->
            new UserNotFoundException("Usuario con nombre " + name + " no encontrado")
        );

    return new MovieDTO(movie.getNombre() , movie.getDuracion());

  }

  public MovieDTO create(String name , int duracion ){

    Movie movie = new Movie(duracion, name);
    Movie movieGuardada = this.movieRepository.save(movie);
    return new MovieDTO(movieGuardada.getNombre(), movieGuardada.getDuracion());

  }

  public MovieDTO update (Long id , String name , int duracion ){
    Movie movie = movieRepository.findById(id)
        .orElseThrow(() ->
            new UserNotFoundException("Usuario con id " + id + " no encontrado")
        );

    // validar email único (solo si cambia)
    movieRepository.findByNombre(name)
        .filter(u -> !u.getId().equals(id))
        .ifPresent(u -> {
            throw new IllegalArgumentException("El nombre ya está en uso");
        });

    movie.setNombre(name);
    movie.setDuracion(duracion);

     Movie moviewActualizada = movieRepository.save(movie);

     return new MovieDTO(moviewActualizada.getNombre(), moviewActualizada.getDuracion());

  } 

  
  public void delate(Long id){

    movieRepository.findById(id).orElseThrow(() ->
            new UserNotFoundException("Usuario con id " + id + " no encontrado")
        );

      

    this.delate(id);
  }
}

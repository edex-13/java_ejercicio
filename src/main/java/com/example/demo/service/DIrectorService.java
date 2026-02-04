package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.dto.Director.DirectorDTO;
import com.example.demo.dto.Movie.MovieDTO;
import com.example.demo.model.Director;
import com.example.demo.repository.DirectorRepository;

@Service
public class DIrectorService {

  private final DirectorRepository directorRepository;

  public DIrectorService(DirectorRepository directorRepository) {
    this.directorRepository = directorRepository;
  }


  public List<DirectorDTO> GetDirectores(){



    List<Director> directores = this.directorRepository.findAll(); 

    List<DirectorDTO> directoresDTOs = directores.stream()
      .map( director -> {
        List<MovieDTO> moviesDtos = Optional.ofNullable(director.getMovies())
          .orElse(List.of())
          .stream()
          .map(movie -> new MovieDTO(movie.getNombre(), movie.getDuracion())).toList();

          return new DirectorDTO( director.getName() , moviesDtos);
      }).toList();

    return directoresDTOs;
  } 


  public DirectorDTO createDirector(DirectorDTO director){
    Director new_director = new Director(director.nombre());
    return new DirectorDTO(new_director.getName() , null);
  }
 
  
  
}

package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.MovieDTO;
import com.example.demo.dto.MoviePrivateDTO;
import com.example.demo.dto.SuccessResponse;
import com.example.demo.dto.SuccessResponseNotData;
import com.example.demo.dto.UserDTO;
import com.example.demo.service.MovieService;

import jakarta.validation.Valid;

import com.example.demo.model.Movie;
import com.example.demo.model.User;

@RestController
@RequestMapping("/movies")
public class MovieController {
  
  private final  MovieService moviesService;

  public MovieController(MovieService moviesService) {
    this.moviesService = moviesService;
  }

  @GetMapping
  public ResponseEntity<SuccessResponse<List<MoviePrivateDTO>>> getUsers()
  {
    List<MoviePrivateDTO> movies = moviesService.getMovies();
    SuccessResponse<List<MoviePrivateDTO>> response = new SuccessResponse<>(HttpStatus.OK.value() ,  "Lista de usuarios obtenida con exito", movies);
    return new ResponseEntity<>(response, HttpStatus.OK );
  }


  @GetMapping("/{name}")
  public ResponseEntity<SuccessResponse<MovieDTO>> getUser(@PathVariable String name)
  {
    MovieDTO movie = moviesService.getMovieByname(name);

    SuccessResponse<MovieDTO> response = 
      new SuccessResponse<>(HttpStatus.OK.value(), "usuario obtenido con exitor", movie);


    return new ResponseEntity<>(response , HttpStatus.OK );
  }

  @PostMapping("/")
  public ResponseEntity<SuccessResponse<MovieDTO>> createUser(@Valid @RequestBody MovieDTO request){

    MovieDTO user = moviesService.create(request.nombre() , request.duracion());

    SuccessResponse<MovieDTO> response = 
      new SuccessResponse<MovieDTO>(HttpStatus.CREATED.value(), "usuario creado con exito", user);


    return new ResponseEntity<>(response , HttpStatus.CREATED);
  }


  @PutMapping("/{index}")
  public ResponseEntity<SuccessResponse<MovieDTO>> updateUser(@PathVariable Long index ,@Valid @RequestBody MovieDTO request){

    MovieDTO movie =  moviesService.update(index , request.nombre() , request.duracion()) ;

    
    SuccessResponse<MovieDTO> response = 
      new SuccessResponse<MovieDTO>(HttpStatus.CREATED.value(), "usuario actualiado con exito", movie);
   
    return  new ResponseEntity<>(response , HttpStatus.OK);
  }

  @DeleteMapping("/{index}")
  public ResponseEntity<SuccessResponseNotData> delateUser(@PathVariable Long id){
    moviesService.delate(id);

    SuccessResponseNotData response = 
      new SuccessResponseNotData(HttpStatus.NO_CONTENT.value(), "usuario eliminado con exito");
    return new ResponseEntity<>(response , HttpStatus.NO_CONTENT);

  }
}

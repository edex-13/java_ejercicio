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

import com.example.demo.dto.SuccessResponse;
import com.example.demo.dto.SuccessResponseNotData;
import com.example.demo.dto.Director.DirectorCreateDTO;
import com.example.demo.dto.Director.DirectorDTO;
import com.example.demo.dto.Movie.MovieDTO;
import com.example.demo.dto.Movie.MoviePrivateDTO;
import com.example.demo.dto.User.UserDTO;
import com.example.demo.service.DIrectorService;
import com.example.demo.service.MovieService;

import jakarta.validation.Valid;

import com.example.demo.model.Movie;
import com.example.demo.model.User;

@RestController
@RequestMapping("/dicrector")
public class DirectorController {
  
  private final  DIrectorService directorService;

  public DirectorController(DIrectorService directorService) {
    this.directorService = directorService;
  }

  @GetMapping
  public ResponseEntity<SuccessResponse<List<DirectorDTO>>> getUsers()
  {
    List<DirectorDTO> director = directorService.GetDirectores();
    SuccessResponse<List<DirectorDTO>> response = new SuccessResponse<>(HttpStatus.OK.value() ,  "Lista de usuarios obtenida con exito", director);
    return new ResponseEntity<>(response, HttpStatus.OK );
  }




  @PostMapping("/")
  public ResponseEntity<SuccessResponse<DirectorDTO>> createUser(@Valid @RequestBody DirectorCreateDTO request){

    DirectorDTO user = directorService.createDirector(request);

    SuccessResponse<DirectorDTO> response = 
      new SuccessResponse<DirectorDTO>(HttpStatus.CREATED.value(), "usuario creado con exito", user);


    return new ResponseEntity<>(response , HttpStatus.CREATED);
  }

  
}

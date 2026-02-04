package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties.Apiversion.Use;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Movie.MoviePrivateDTO;
import com.example.demo.dto.User.UserPrivateDTO;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.MovieRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.MovieRepository;
import com.example.demo.model.Movie;

@Service
public class UserService {

 private final UserRepository userRepository;
 private final MovieRepository movieRepository;

  public UserService(UserRepository userRepository , MovieRepository movieRepository){
    this.userRepository = userRepository;
    this.movieRepository = movieRepository;
    
 
  }

  public User find_user_by_id(Long id){

    return this.userRepository.findById(id).orElseThrow(() ->
                new UserNotFoundException("Usuario con id " + id + " no encontrado")
            );


  }
  
  public List<User> getUsers (){

    return this.userRepository.findAll();
  }

  public User getUserByname( String name){

    return userRepository.findByName(name)
        .orElseThrow(() ->
            new UserNotFoundException("Usuario con nombre " + name + " no encontrado")
        );

  }

  public User create(String name , String email , int age ){

    User user = new User(name, email, age);
    return this.userRepository.save(user);

  }

  public UserPrivateDTO add_movie_to_favorite(Long user_id , Long movie_id){


    User user = userRepository.findById(user_id)
      .orElseThrow(()->
        new UserNotFoundException("Usuario con id " + user_id + " no encontrado")
      );


    Movie movie = movieRepository.findById(movie_id)
      .orElseThrow(()->
        new UserNotFoundException("Moview con id " + user_id + " no encontrado")
      );

    if (!user.getMovies().contains(movie)) {
      user.getMovies().add(movie);
      
    }

    User userActualizado = userRepository.save(user);


    List<MoviePrivateDTO> moviePrivate = userActualizado.getMovies().stream()
      .map(movie_v1 -> new MoviePrivateDTO(movie_v1.getId() , movie_v1.getNombre()  ,movie_v1.getDuracion()))
      .toList();


    UserPrivateDTO userResponse = new UserPrivateDTO(userActualizado.getName(), user.getEmail() , user.getEdad() , moviePrivate );

    return userResponse;


  }

  public User update (Long id , String name , int edad , String email ){
    User user = userRepository.findById(id)
        .orElseThrow(() ->
            new UserNotFoundException("Usuario con id " + id + " no encontrado")
        );

    // validar email único (solo si cambia)
    userRepository.findByEmail(email)
        .filter(u -> !u.getId().equals(id))
        .ifPresent(u -> {
            throw new IllegalArgumentException("El email ya está en uso");
        });

    user.setName(name);
    user.setEmail(email);
    user.setEdad(edad);

    return userRepository.save(user);
  } 

  
  public void delate(Long id){

    userRepository.findById(id).orElseThrow(() ->
            new UserNotFoundException("Usuario con id " + id + " no encontrado")
        );

      

    this.delate(id);
  }
}

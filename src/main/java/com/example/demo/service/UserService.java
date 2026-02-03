package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.model.Movie;

@Service
public class UserService {

 private final UserRepository userRepository;

  public UserService(UserRepository userRepository){
    this.userRepository = userRepository;
    
 
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

  public User create(String name , String email , int age , List<Movie> movies){

    User user = new User(name, email, age);
    return this.userRepository.save(user);

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

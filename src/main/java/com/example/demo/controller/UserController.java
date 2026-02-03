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
import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;

import jakarta.validation.Valid;

import com.example.demo.model.User;

@RestController
@RequestMapping("/users")
public class UserController {
  
  private final  UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  public ResponseEntity<SuccessResponse<List<User>>> getUsers()
  {
    List<User> user = userService.getUsers();
    SuccessResponse<List<User>> response = new SuccessResponse<>(HttpStatus.OK.value() ,  "Lista de usuarios obtenida con exito", user);
    return new ResponseEntity<>(response, HttpStatus.OK );
  }


  @GetMapping("/{name}")
  public ResponseEntity<SuccessResponse<User>> getUser(@PathVariable String name)
  {
    User user = userService.getUserByname(name);

    SuccessResponse<User> response = 
      new SuccessResponse<>(HttpStatus.OK.value(), "usuario obtenido con exitor", user);


    return new ResponseEntity<>(response , HttpStatus.OK );
  }

  @PostMapping("/")
  public ResponseEntity<SuccessResponse<User>> createUser(@Valid @RequestBody UserDTO request){

    User user = userService.create(request.name() , request.email() , request.edad() , request.movies());

    SuccessResponse<User> response = 
      new SuccessResponse<User>(HttpStatus.CREATED.value(), "usuario creado con exito", user);


    return new ResponseEntity<>(response , HttpStatus.CREATED);
  }

  @PutMapping("/{index}")
  public ResponseEntity<SuccessResponse<User>> updateUser(@PathVariable Long index ,@Valid @RequestBody UserDTO request){

    User user =  userService.update(index , request.name() , request.edad() , request.email() ) ;

    
    SuccessResponse<User> response = 
      new SuccessResponse<User>(HttpStatus.CREATED.value(), "usuario actualiado con exito", user);
   
    return  new ResponseEntity<>(response , HttpStatus.OK);
  }

  @DeleteMapping("/{index}")
  public ResponseEntity<SuccessResponseNotData> delateUser(@PathVariable Long id){
    userService.delate(id);

    SuccessResponseNotData response = 
      new SuccessResponseNotData(HttpStatus.NO_CONTENT.value(), "usuario eliminado con exito");
    return new ResponseEntity<>(response , HttpStatus.NO_CONTENT);

  }
}

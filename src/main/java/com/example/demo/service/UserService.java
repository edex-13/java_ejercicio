package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.model.Movie;

@Service
public class UserService {

  private List<User> users = new ArrayList<>();


  public UserService(){
    
    String ID_1 = UUID.randomUUID().toString();

    users.add(new User(
      ID_1,
      "Cristian",
      "cfsanchez1107@gmail.com",
      24,
      null
    ));

    String ID_2 = UUID.randomUUID().toString();

    users.add(new User(
      ID_2,
      "Felipe",
      "ederson12f@gmail.com",
      19,
      null
    ));
    String ID_3 = UUID.randomUUID().toString();

    users.add(new User(
      ID_3,
      "Angie",
      "angie@gmail.com",
      32,
      null
    ));
 
  }

  public User find_user_by_id(String ID){

    for (User user : users){
      if (user.getID().equals(ID)){
        return user;
      }
    }

    throw new UserNotFoundException("usuario con el id "+ ID + " no encontrado ");

  }
  
  public List<User> getUsers (){

    return this.users;
  }

  public User getUserByname( String name){

    for (User user : users){
      if (user.getName().equals(name)){
        return user;
      }
    }
    throw new UserNotFoundException("usuario con el nombre "+ name + " no encontrado ");

  }

  public User create(String name , String email , int age , List<Movie> movies){
    String ID = UUID.randomUUID().toString();
    User user = new User(
      ID,
      name,
      email,
      age,
      movies
    );
    users.add(user);

    return user;
  }

  public User update (String ID , String name , int edad , String email ){
    User user = this.find_user_by_id(ID);
    user.setName(name);
    user.setEdad(edad);
    user.setEmail(email);
    
    return user;
  } 

  
  public int delate(int index){
    users.remove(index);

    return index;
  }
}

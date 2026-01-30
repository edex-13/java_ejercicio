package com.example.demo.dto;

public class SuccessResponseNotData {
  private int status;
  private String message;

  public SuccessResponseNotData(int status , String message ){
    this.status = status;
    this.message = message;
  }

  public int getStatus() {
    return status;
  }
  public String getMessage() {
    return message;
  }


  

}

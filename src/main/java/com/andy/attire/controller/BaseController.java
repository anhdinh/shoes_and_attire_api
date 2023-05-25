package com.andy.attire.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class BaseController{
    public  <T> ResponseEntity<T> response(T t) {
         return new ResponseEntity<T>(t,HttpStatus.OK);
    }

}

package com.example.demo.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResponseStatusNotFoundException extends Exception{

    public ResponseStatusNotFoundException(String message) {
        super(message);
    }
}

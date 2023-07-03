package com.example.demo.exeptions;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ResponseStatusException extends Exception{

    public ResponseStatusException(String message) {
        super(message);
    }
}

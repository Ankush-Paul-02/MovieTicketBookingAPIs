package com.devmare.movieticketbookingapis.exceptions;

public class APIException extends RuntimeException {

    APIException() {
    }

    APIException(String message) {
        super(message);
    }
}

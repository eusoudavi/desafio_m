package com.mirante.avaliacao.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
public class ApiError {

    private HttpStatus status;
    private List<String> errors;
    private String message;

    public ApiError() {
    }

    public ApiError(HttpStatus status, List<String> errors, String message) {
        super();
        this.status = status;
        this.errors = errors;
        this.message = message;
    }

    public ApiError(HttpStatus status, String error, String message) {
        super();
        this.status = status;
        this.errors = List.of(error);
        this.message = message;
    }

}

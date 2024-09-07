package com.mirante.avaliacao.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler({Exception.class})
    public ResponseEntity<?> handlerAll(Exception ex, WebRequest request) {
        var apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex.getMessage());

        return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());
    }

    @ExceptionHandler(BuscaRepositoryException.class)
    public ResponseEntity<?> paramHandler(Exception ex, WebRequest request) {
        var apiError = new ApiError(HttpStatus.valueOf(406), ex.getMessage(), "FALHA NOS PARÂMETROS FORNECIDOS");
        return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());
    }

}

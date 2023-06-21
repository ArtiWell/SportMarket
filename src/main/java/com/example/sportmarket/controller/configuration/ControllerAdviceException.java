package com.example.sportmarket.controller.configuration;

import lombok.Builder;
import lombok.Getter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerAdviceException{

    @ExceptionHandler({ DataAccessException.class })
    public ResponseEntity<Object> handleAll(Exception ex, WebRequest request) {
        return new ResponseEntity<>(
                new Error.ErrorBuilder()
                        .status(HttpStatus.BAD_REQUEST)
                        .error(ex.getMessage())
                        .build(),
                new HttpHeaders(),
                HttpStatus.BAD_REQUEST
        );
    }

    @Builder
    @Getter
    private static class Error {
        private final LocalDateTime timestamp = LocalDateTime.now();
        private final HttpStatus status;
        private final String error;
    }
}

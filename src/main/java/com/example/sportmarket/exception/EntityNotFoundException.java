package com.example.sportmarket.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class EntityNotFoundException extends RuntimeException {


    public EntityNotFoundException() {
        super("Заданного параметра нет в базе данных");
    }
}

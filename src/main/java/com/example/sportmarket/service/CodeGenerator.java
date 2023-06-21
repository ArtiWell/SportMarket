package com.example.sportmarket.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class CodeGenerator {

    @Value("${app.code-bound}")
    private Integer codeBound;
    private final Random random = new Random();

    public int generateCode(){
        return random.nextInt(1000000) + 1;
    }
}

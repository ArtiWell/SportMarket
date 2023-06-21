package com.example.sportmarket.controller.client;
import java.util.Date;
import java.util.UUID;


public record ClientDTO(UUID uuid, String firstName, String secondName, boolean status, Date date) {
}

package com.chatop.controllers;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SignupRequest {
    private String email;

    private String password;

    private Set<String> role;
}

package com.example.Api.dto;

import lombok.Data;

@Data
public class SignupRequest {

    private String username;
    private String userfullname;
    private String email;
    private String password;
}

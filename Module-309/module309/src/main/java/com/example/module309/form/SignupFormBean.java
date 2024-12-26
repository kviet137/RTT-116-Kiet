package com.example.module309.form;


import com.example.module309.validation.EmailUnique;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupFormBean {

    @EmailUnique(message = "email already been used")
    @NotEmpty(message = "username is required")
    private String username;

    @NotEmpty(message = "password is required")
    private String password;

    @NotEmpty(message = "fullname is required")
    private String fullname;



}

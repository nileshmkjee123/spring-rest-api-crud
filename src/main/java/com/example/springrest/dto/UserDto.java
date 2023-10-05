package com.example.springrest.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private long id;
    @NotEmpty(message = "User firstName can't be empty or null")
    private String firstName;
    @NotEmpty(message = "User firstName can't be empty or null")
    private String lastName;
    @NotEmpty(message = "User firstName can't be empty or null")
    @Email(message = "Email address should be valid")
    private  String email;
}

package com.example.springrest.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(
        description = "user dto model"
)
public class UserDto {
    private long id;
    @NotEmpty(message = "User firstName can't be empty or null")
    @Schema(
            description = "user 1stname"
    )
    private String firstName;
    @NotEmpty(message = "User firstName can't be empty or null")
    @Schema(
            description = "user lastname"
    )
    private String lastName;
    @NotEmpty(message = "User firstName can't be empty or null")
    @Schema(
            description = "user email"
    )
    @Email(message = "Email address should be valid")
    private  String email;
}

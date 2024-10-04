package com.scm.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserForm {

    @NotBlank(message = "Username is required")
    @Size(min = 3, message = "Min 3 character is required")
    private String name;
    @Email(message = "Invalid email address")
    private String email;
    @Size(min = 8, max = 10, message = "Invalid phone number")
    private String phoneNumber;
    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "min 6 character is required")
    private String password;
    @NotBlank(message = "About is required")
    private String about;

}

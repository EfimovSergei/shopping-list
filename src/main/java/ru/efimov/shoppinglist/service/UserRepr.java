package ru.efimov.shoppinglist.service;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRepr {

    private Long id;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String repeatPassword;
}
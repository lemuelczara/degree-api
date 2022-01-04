package com.meli.degreeapi.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectRequest {

    @NotBlank(message = "The name field cannot be blank!")
    @NotNull(message = "The name field cannot be null!")
    @Size(min = 8, max = 50, message = "The name field must be between 8 and 50 characters!")
    @Pattern(regexp = "[a-zA-Z]+", message = "The name field only accepted letters!")
    private String name;
}

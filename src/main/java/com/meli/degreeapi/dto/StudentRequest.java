package com.meli.degreeapi.dto;

import java.util.List;

import javax.validation.Valid;
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
public class StudentRequest {
    @NotBlank(message = "The name field cannot be blank!")
    @NotNull(message = "The name field cannot be null!")
    @Size(min = 8, max = 50, message = "The name field must be between 8 and 50 characters!")
    private String name;
    
    @Valid
    private List<StudentSubjectRequest> subjects;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class StudentSubjectRequest {
        @NotBlank(message = "The id field cannot be blank!")
        @NotNull(message = "The id field cannot be null!")
        private String id;

        @NotBlank(message = "The grade field cannot be blank!")
        @NotNull(message = "The grade field cannot be null!")
        @Pattern(regexp = "^(?:[1-9]|0[1-9]|10)$")
        private String grade;
    }
}

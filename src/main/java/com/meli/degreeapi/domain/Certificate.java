package com.meli.degreeapi.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Certificate {
    private String id;
    private Student student;
    private String average;
    private String message;
    private LocalDateTime createdAt;
}

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
public class Subject {
    private String id;    
    private String name;
    private String grade;
    private LocalDateTime createdAt;
}

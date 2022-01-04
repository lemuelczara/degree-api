package com.meli.degreeapi.domain;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Student {
    private String id;
    private String name;
    private List<Subject> subjects;
    private LocalDateTime createdAt;
}

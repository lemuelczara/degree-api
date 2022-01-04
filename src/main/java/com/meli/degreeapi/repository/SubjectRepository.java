package com.meli.degreeapi.repository;

import java.util.ArrayList;
import java.util.List;

import com.meli.degreeapi.domain.Subject;

import org.springframework.stereotype.Repository;

@Repository
public class SubjectRepository {
    private final List<Subject> subjects = new ArrayList<>();

    public Subject save(Subject subject) {
        this.subjects.add(subject);

        return subject;
    }

    public Subject findById(String id) {
        return this.subjects.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Subject findByName(String name) {
        return this.subjects.stream()
                .filter(s -> s.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
}

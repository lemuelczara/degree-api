package com.meli.degreeapi.repository;

import java.util.ArrayList;
import java.util.List;

import com.meli.degreeapi.domain.Student;

import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {
    private final List<Student> students = new ArrayList<>();

    public Student save(Student student) {
        this.students.add(student);

        return student;
    }

    public Student findById(String id) {
        return this.students.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}

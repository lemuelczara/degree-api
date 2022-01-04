package com.meli.degreeapi.service;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.stream.Collectors;

import com.meli.degreeapi.domain.Student;
import com.meli.degreeapi.domain.Subject;
import com.meli.degreeapi.dto.StudentRequest;
import com.meli.degreeapi.exception.NoSuchElementFoundException;
import com.meli.degreeapi.repository.StudentRepository;
import com.meli.degreeapi.repository.SubjectRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    @Autowired
    private SubjectRepository subjectRepository;

    public Student save(StudentRequest httpRequest) {
        Student student = Student.builder()
                .id(String.valueOf(new Random().nextInt(1000)))
                .name(httpRequest.getName())
                .createdAt(LocalDateTime.now())
                .build();

        student.setSubjects(httpRequest.getSubjects().stream().map(subject -> {
            Subject findSubject = this.subjectRepository.findById(subject.getId());

            if (findSubject == null) {
                throw new NoSuchElementFoundException("The Subject with ID: " + subject.getId() + " not exists!");
            }

            findSubject.setGrade(subject.getGrade());

            return findSubject;
        }).collect(Collectors.toList()));

        return this.repository.save(student);
    }

    public Student findById(String id) {
        Student student = this.repository.findById(id);

        if (student == null) {
            throw new NoSuchElementFoundException("The Student with ID: " + id + " not exists!");
        }

        return student;
    }
}

package com.meli.degreeapi.service;

import java.time.LocalDateTime;
import java.util.Random;

import com.meli.degreeapi.domain.Subject;
import com.meli.degreeapi.dto.SubjectRequest;
import com.meli.degreeapi.exception.NoSuchElementFoundException;
import com.meli.degreeapi.exception.SubjectInUseException;
import com.meli.degreeapi.repository.SubjectRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository repository;

    public Subject save(SubjectRequest httpRequest) {
        Subject subjectAlreadyExists = this.repository.findByName(httpRequest.getName());

        if (subjectAlreadyExists != null) {
            throw new SubjectInUseException(
                    "The receive Subject: " + subjectAlreadyExists.getName() + " is already in use!");
        }

        Subject subject = Subject
                .builder()
                .id(String.valueOf(new Random().nextInt(1000)))
                .name(httpRequest.getName())
                .createdAt(LocalDateTime.now())
                .build();

        return this.repository.save(subject);
    }

    public Subject findById(String id) {
        Subject subject = this.repository.findById(id);

        if (subject == null) {
            throw new NoSuchElementFoundException("The Subject with ID: " + id + " not exists!");
        }

        return subject;
    }
}

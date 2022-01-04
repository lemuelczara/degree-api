package com.meli.degreeapi.service;

import java.time.LocalDateTime;
import java.util.Random;

import com.meli.degreeapi.domain.Subject;
import com.meli.degreeapi.dto.SubjectRequest;
import com.meli.degreeapi.repository.SubjectRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository repository;

    public Subject save(SubjectRequest httpRequest) {
        Subject subject = Subject
                .builder()
                .id(String.valueOf(new Random().nextInt(1000)))
                .name(httpRequest.getName())
                .createdAt(LocalDateTime.now())
                .build();

        return this.repository.save(subject);
    }

    public Subject findById(String id) {
        return this.repository.findById(id);
    }
}

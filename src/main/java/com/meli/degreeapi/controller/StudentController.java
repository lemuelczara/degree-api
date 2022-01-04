package com.meli.degreeapi.controller;

import javax.validation.Valid;

import com.meli.degreeapi.dto.StudentRequest;
import com.meli.degreeapi.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1")
public class StudentController {
    
    @Autowired
    private StudentService service;

    @PostMapping(path = "/students")
    public ResponseEntity<Object> save(@Valid @RequestBody StudentRequest httpRequestBody) {
        return new ResponseEntity<>(this.service.save(httpRequestBody), HttpStatus.CREATED);
    }
}

package com.meli.degreeapi.controller;

import javax.validation.Valid;

import com.meli.degreeapi.dto.SubjectRequest;
import com.meli.degreeapi.service.SubjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1")
public class SubjectController {

    @Autowired
    private SubjectService service;

    @PostMapping(path = "/subjects")
    public ResponseEntity<Object> save(@Valid @RequestBody SubjectRequest httpRequestBody) {
        return new ResponseEntity<>(this.service.save(httpRequestBody), HttpStatus.CREATED);
    }

    @GetMapping(path = "/subjects/{id}")
    public ResponseEntity<Object> findById(@PathVariable String id) {
        return new ResponseEntity<>(this.service.findById(id), HttpStatus.OK);
    }
}

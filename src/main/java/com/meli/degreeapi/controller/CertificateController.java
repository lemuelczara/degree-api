package com.meli.degreeapi.controller;

import com.meli.degreeapi.service.CertificateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1")
public class CertificateController {

    @Autowired
    private CertificateService service;

    @PostMapping(path = "/certificates/{studentId}")
    public ResponseEntity<Object> save(@PathVariable String studentId) {
        return new ResponseEntity<>(this.service.save(studentId), HttpStatus.OK);
    }
}

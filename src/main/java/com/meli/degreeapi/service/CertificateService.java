package com.meli.degreeapi.service;

import java.time.LocalDateTime;
import java.util.Random;

import com.meli.degreeapi.domain.Certificate;
import com.meli.degreeapi.domain.Student;
import com.meli.degreeapi.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CertificateService {

    @Autowired
    private StudentRepository studentRepository;

    public Certificate save(String studentId) {
        Student student = this.studentRepository.findById(studentId);

        Double averageGrade = student.getSubjects().stream()
                .map(subject -> Double.parseDouble(subject.getGrade()))
                .reduce(0.0, (accum, next) -> accum + next, Double::sum) / student.getSubjects().size();

        String message = student.getName() + ", your total average was " + averageGrade;

        Certificate certificate = Certificate.builder()
                .id(String.valueOf(new Random().nextInt(100)))
                .student(student)
                .message(message)
                .average(averageGrade.toString())
                .createdAt(LocalDateTime.now())
                .build();

        return certificate;
    }
}

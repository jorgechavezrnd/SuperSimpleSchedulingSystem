package com.harbor.example.module.students.application.create;

import com.harbor.example.module.students.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public final class StudentCreator {
    private final StudentRepository repository;

    @Autowired
    public StudentCreator(StudentRepository repository) {
        this.repository = repository;
    }

    public void create(StudentId id, StudentFirstName firstName, StudentLastName lastName) {
        Student student = Student.create(id, firstName, lastName);

        repository.save(student);
    }
}

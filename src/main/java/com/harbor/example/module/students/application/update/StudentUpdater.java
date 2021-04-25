package com.harbor.example.module.students.application.update;

import com.harbor.example.module.students.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public final class StudentUpdater {
    private final StudentRepository repository;

    @Autowired
    public StudentUpdater(StudentRepository repository) {
        this.repository = repository;
    }

    public void update(StudentId id, StudentFirstName firstName, StudentLastName lastName, StudentClassesIds classesIds) throws StudentNotExist {
        Student student = repository.search(id).orElseThrow(() -> new StudentNotExist(id));

        Student studentUpdated = new Student(student.id(), firstName, lastName, classesIds);

        repository.save(studentUpdated);
    }
}

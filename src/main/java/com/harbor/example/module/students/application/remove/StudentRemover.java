package com.harbor.example.module.students.application.remove;

import com.harbor.example.module.students.domain.StudentId;
import com.harbor.example.module.students.domain.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public final class StudentRemover {
    private final StudentRepository repository;

    @Autowired
    public StudentRemover(StudentRepository repository) {
        this.repository = repository;
    }

    public void remove(StudentId id) {
        repository.remove(id);
    }
}

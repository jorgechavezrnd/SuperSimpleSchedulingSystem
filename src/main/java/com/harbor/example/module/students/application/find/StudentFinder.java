package com.harbor.example.module.students.application.find;

import com.harbor.example.module.students.application.StudentResponse;
import com.harbor.example.module.students.domain.StudentId;
import com.harbor.example.module.students.domain.StudentNotExist;
import com.harbor.example.module.students.domain.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public final class StudentFinder {
    private final StudentRepository repository;

    @Autowired
    public StudentFinder(StudentRepository repository) {
        this.repository = repository;
    }

    public StudentResponse find(StudentId id) throws StudentNotExist {
        return repository.search(id)
                         .map(StudentResponse::fromAggregate)
                         .orElseThrow(() -> new StudentNotExist(id));
    }
}

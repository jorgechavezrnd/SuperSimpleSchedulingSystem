package com.harbor.example.module.students.application.search_all;

import com.harbor.example.module.students.application.StudentResponse;
import com.harbor.example.module.students.application.StudentsResponse;
import com.harbor.example.module.students.domain.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public final class AllStudentsSearcher {
    private final StudentRepository repository;

    @Autowired
    public AllStudentsSearcher(StudentRepository repository) {
        this.repository = repository;
    }

    public StudentsResponse search() {
        return new StudentsResponse(
            repository.searchAll().stream().map(StudentResponse::fromAggregate).collect(Collectors.toList())
        );
    }
}

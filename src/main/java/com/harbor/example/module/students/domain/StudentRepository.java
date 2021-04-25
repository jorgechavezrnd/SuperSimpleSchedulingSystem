package com.harbor.example.module.students.domain;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {
    void save(Student student);

    Optional<Student> search(StudentId id);

    void remove(StudentId id);

    List<Student> searchAll();
}

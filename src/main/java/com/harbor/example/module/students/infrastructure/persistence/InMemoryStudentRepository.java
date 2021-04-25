package com.harbor.example.module.students.infrastructure.persistence;

import com.harbor.example.module.students.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public final class InMemoryStudentRepository implements StudentRepository {
    private final HashMap<StudentId, Student> students = new HashMap<>();

    @Override
    public void save(Student student) {
        this.students.put(student.id(), student);
    }

    @Override
    public Optional<Student> search(StudentId id) {
        return Optional.ofNullable(students.get(id));
    }

    @Override
    public void remove(StudentId id) {
        students.remove(id);
    }

    @Override
    public List<Student> searchAll() {
        return new ArrayList<>(students.values());
    }
}

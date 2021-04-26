package com.harbor.example.module.students.application.register_class;

import com.harbor.example.module.shared.domain.ClassId;
import com.harbor.example.module.students.domain.Student;
import com.harbor.example.module.students.domain.StudentId;
import com.harbor.example.module.students.domain.StudentNotExist;
import com.harbor.example.module.students.domain.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public final class ClassRegisterer {
    private final StudentRepository repository;

    @Autowired
    public ClassRegisterer(StudentRepository repository) {
        this.repository = repository;
    }

    public void register(StudentId studentId, ClassId classId) throws StudentNotExist {
        Student student = repository.search(studentId).orElseThrow(() -> new StudentNotExist(studentId));

        student.addClass(classId);

        repository.save(student);
    }
}

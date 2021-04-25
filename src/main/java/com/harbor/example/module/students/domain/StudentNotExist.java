package com.harbor.example.module.students.domain;

import com.harbor.example.module.shared.domain.DomainError;

public final class StudentNotExist extends DomainError {
    public StudentNotExist(StudentId id) {
        super("student_not_exist", String.format("The student [%s] doesn't exist", id.value()));
    }
}

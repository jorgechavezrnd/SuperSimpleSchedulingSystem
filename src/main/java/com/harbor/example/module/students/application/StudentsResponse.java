package com.harbor.example.module.students.application;

import java.util.List;

public final class StudentsResponse {
    private final List<StudentResponse> students;

    public StudentsResponse(List<StudentResponse> students) {
        this.students = students;
    }

    public List<StudentResponse> students() {
        return students;
    }
}

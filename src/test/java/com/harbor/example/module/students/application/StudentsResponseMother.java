package com.harbor.example.module.students.application;

import com.harbor.example.module.shared.domain.ListMother;

import java.util.Collections;
import java.util.List;

public final class StudentsResponseMother {
    public static StudentsResponse create(List<StudentResponse> students) {
        return new StudentsResponse(students);
    }

    public static StudentsResponse random() {
        return create(ListMother.random(StudentResponseMother::random));
    }

    public static StudentsResponse times(int times) {
        return create(ListMother.create(times, StudentResponseMother::random));
    }

    public static StudentsResponse empty() {
        return create(Collections.emptyList());
    }
}

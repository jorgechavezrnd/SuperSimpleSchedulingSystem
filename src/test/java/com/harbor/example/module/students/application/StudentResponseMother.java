package com.harbor.example.module.students.application;

import com.harbor.example.module.students.domain.*;

public final class StudentResponseMother {
    public static StudentResponse create(StudentId id, StudentFirstName firstName, StudentLastName lastName) {
        return new StudentResponse(id.value(), firstName.value(), lastName.value());
    }

    public static StudentResponse random() {
        return create(StudentIdMother.random(), StudentFirstNameMother.random(), StudentLastNameMother.random());
    }
}

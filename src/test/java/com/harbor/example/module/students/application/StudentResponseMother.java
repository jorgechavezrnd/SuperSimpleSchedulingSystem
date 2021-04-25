package com.harbor.example.module.students.application;

import com.harbor.example.module.shared.domain.ClassId;
import com.harbor.example.module.shared.domain.Identifier;
import com.harbor.example.module.students.domain.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final class StudentResponseMother {
    public static StudentResponse create(StudentId id, StudentFirstName firstName, StudentLastName lastName, List<ClassId> classesIds) {
        return new StudentResponse(
            id.value(),
            firstName.value(),
            lastName.value(),
            classesIds.stream().map(Identifier::value).collect(Collectors.toList())
        );
    }

    public static StudentResponse random() {
        return create(
            StudentIdMother.random(),
            StudentFirstNameMother.random(),
            StudentLastNameMother.random(),
            Collections.emptyList()
        );
    }
}

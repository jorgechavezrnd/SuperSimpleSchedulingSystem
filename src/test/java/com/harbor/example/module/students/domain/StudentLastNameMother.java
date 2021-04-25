package com.harbor.example.module.students.domain;

import com.harbor.example.module.shared.domain.WordMother;

public final class StudentLastNameMother {
    public static StudentLastName create(String value) {
        return new StudentLastName(value);
    }

    public static StudentLastName random() {
        return create(WordMother.random());
    }
}

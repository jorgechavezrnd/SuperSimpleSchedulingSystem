package com.harbor.example.module.students.domain;

import com.harbor.example.module.shared.domain.WordMother;

public final class StudentFirstNameMother {
    public static StudentFirstName create(String value) {
        return new StudentFirstName(value);
    }

    public static StudentFirstName random() {
        return create(WordMother.random());
    }
}

package com.harbor.example.module.classes.domain;

import com.harbor.example.module.shared.domain.WordMother;

public final class ClassDescriptionMother {
    public static ClassDescription create(String value) {
        return new ClassDescription(value);
    }

    public static ClassDescription random() {
        return create(WordMother.random());
    }
}

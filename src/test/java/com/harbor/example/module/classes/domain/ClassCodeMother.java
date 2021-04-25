package com.harbor.example.module.classes.domain;

import com.harbor.example.module.shared.domain.WordMother;

public final class ClassCodeMother {
    public static ClassCode create(String value) {
        return new ClassCode(value);
    }

    public static ClassCode random() {
        return create(WordMother.random());
    }
}

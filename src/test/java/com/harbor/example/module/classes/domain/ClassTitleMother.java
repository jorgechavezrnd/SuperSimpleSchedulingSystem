package com.harbor.example.module.classes.domain;

import com.harbor.example.module.shared.domain.WordMother;

public final class ClassTitleMother {
    public static ClassTitle create(String value) {
        return new ClassTitle(value);
    }

    public static ClassTitle random() {
        return create(WordMother.random());
    }
}

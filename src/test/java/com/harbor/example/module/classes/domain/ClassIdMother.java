package com.harbor.example.module.classes.domain;

import com.harbor.example.module.shared.domain.ClassId;
import com.harbor.example.module.shared.domain.UuidMother;

public final class ClassIdMother {
    public static ClassId create(String value) {
        return new ClassId(value);
    }

    public static ClassId random() {
        return create(UuidMother.random());
    }
}

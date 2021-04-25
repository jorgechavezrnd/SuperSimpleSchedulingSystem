package com.harbor.example.module.classes.domain;

import com.harbor.example.module.classes.application.ClassResponse;

public final class ClassMother {
    public static Class create(ClassId id, ClassCode code, ClassTitle title, ClassDescription description) {
        return new Class(id, code, title, description);
    }

    public static Class fromResponse(ClassResponse response) {
        return create(
            ClassIdMother.create(response.id()),
            ClassCodeMother.create(response.code()),
            ClassTitleMother.create(response.title()),
            ClassDescriptionMother.create(response.description())
        );
    }

    public static Class random() {
        return create(
            ClassIdMother.random(),
            ClassCodeMother.random(),
            ClassTitleMother.random(),
            ClassDescriptionMother.random()
        );
    }
}

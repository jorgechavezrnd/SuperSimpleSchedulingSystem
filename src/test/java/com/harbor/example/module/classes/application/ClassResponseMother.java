package com.harbor.example.module.classes.application;

import com.harbor.example.module.classes.domain.*;
import com.harbor.example.module.shared.domain.ClassId;

public final class ClassResponseMother {
    public static ClassResponse create(ClassId id, ClassCode code, ClassTitle title, ClassDescription description) {
        return new ClassResponse(id.value(), code.value(), title.value(), description.value());
    }

    public static ClassResponse random() {
        return create(
            ClassIdMother.random(),
            ClassCodeMother.random(),
            ClassTitleMother.random(),
            ClassDescriptionMother.random()
        );
    }
}

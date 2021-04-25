package com.harbor.example.module.classes.application;

import com.harbor.example.module.shared.domain.ListMother;

import java.util.Collections;
import java.util.List;

public final class ClassesResponseMother {
    public static ClassesResponse create(List<ClassResponse> classes) {
        return new ClassesResponse(classes);
    }

    public static ClassesResponse random() {
        return create(ListMother.random(ClassResponseMother::random));
    }

    public static ClassesResponse times(int times) {
        return create(ListMother.create(times, ClassResponseMother::random));
    }

    public static ClassesResponse empty() {
        return create(Collections.emptyList());
    }
}

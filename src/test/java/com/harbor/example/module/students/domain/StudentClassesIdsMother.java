package com.harbor.example.module.students.domain;

import com.harbor.example.module.shared.domain.ClassId;
import com.harbor.example.module.classes.domain.ClassIdMother;
import com.harbor.example.module.shared.domain.ListMother;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final class StudentClassesIdsMother {
    public static StudentClassesIds create(List<ClassId> classesIds) {
        return new StudentClassesIds(classesIds);
    }

    public static StudentClassesIds fromStringList(List<String> classesIds) {
        return create(
            classesIds.stream().map(ClassId::new).collect(Collectors.toList())
        );
    }

    public static StudentClassesIds random() {
        return create(ListMother.random(ClassIdMother::random));
    }

    public static StudentClassesIds empty() {
        return create(Collections.emptyList());
    }
}

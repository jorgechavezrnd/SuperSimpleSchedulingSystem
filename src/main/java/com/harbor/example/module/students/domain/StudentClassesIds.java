package com.harbor.example.module.students.domain;

import com.harbor.example.module.shared.domain.ClassId;
import com.harbor.example.module.shared.domain.ListValueObject;

import java.util.List;
import java.util.stream.Collectors;

public final class StudentClassesIds extends ListValueObject<ClassId> {
    public StudentClassesIds(List<ClassId> classesIds) {
        super(classesIds);
    }

    public static StudentClassesIds fromListString(List<String> classesIds) {
        return new StudentClassesIds(
            classesIds.stream().map(ClassId::new).collect(Collectors.toList())
        );
    }

    public void addClassId(ClassId classId) {
        if (!value.contains(classId)) {
            value.add(classId);
        }
    }

    public void removeClassId(ClassId classId) {
        value.remove(classId);
    }
}

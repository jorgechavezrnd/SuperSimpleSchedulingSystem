package com.harbor.example.module.students.domain;

import com.harbor.example.module.shared.domain.ClassId;

import java.util.Objects;

public final class Student {
    private final StudentId         id;
    private final StudentFirstName  firstName;
    private final StudentLastName   lastName;
    private final StudentClassesIds classesIds;

    public Student(StudentId id, StudentFirstName firstName, StudentLastName lastName, StudentClassesIds classesIds) {
        this.id         = id;
        this.firstName  = firstName;
        this.lastName   = lastName;
        this.classesIds = classesIds;
    }

    public static Student create(StudentId id, StudentFirstName firstName, StudentLastName lastName, StudentClassesIds classesIds) {
        return new Student(id, firstName, lastName, classesIds);
    }

    public StudentId id() {
        return id;
    }

    public StudentFirstName firstName() {
        return firstName;
    }

    public StudentLastName lastName() {
        return lastName;
    }

    public StudentClassesIds getClassesIds() {
        return classesIds;
    }

    public void addClass(ClassId classId) {
        classesIds.addClassId(classId);
    }

    public void removeClass(ClassId classId) {
        classesIds.removeClassId(classId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id.equals(student.id) && firstName.equals(student.firstName) && lastName.equals(student.lastName) && classesIds.equals(student.classesIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, classesIds);
    }
}

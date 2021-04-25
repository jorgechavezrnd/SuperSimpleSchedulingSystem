package com.harbor.example.module.students.domain;

import java.util.Objects;

public final class Student {
    private final StudentId        id;
    private final StudentFirstName firstName;
    private final StudentLastName  lastName;

    public Student(StudentId id, StudentFirstName firstName, StudentLastName lastName) {
        this.id        = id;
        this.firstName = firstName;
        this.lastName  = lastName;
    }

    public static Student create(StudentId id, StudentFirstName firstName, StudentLastName lastName) {
        return new Student(id, firstName, lastName);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id.equals(student.id) && firstName.equals(student.firstName) && lastName.equals(student.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }
}

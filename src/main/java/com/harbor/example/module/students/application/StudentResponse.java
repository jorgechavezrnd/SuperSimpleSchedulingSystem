package com.harbor.example.module.students.application;

import com.harbor.example.module.students.domain.Student;

import java.util.Objects;

public final class StudentResponse {
    private final String id;
    private final String firstName;
    private final String lastName;

    public StudentResponse(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static StudentResponse fromAggregate(Student student) {
        return new StudentResponse(student.id().value(), student.firstName().value(), student.lastName().value());
    }

    public String id() {
        return id;
    }

    public String firstName() {
        return firstName;
    }

    public String lastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentResponse that = (StudentResponse) o;
        return id.equals(that.id) && firstName.equals(that.firstName) && lastName.equals(that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }
}

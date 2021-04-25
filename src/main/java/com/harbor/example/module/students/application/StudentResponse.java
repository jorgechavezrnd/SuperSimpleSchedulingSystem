package com.harbor.example.module.students.application;

import com.harbor.example.module.shared.domain.Identifier;
import com.harbor.example.module.students.domain.Student;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public final class StudentResponse {
    private final String       id;
    private final String       firstName;
    private final String       lastName;
    private final List<String> classesIds;

    public StudentResponse(String id, String firstName, String lastName, List<String> classesIds) {
        this.id         = id;
        this.firstName  = firstName;
        this.lastName   = lastName;
        this.classesIds = classesIds;
    }

    public static StudentResponse fromAggregate(Student student) {
        return new StudentResponse(
                student.id().value(),
                student.firstName().value(),
                student.lastName().value(),
                student.getClassesIds().value().stream().map(Identifier::value).collect(Collectors.toList())
        );
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

    public List<String> classesIds() {
        return classesIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentResponse that = (StudentResponse) o;
        return id.equals(that.id) && firstName.equals(that.firstName) && lastName.equals(that.lastName) && classesIds.equals(that.classesIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, classesIds);
    }
}

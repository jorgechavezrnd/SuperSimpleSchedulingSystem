package com.harbor.example.module.students.application.deregister_class;

import com.harbor.example.module.classes.domain.ClassIdMother;
import com.harbor.example.module.shared.domain.ClassId;
import com.harbor.example.module.students.StudentsModuleUnitTestCase;
import com.harbor.example.module.students.domain.Student;
import com.harbor.example.module.students.domain.StudentClassesIdsMother;
import com.harbor.example.module.students.domain.StudentMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

final class ClassDeregistererShould extends StudentsModuleUnitTestCase {
    private ClassDeregisterer classDeregisterer;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        classDeregisterer = new ClassDeregisterer(repository);
    }

    @Test
    void deregister_a_class() {
        Student student = StudentMother.random();
        ClassId classIdToRemove = ClassIdMother.random();
        student.addClass(classIdToRemove);
        Student studentWithClassRemoved = StudentMother.create(
            student.id(),
            student.firstName(),
            student.lastName(),
            StudentClassesIdsMother.create(new ArrayList<>(student.getClassesIds().value()))
        );
        studentWithClassRemoved.removeClass(classIdToRemove);

        shouldReturnOnSearch(student.id(), student);

        classDeregisterer.deregister(student.id(), classIdToRemove);

        shouldHaveSaved(studentWithClassRemoved);
    }
}

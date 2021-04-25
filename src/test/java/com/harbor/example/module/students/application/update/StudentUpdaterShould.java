package com.harbor.example.module.students.application.update;

import com.harbor.example.module.students.StudentsModuleUnitTestCase;
import com.harbor.example.module.students.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

final class StudentUpdaterShould extends StudentsModuleUnitTestCase {
    private StudentUpdater updater;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        updater = new StudentUpdater(repository);
    }

    @Test
    void update_a_student() {
        Student student = StudentMother.random();
        StudentFirstName newFirstName = StudentFirstNameMother.random();
        StudentLastName newLastName = StudentLastNameMother.random();
        StudentClassesIds newClassesIds = StudentClassesIdsMother.random();
        Student studentUpdated = StudentMother.create(student.id(), newFirstName, newLastName, newClassesIds);

        shouldReturnOnSearch(student.id(), student);

        updater.update(student.id(), newFirstName, newLastName, newClassesIds);

        shouldHaveSaved(studentUpdated);
    }
}

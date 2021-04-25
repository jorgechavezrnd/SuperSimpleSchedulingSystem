package com.harbor.example.module.students.application.create;

import com.harbor.example.module.students.StudentsModuleUnitTestCase;
import com.harbor.example.module.students.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

final class StudentCreatorShould extends StudentsModuleUnitTestCase {
    private StudentCreator creator;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        creator = new StudentCreator(repository);
    }

    @Test
    void create_a_valid_student() {
        Student student = StudentMother.random();

        creator.create(student.id(), student.firstName(), student.lastName());

        shouldHaveSaved(student);
    }
}

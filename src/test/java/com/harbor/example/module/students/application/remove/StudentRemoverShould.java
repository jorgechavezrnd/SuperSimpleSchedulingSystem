package com.harbor.example.module.students.application.remove;

import com.harbor.example.module.students.StudentsModuleUnitTestCase;
import com.harbor.example.module.students.domain.StudentId;
import com.harbor.example.module.students.domain.StudentIdMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

final class StudentRemoverShould extends StudentsModuleUnitTestCase {
    private StudentRemover remover;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        remover = new StudentRemover(repository);
    }

    @Test
    void remove_a_student() {
        StudentId id = StudentIdMother.random();

        remover.remove(id);

        shouldHaveRemoved(id);
    }
}

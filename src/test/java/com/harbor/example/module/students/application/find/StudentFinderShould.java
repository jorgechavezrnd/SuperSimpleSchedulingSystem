package com.harbor.example.module.students.application.find;

import com.harbor.example.module.students.StudentsModuleUnitTestCase;
import com.harbor.example.module.students.application.StudentResponse;
import com.harbor.example.module.students.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

final class StudentFinderShould extends StudentsModuleUnitTestCase {
    private StudentFinder finder;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        finder = new StudentFinder(repository);
    }

    @Test
    void update_a_student() {
        Student student = StudentMother.random();

        shouldReturnOnSearch(student.id(), student);

        StudentResponse studentResponse = finder.find(student.id());

        assertEquals(student, StudentMother.fromResponse(studentResponse));
    }

    @Test
    void throw_student_not_exist_exception() {
        StudentId studentId = StudentIdMother.random();

        Exception exception = assertThrows(StudentNotExist.class, () -> {
            finder.find(studentId);
        });

        assertEquals(new StudentNotExist(studentId).getMessage(), exception.getMessage());
    }
}

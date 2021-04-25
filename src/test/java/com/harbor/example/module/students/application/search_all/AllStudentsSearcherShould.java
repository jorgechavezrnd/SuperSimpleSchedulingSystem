package com.harbor.example.module.students.application.search_all;

import com.harbor.example.module.students.StudentsModuleUnitTestCase;
import com.harbor.example.module.students.application.StudentsResponse;
import com.harbor.example.module.students.application.StudentsResponseMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class AllStudentsSearcherShould extends StudentsModuleUnitTestCase {
    private AllStudentsSearcher searcher;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        searcher = new AllStudentsSearcher(repository);
    }

    @Test
    void return_all_students() {
        StudentsResponse students = StudentsResponseMother.random();

        shouldReturn(students);

        assertEquals(students.students(), searcher.search().students());
    }

    @Test
    void return_empty_when_there_are_no_students() {
        StudentsResponse students = StudentsResponseMother.empty();

        shouldReturn(students);

        assertEquals(students.students(), searcher.search().students());
    }
}

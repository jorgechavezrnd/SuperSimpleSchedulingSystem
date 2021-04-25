package com.harbor.example.module.classes.application.search_all;

import com.harbor.example.module.classes.ClassesModuleUnitTestCase;
import com.harbor.example.module.classes.application.ClassesResponse;
import com.harbor.example.module.classes.application.ClassesResponseMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class AllClassesSearcherShould extends ClassesModuleUnitTestCase {
    private AllClassesSearcher searcher;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        searcher = new AllClassesSearcher(repository);
    }

    @Test
    void return_all_classes() {
        ClassesResponse classes = ClassesResponseMother.random();

        shouldReturnOnSearchAll(classes);

        assertEquals(classes.classes(), searcher.search().classes());
    }

    @Test
    void return_empty_where_there_are_no_classes() {
        ClassesResponse classes = ClassesResponseMother.empty();

        shouldReturnOnSearchAll(classes);

        assertEquals(classes.classes(), searcher.search().classes());
    }
}

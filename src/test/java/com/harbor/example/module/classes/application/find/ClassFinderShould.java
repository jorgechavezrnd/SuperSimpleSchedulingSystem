package com.harbor.example.module.classes.application.find;

import com.harbor.example.module.classes.ClassesModuleUnitTestCase;
import com.harbor.example.module.classes.application.ClassResponse;
import com.harbor.example.module.classes.domain.*;
import com.harbor.example.module.classes.domain.Class;
import com.harbor.example.module.shared.domain.ClassId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

final class ClassFinderShould extends ClassesModuleUnitTestCase {
    private ClassFinder finder;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        finder = new ClassFinder(repository);
    }

    @Test
    void find_a_class() {
        Class classInstance = ClassMother.random();

        shouldReturnOnSearch(classInstance.id(), classInstance);

        ClassResponse classResponse = finder.find(classInstance.id());

        assertEquals(classInstance, ClassMother.fromResponse(classResponse));
    }

    @Test
    void throw_class_not_exist_exception_on_search_not_existing_class() {
        ClassId classId = ClassIdMother.random();

        Exception exception = assertThrows(ClassNotExist.class, () -> finder.find(classId));

        assertEquals(new ClassNotExist(classId).getMessage(), exception.getMessage());
    }
}

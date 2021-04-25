package com.harbor.example.module.classes.application.create;

import com.harbor.example.module.classes.ClassesModuleUnitTestCase;
import com.harbor.example.module.classes.domain.Class;
import com.harbor.example.module.classes.domain.ClassMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

final class ClassCreatorShould extends ClassesModuleUnitTestCase {
    private ClassCreator creator;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        creator = new ClassCreator(repository);
    }

    @Test
    void create_a_valid_class() {
        Class classInstance = ClassMother.random();

        creator.create(
            classInstance.id(),
            classInstance.code(),
            classInstance.title(),
            classInstance.description()
        );

        shouldHaveSaved(classInstance);
    }
}

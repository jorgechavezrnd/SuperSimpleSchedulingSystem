package com.harbor.example.module.classes.application.update;

import com.harbor.example.module.classes.ClassesModuleUnitTestCase;
import com.harbor.example.module.classes.domain.*;
import com.harbor.example.module.classes.domain.Class;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

final class ClassUpdaterShould extends ClassesModuleUnitTestCase {
    private ClassUpdater updater;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        updater = new ClassUpdater(repository);
    }

    @Test
    void update_a_class() {
        Class classInstance = ClassMother.random();
        ClassCode newCode = ClassCodeMother.random();
        ClassTitle newTitle = ClassTitleMother.random();
        ClassDescription newDescription = ClassDescriptionMother.random();
        Class classUpdated = ClassMother.create(classInstance.id(), newCode, newTitle, newDescription);

        shouldReturnOnSearch(classInstance.id(), classInstance);

        updater.update(classInstance.id(), newCode, newTitle, newDescription);

        shouldHaveSaved(classUpdated);
    }
}

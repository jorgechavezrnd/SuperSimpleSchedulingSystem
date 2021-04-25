package com.harbor.example.module.classes.application.remove;

import com.harbor.example.module.classes.ClassesModuleUnitTestCase;
import com.harbor.example.module.classes.domain.ClassId;
import com.harbor.example.module.classes.domain.ClassIdMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

final class ClassRemoverShould extends ClassesModuleUnitTestCase {
    private ClassRemover remover;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        remover = new ClassRemover(repository);
    }

    @Test
    void remove_a_class() {
        ClassId id = ClassIdMother.random();

        remover.remove(id);

        shouldHaveRemoved(id);
    }
}

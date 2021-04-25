package com.harbor.example.module.classes.infrastructure.persistence;

import com.harbor.example.module.classes.ClassesModuleInfrastructureTestCase;
import com.harbor.example.module.classes.domain.Class;
import com.harbor.example.module.classes.domain.ClassIdMother;
import com.harbor.example.module.classes.domain.ClassMother;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

final class InMemoryClassRepositoryShould extends ClassesModuleInfrastructureTestCase {
    @Test
    void save_a_class() {
        Class classInstance = ClassMother.random();

        inMemoryClassRepository.save(classInstance);
    }

    @Test
    void return_an_existing_class() {
        Class classInstance = ClassMother.random();

        inMemoryClassRepository.save(classInstance);

        assertEquals(Optional.of(classInstance), inMemoryClassRepository.search(classInstance.id()));
    }

    @Test
    void not_return_a_non_existing_class() {
        assertFalse(inMemoryClassRepository.search(ClassIdMother.random()).isPresent());
    }
}

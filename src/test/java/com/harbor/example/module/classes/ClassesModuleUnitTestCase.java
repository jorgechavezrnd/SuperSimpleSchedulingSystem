package com.harbor.example.module.classes;

import com.harbor.example.module.classes.application.ClassesResponse;
import com.harbor.example.module.classes.domain.Class;
import com.harbor.example.module.shared.domain.ClassId;
import com.harbor.example.module.classes.domain.ClassMother;
import com.harbor.example.module.classes.domain.ClassRepository;
import org.junit.jupiter.api.BeforeEach;

import java.util.Optional;
import java.util.stream.Collectors;

import static org.mockito.Mockito.*;

public abstract class ClassesModuleUnitTestCase {
    protected ClassRepository repository;

    @BeforeEach
    protected void setUp() {
        repository = mock(ClassRepository.class);
    }

    protected void shouldHaveSaved(Class classInstance) {
        verify(repository, atLeastOnce()).save(classInstance);
    }

    protected void shouldReturnOnSearchAll(ClassesResponse classes) {
        when(repository.searchAll()).thenReturn(
            classes.classes().stream().map(ClassMother::fromResponse).collect(Collectors.toList())
        );
    }

    protected void shouldReturnOnSearch(ClassId id, Class classInstance) {
        when(repository.search(id)).thenReturn(
            Optional.of(classInstance)
        );
    }

    protected void shouldHaveRemoved(ClassId id) {
        verify(repository, atLeastOnce()).remove(id);
    }
}

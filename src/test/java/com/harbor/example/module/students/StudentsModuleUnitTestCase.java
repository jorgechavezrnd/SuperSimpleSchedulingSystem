package com.harbor.example.module.students;

import com.harbor.example.module.students.application.StudentsResponse;
import com.harbor.example.module.students.domain.Student;
import com.harbor.example.module.students.domain.StudentMother;
import com.harbor.example.module.students.domain.StudentRepository;
import org.junit.jupiter.api.BeforeEach;

import java.util.stream.Collectors;

import static org.mockito.Mockito.*;

public abstract class StudentsModuleUnitTestCase {
    protected StudentRepository repository;

    @BeforeEach
    protected void setUp() {
        repository = mock(StudentRepository.class);
    }

    protected void shouldHaveSaved(Student student) {
        verify(repository, atLeastOnce()).save(student);
    }

    protected void shouldReturn(StudentsResponse students) {
        when(repository.searchAll()).thenReturn(
            students.students().stream().map(StudentMother::fromResponse).collect(Collectors.toList())
        );
    }
}

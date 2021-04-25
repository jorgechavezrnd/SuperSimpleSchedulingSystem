package com.harbor.example.module.students;

import com.harbor.example.module.students.application.StudentsResponse;
import com.harbor.example.module.students.domain.Student;
import com.harbor.example.module.students.domain.StudentId;
import com.harbor.example.module.students.domain.StudentMother;
import com.harbor.example.module.students.domain.StudentRepository;
import org.junit.jupiter.api.BeforeEach;

import java.util.Optional;
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

    protected void shouldReturnOnSearchAll(StudentsResponse students) {
        when(repository.searchAll()).thenReturn(
            students.students().stream().map(StudentMother::fromResponse).collect(Collectors.toList())
        );
    }

    protected void shouldReturnOnSearch(StudentId id, Student student) {
        when(repository.search(id)).thenReturn(
            Optional.of(student)
        );
    }
}

package com.harbor.example.module.students;

import com.harbor.example.module.students.domain.StudentRepository;
import com.harbor.example.module.students.infrastructure.persistence.InMemoryStudentRepository;

public abstract class StudentsModuleInfrastructureTestCase {
    protected StudentRepository inMemoryStudentRepository = new InMemoryStudentRepository();
}

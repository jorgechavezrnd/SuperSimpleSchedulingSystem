package com.harbor.example.module.classes;

import com.harbor.example.module.classes.domain.ClassRepository;
import com.harbor.example.module.classes.infrastructure.persistence.InMemoryClassRepository;

public abstract class ClassesModuleInfrastructureTestCase {
    protected ClassRepository inMemoryClassRepository = new InMemoryClassRepository();
}

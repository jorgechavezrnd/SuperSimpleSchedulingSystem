package com.harbor.example.module.classes.application.remove;

import com.harbor.example.module.classes.domain.ClassId;
import com.harbor.example.module.classes.domain.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public final class ClassRemover {
    private final ClassRepository repository;

    @Autowired
    public ClassRemover(ClassRepository repository) {
        this.repository = repository;
    }

    public void remove(ClassId id) {
        repository.remove(id);
    }
}

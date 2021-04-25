package com.harbor.example.module.classes.application.find;

import com.harbor.example.module.classes.application.ClassResponse;
import com.harbor.example.module.classes.domain.ClassId;
import com.harbor.example.module.classes.domain.ClassNotExist;
import com.harbor.example.module.classes.domain.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public final class ClassFinder {
    private final ClassRepository repository;

    @Autowired
    public ClassFinder(ClassRepository repository) {
        this.repository = repository;
    }

    public ClassResponse find(ClassId id) throws ClassNotExist {
        return repository.search(id)
                         .map(ClassResponse::fromAggregate)
                         .orElseThrow(() -> new ClassNotExist(id));
    }
}

package com.harbor.example.module.classes.application.create;

import com.harbor.example.module.classes.domain.*;
import com.harbor.example.module.classes.domain.Class;
import com.harbor.example.module.shared.domain.ClassId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public final class ClassCreator {
    private final ClassRepository repository;

    @Autowired
    public ClassCreator(ClassRepository repository) {
        this.repository = repository;
    }

    public void create(ClassId id, ClassCode code, ClassTitle title, ClassDescription description) {
        Class newClass = Class.create(id, code, title, description);

        repository.save(newClass);
    }
}

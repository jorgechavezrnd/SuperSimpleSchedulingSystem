package com.harbor.example.module.classes.application.update;

import com.harbor.example.module.classes.domain.*;
import com.harbor.example.module.classes.domain.Class;
import com.harbor.example.module.shared.domain.ClassId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public final class ClassUpdater {
    private final ClassRepository repository;

    @Autowired
    public ClassUpdater(ClassRepository repository) {
        this.repository = repository;
    }

    public void update(ClassId id, ClassCode code, ClassTitle title, ClassDescription description) throws ClassNotExist {
        Class classInstance = repository.search(id).orElseThrow(() -> new ClassNotExist(id));

        Class classUpdated = new Class(classInstance.id(), code, title, description);

        repository.save(classUpdated);
    }
}

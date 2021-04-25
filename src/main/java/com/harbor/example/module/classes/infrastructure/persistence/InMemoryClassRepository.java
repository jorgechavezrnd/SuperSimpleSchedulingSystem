package com.harbor.example.module.classes.infrastructure.persistence;

import com.harbor.example.module.classes.domain.*;
import com.harbor.example.module.classes.domain.Class;
import com.harbor.example.module.shared.domain.ClassId;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public final class InMemoryClassRepository implements ClassRepository {
    private final HashMap<ClassId, Class> classes = new HashMap<>();

    @Override
    public void save(Class newClass) {
        this.classes.put(newClass.id(), newClass);
    }

    @Override
    public Optional<Class> search(ClassId id) {
        return Optional.ofNullable(classes.get(id));
    }

    @Override
    public void remove(ClassId id) {
        classes.remove(id);
    }

    @Override
    public List<Class> searchAll() {
        return new ArrayList<>(classes.values());
    }
}

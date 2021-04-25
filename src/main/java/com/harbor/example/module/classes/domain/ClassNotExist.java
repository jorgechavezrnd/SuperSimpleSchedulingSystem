package com.harbor.example.module.classes.domain;

import com.harbor.example.module.shared.domain.DomainError;

public final class ClassNotExist extends DomainError {
    public ClassNotExist(ClassId id) {
        super("class_not_exist", String.format("The class [%s] doesn't exist", id.value()));
    }
}

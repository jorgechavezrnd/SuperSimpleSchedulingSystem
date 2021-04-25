package com.harbor.example.module.classes.domain;

import com.harbor.example.module.shared.domain.ClassId;

import java.util.Objects;

public final class Class {
    private final ClassId id;
    private final ClassCode        code;
    private final ClassTitle       title;
    private final ClassDescription description;

    public Class(ClassId id, ClassCode code, ClassTitle title, ClassDescription description) {
        this.id = id;
        this.code = code;
        this.title = title;
        this.description = description;
    }

    public static Class create(ClassId id, ClassCode code, ClassTitle title, ClassDescription description) {
        return new Class(id, code, title, description);
    }

    public ClassId id() {
        return id;
    }

    public ClassCode code() {
        return code;
    }

    public ClassTitle title() {
        return title;
    }

    public ClassDescription description() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Class aClass = (Class) o;
        return id.equals(aClass.id) && code.equals(aClass.code) && title.equals(aClass.title) && description.equals(aClass.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, title, description);
    }
}

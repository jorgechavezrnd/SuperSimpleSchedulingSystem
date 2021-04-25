package com.harbor.example.module.classes.application;

import com.harbor.example.module.classes.domain.Class;

import java.util.Objects;

public final class ClassResponse {
    private final String id;
    private final String code;
    private final String title;
    private final String description;

    public ClassResponse(String id, String code, String title, String description) {
        this.id = id;
        this.code = code;
        this.title = title;
        this.description = description;
    }

    public static ClassResponse fromAggregate(Class classInstance) {
        return new ClassResponse(
            classInstance.id().value(),
            classInstance.code().value(),
            classInstance.title().value(),
            classInstance.description().value()
        );
    }

    public String id() {
        return id;
    }

    public String code() {
        return code;
    }

    public String title() {
        return title;
    }

    public String description() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassResponse that = (ClassResponse) o;
        return id.equals(that.id) && code.equals(that.code) && title.equals(that.title) && description.equals(that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, title, description);
    }
}

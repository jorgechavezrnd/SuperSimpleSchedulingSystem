package com.harbor.example.module.classes.application;

import java.util.List;

public final class ClassesResponse {
    private final List<ClassResponse> classes;

    public ClassesResponse(List<ClassResponse> classes) {
        this.classes = classes;
    }

    public List<ClassResponse> classes() {
        return classes;
    }
}

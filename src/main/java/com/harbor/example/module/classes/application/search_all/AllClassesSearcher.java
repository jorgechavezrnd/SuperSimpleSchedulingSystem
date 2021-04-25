package com.harbor.example.module.classes.application.search_all;

import com.harbor.example.module.classes.application.ClassResponse;
import com.harbor.example.module.classes.application.ClassesResponse;
import com.harbor.example.module.classes.domain.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public final class AllClassesSearcher {
    private final ClassRepository repository;

    @Autowired
    public AllClassesSearcher(ClassRepository repository) {
        this.repository = repository;
    }

    public ClassesResponse search() {
        return new ClassesResponse(
            repository.searchAll().stream().map(ClassResponse::fromAggregate).collect(Collectors.toList())
        );
    }
}

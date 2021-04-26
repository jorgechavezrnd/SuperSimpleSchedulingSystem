package com.harbor.example.module.students.application.register_class;

import com.harbor.example.module.classes.domain.ClassIdMother;
import com.harbor.example.module.shared.domain.ClassId;
import com.harbor.example.module.students.StudentsModuleUnitTestCase;
import com.harbor.example.module.students.domain.Student;
import com.harbor.example.module.students.domain.StudentClassesIdsMother;
import com.harbor.example.module.students.domain.StudentMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

final class ClassRegistererShould extends StudentsModuleUnitTestCase {
    private ClassRegisterer classRegisterer;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        classRegisterer = new ClassRegisterer(repository);
    }

    @Test
    void register_a_class() {
        Student student = StudentMother.random();
        ClassId newClassId = ClassIdMother.random();
        Student studentWithNewClass = StudentMother.create(
            student.id(),
            student.firstName(),
            student.lastName(),
            StudentClassesIdsMother.create(new ArrayList<>(student.getClassesIds().value()))
        );
        studentWithNewClass.addClass(newClassId);

        shouldReturnOnSearch(student.id(), student);

        classRegisterer.register(student.id(), newClassId);

        shouldHaveSaved(studentWithNewClass);
    }
}

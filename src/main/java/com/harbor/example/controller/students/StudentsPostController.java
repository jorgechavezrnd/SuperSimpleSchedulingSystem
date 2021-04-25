package com.harbor.example.controller.students;

import com.harbor.example.module.students.application.create.StudentCreator;
import com.harbor.example.module.students.application.update.StudentUpdater;
import com.harbor.example.module.students.domain.StudentClassesIds;
import com.harbor.example.module.students.domain.StudentFirstName;
import com.harbor.example.module.students.domain.StudentId;
import com.harbor.example.module.students.domain.StudentLastName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.UUID;

@Controller
public final class StudentsPostController {
    private final StudentCreator creator;
    private final StudentUpdater updater;

    @Autowired
    public StudentsPostController(StudentCreator creator, StudentUpdater updater) {
        this.creator = creator;
        this.updater = updater;
    }

    @RequestMapping(value = "/students", method = RequestMethod.POST)
    public String createStudent(@ModelAttribute("student")StudentDTO student) {
        student.setId(UUID.randomUUID().toString());

        creator.create(
            new StudentId(student.getId()),
            new StudentFirstName(student.getFirstName()),
            new StudentLastName(student.getLastName()),
            new StudentClassesIds(new ArrayList<>())
        );

        return "redirect:/students";
    }

    @RequestMapping(value = "/students/edit", method = RequestMethod.POST)
    public String updateStudent(@ModelAttribute("student")StudentDTO student) {
        updater.update(
            new StudentId(student.getId()),
            new StudentFirstName(student.getFirstName()),
            new StudentLastName(student.getLastName()),
            StudentClassesIds.fromListString(student.getClassesIds())
        );

        return "redirect:/students";
    }
}

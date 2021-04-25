package com.harbor.example.controller.classes;

import com.harbor.example.module.classes.application.create.ClassCreator;
import com.harbor.example.module.classes.application.update.ClassUpdater;
import com.harbor.example.module.classes.domain.ClassCode;
import com.harbor.example.module.classes.domain.ClassDescription;
import com.harbor.example.module.classes.domain.ClassId;
import com.harbor.example.module.classes.domain.ClassTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.UUID;

@Controller
public final class ClassesPostController {
    private final ClassCreator creator;
    private final ClassUpdater updater;

    @Autowired
    public ClassesPostController(ClassCreator creator, ClassUpdater updater) {
        this.creator = creator;
        this.updater = updater;
    }

    @RequestMapping(value = "/classes", method = RequestMethod.POST)
    public String index(@ModelAttribute("classInstance") ClassDTO classInstance, BindingResult result) {
        classInstance.setId(UUID.randomUUID().toString());

        this.creator.create(
                new ClassId(classInstance.getId()),
                new ClassCode(classInstance.getCode()),
                new ClassTitle(classInstance.getTitle()),
                new ClassDescription(classInstance.getDescription())
        );

        return "redirect:/classes";
    }

    @RequestMapping(value = "/classes/edit", method = RequestMethod.POST)
    public String updateClass(@ModelAttribute("classInstance") ClassDTO classInstance, BindingResult result) {
        updater.update(
                new ClassId(classInstance.getId()),
                new ClassCode(classInstance.getCode()),
                new ClassTitle(classInstance.getTitle()),
                new ClassDescription(classInstance.getDescription())
        );

        return "redirect:/classes";
    }
}

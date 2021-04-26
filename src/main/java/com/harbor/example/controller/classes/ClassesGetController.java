package com.harbor.example.controller.classes;

import com.harbor.example.module.classes.application.ClassResponse;
import com.harbor.example.module.classes.application.find.ClassFinder;
import com.harbor.example.module.classes.application.remove.ClassRemover;
import com.harbor.example.module.classes.application.search_all.AllClassesSearcher;
import com.harbor.example.module.shared.domain.ClassId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public final class ClassesGetController {
    private final AllClassesSearcher searcher;
    private final ClassFinder        finder;
    private final ClassRemover       remover;

    @Autowired
    public ClassesGetController(AllClassesSearcher searcher, ClassFinder finder, ClassRemover remover) {
        this.searcher = searcher;
        this.finder   = finder;
        this.remover  = remover;
    }

    @RequestMapping(value = "/classes", method = RequestMethod.GET)
    public String getAllClasses(Model model) {
        model.addAttribute("classes", searcher.search().classes());

        return "list_classes";
    }

    @RequestMapping(value = "/classes/create", method = RequestMethod.GET)
    public String getCreateClassForm(Model model) {
        model.addAttribute("classInstance", new ClassDTO());
        model.addAttribute("url", "/classes");

        return "class_form";
    }

    @RequestMapping(value = "/classes/edit/{id}", method = RequestMethod.GET)
    public String getEditClassForm(@PathVariable("id") String id, Model model) {
        ClassResponse classResponse = finder.find(new ClassId(id));

        ClassDTO classInstance = new ClassDTO();
        classInstance.setId(classResponse.id());
        classInstance.setCode(classResponse.code());
        classInstance.setTitle(classResponse.title());
        classInstance.setDescription(classResponse.description());

        model.addAttribute("classInstance", classInstance);
        model.addAttribute("url", "/classes/edit");

        return "class_form";
    }

    @RequestMapping(value = "/classes/delete/{id}", method = RequestMethod.GET)
    public String deleteClass(@PathVariable("id") String id) {
        remover.remove(new ClassId(id));

        return "redirect:/classes";
    }
}

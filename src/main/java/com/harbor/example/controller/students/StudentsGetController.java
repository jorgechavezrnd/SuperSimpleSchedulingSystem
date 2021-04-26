package com.harbor.example.controller.students;

import com.harbor.example.module.classes.application.ClassResponse;
import com.harbor.example.module.classes.application.find.ClassFinder;
import com.harbor.example.module.classes.application.search_all.AllClassesSearcher;
import com.harbor.example.module.shared.domain.ClassId;
import com.harbor.example.module.students.application.StudentResponse;
import com.harbor.example.module.students.application.deregister_class.ClassDeregisterer;
import com.harbor.example.module.students.application.find.StudentFinder;
import com.harbor.example.module.students.application.register_class.ClassRegisterer;
import com.harbor.example.module.students.application.remove.StudentRemover;
import com.harbor.example.module.students.application.search_all.AllStudentsSearcher;
import com.harbor.example.module.students.domain.StudentId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public final class StudentsGetController {
    private final AllStudentsSearcher searcher;
    private final StudentFinder       finder;
    private final StudentRemover      remover;
    private final ClassFinder         classFinder;
    private final AllClassesSearcher  allClassesSearcher;
    private final ClassRegisterer     classRegisterer;
    private final ClassDeregisterer   classDeregisterer;

    @Autowired
    public StudentsGetController(AllStudentsSearcher searcher, StudentFinder finder, StudentRemover remover,
                                 ClassFinder classFinder, AllClassesSearcher  allClassesSearcher,
                                 ClassRegisterer classRegisterer, ClassDeregisterer   classDeregisterer) {
        this.searcher           = searcher;
        this.finder             = finder;
        this.remover            = remover;
        this.classFinder        = classFinder;
        this.allClassesSearcher = allClassesSearcher;
        this.classRegisterer    = classRegisterer;
        this.classDeregisterer  = classDeregisterer;
    }

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public String getAllStudents(Model model) {
        model.addAttribute("students", searcher.search().students());

        return "list_students";
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
    public String getStudent(@PathVariable("id") String id, Model model) {
        StudentResponse student = finder.find(new StudentId(id));
        List<ClassResponse> studentsClasses = student.classesIds()
                                                     .stream()
                                                     .map(classId -> classFinder.find(new ClassId(classId)))
                                                     .collect(Collectors.toList());

        List<ClassResponse> availableClasses =
                allClassesSearcher.search()
                                  .classes()
                                  .stream()
                                  .filter(classResponse -> !studentsClasses.contains(classResponse))
                                  .collect(Collectors.toList());

        model.addAttribute("student", student);
        model.addAttribute("studentsClasses", studentsClasses);
        model.addAttribute("availableClasses", availableClasses);

        return "student";
    }

    @RequestMapping(value = "/students/create", method = RequestMethod.GET)
    public String getCreateStudentForm(Model model) {
        model.addAttribute("student", new StudentDTO());
        model.addAttribute("url", "/students");

        return "student_form";
    }

    @RequestMapping(value = "/students/edit/{id}", method = RequestMethod.GET)
    public String getEditStudentForm(@PathVariable("id") String id, Model model) {
        StudentResponse studentResponse = finder.find(new StudentId(id));

        StudentDTO student = new StudentDTO();
        student.setId(studentResponse.id());
        student.setFirstName(studentResponse.firstName());
        student.setLastName(studentResponse.lastName());

        model.addAttribute("student", student);
        model.addAttribute("url", "/students/edit");

        return "student_form";
    }

    @RequestMapping(value = "/students/delete/{id}", method = RequestMethod.GET)
    public String deleteStudent(@PathVariable("id") String id) {
        remover.remove(new StudentId(id));

        return "redirect:/students";
    }

    @RequestMapping(value = "/students/{studentId}/add/class/{classId}", method = RequestMethod.GET)
    public String addClass(@PathVariable("studentId") String studentId, @PathVariable("classId") String classId) {
        classRegisterer.register(new StudentId(studentId), new ClassId(classId));

        return "redirect:/students/" + studentId;
    }

    @RequestMapping(value = "/students/{studentId}/remove/class/{classId}", method = RequestMethod.GET)
    public String removeClass(@PathVariable("studentId") String studentId, @PathVariable("classId") String classId) {
        classDeregisterer.deregister(new StudentId(studentId), new ClassId(classId));

        return "redirect:/students/" + studentId;
    }
}

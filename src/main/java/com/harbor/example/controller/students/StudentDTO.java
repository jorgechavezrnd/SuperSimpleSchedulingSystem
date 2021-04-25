package com.harbor.example.controller.students;

import java.util.List;

public final class StudentDTO {
    private String       id;
    private String       firstName;
    private String       lastName;
    private List<String> classesIds;

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<String> getClassesIds() {
        return classesIds;
    }

    public void setClassesIds(List<String> classesIds) {
        this.classesIds = classesIds;
    }
}

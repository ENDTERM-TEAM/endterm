package com.company.controllers;


import com.company.entities.Students;
import com.company.repositories.interfaces.IRepository;

import java.util.ArrayList;

public class Controller {
    private final IRepository repository;

    public Controller(IRepository repository) {
        this.repository = repository;
    }

    public String addStudent(String first_name, String last_name, int age, String email, int score, int group_id) {
        boolean add = repository.addStudent(new Students(first_name, last_name, age, email, score, group_id));
        if (add) return "Student was added";
        return "Student was not added";
    }

}

package com.company.controllers;


import com.company.entities.Students;
import com.company.repositories.interfaces.IRepository;

import java.util.ArrayList;

public class Controller {
    private final IRepository repository;

    public Controller(IRepository repository) {
        this.repository = repository;
    }

   public String addStudent(String first_name,String last_name,int age,int score,String email,int group_id,int subject_count,boolean with_books) {

        Students students = new Students(first_name,last_name,age,score,email,group_id,subject_count,with_books);
        boolean added = repository.addStudent(students);

        if (added) {
            return "Student was added!";
        }

        return "Student was not added!";

    }
    
    public String addTeacher(String first_name,String last_name,int age,String email,int group_id,double salary,String subject_name) {

        Teachers teachers = new Teachers(first_name,last_name,age,email,group_id,salary,subject_name);
        boolean added = repository.addTeacher(teachers);

        if (added) {
            return "Teacher was added!";
        }

        return "Teacher was not added!";

    }

    public ArrayList<Students> showAllStudents() {
        ArrayList<Students> students = new ArrayList<>();
        students = repository.showAllStudents();

        return students;
    }

     public String removeStudentById(int id) {
        boolean removed = repository.removeStudentByID(id);

        if (removed) {
            return "Student was removed!";
        }

        return "Student was not removed!";
    }


    public ArrayList<Students> showTop10Students() {
        ArrayList<Students> students = new ArrayList<>();
        students = repository.showTop10Students();

        return students;
    }
    public String getStudentByHighestScore() {
        return repository.getStudentByHighestScore().toString();
    }

    public String changeEmailById(int id, String email, String table) {
        boolean change = repository.changeEmailById(id, email, table);
        if(change) return "Email has updated";
        return "Email has not updated";
    }
    
    public void showAllGroups() {
        ArrayList<Groups> groups = repository.showAllGroup();
        ArrayList<Mentors> mentors = repository.showMentors();
        for (Groups group : groups) {
            System.out.println(group.toString());
            for (Mentors mentor : mentors) {
                if (group.getMentor_id() == mentor.getId()) System.out.println(mentor.toString());
            }
        }
    }

}

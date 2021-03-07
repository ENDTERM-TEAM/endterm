package com.company.controllers;

import com.company.entities.Groups;
import com.company.entities.Mentors;
import com.company.entities.Students;
import com.company.entities.Teachers;
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

        if (added) {                                                           //if everything is worked, it returns positive message
            return "Student was added!";
        }

        return "Student was not added!";                                      //otherwise, it's not added

    }
    
    public String addTeacher(String first_name,String last_name,int age,String email,int group_id,double salary,String subject_name) {

        Teachers teachers = new Teachers(first_name,last_name,age,email,group_id,salary,subject_name);
        boolean added = repository.addTeacher(teachers);                       //navigation to method in repository

        if (added) {                                                           //if everything is worked, it returns positive message
            return "Teacher was added!";
        }

        return "Teacher was not added!";                                       //otherwise, it's not added

    }

    public ArrayList<Students> showAllStudents() {
        ArrayList<Students> students = new ArrayList<>();                      
        students = repository.showAllStudents();                               //navigation to method in repository

        return students;
    }

     public String removeStudentById(int id) {
        boolean removed = repository.removeStudentByID(id);                    //navigation to method in repository

        if (removed) {                                                         //if everything is worked, it returns positive message
            return "Student was removed!";
        }

        return "Student was not removed!";                                     //otherwise, it's not removed
    }


    public ArrayList<Students> showTop10Students() {
        ArrayList<Students> students = new ArrayList<>();
        students = repository.showTop10Students();                              //navigation to method in repository

        return students;
    }
    public String getStudentByHighestScore() {
        return repository.getStudentByHighestScore().toString();               //navigation to method in repository, and converting it to String, cause score is integer
    }

    public String changeEmailById(int id, String email, String table) {
        boolean change = repository.changeEmailById(id, email, table);         //navigation to method in repository
        if(change) return "Email has updated";                                 //if everything is worked, it returns positive message
        
        return "Email has not updated";                                        //otherwise, it's not updated
    }
    
    public void showAllGroups() {
        ArrayList<Groups> groups = repository.showAllGroup();                  //navigation to method in repository
        ArrayList<Mentors> mentors = repository.showMentors();                 //navigation to method in repository
        for (Groups group : groups) {                                          //making for-each loop 
            System.out.println(group.toString());                              //output each group
            for (Mentors mentor : mentors) {                                   //making another for-each loop, find his mentors
                if (group.getMentor_id() == mentor.getId()) System.out.println(mentor.toString());  //and outputting all info about them
            }
        }
    }

}

package com.company.repositories.interfaces;

import com.company.entities.Students;
import com.company.entities.Groups;
import com.company.entities.Mentors;
import com.company.entities.Students;
import com.company.entities.Teachers;
import java.util.ArrayList;

public interface IRepository {
    boolean addStudent(Students students); //in interface we write what the classes can do
    boolean addTeacher(Teachers teachers);
    ArrayList<Students> showAllStudents();
    boolean removeStudentByID(int id);           //defines a set of common behaviors. 
    ArrayList<Students> showTop10Students();
    Students getStudentByHighestScore();
    boolean changeEmailById(int id, String email, String table);
    ArrayList<Groups> showAllGroup();
    ArrayList<Mentors> showMentors();
    ArrayList<Teachers> showAllTeachers();
}

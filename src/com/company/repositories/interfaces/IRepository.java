package com.company.repositories.interfaces;

import com.company.entities.Students;

public interface IRepository {
    boolean addStudent(Students student);
    boolean addTeacher(Teachers teachers);
    ArrayList showAllStudents();
    boolean removeStudentByID(int id);
    ArrayList showTop10Students();
    Students getStudentByHighestScore();
    boolean changeEmailById(int id, String email, String table);
    ArrayList<Groups> showAllGroup();
    ArrayList<Mentors> showMentors();
}

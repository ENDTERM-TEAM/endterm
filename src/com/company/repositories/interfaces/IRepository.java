package com.company.repositories.interfaces;

import com.company.entities.Students;

public interface IRepository {
    boolean addStudent(Students student);
    Students getStudentByHighestScore();
    boolean changeEmailById(int id, String email, String table);
}

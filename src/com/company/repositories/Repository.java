package com.company.repositories;

import com.company.data.interfaces.IDBManager;
import com.company.entities.Groups;
import com.company.entities.Mentors;                                                   //Import all needed classes and statements
import com.company.entities.Students;
import com.company.entities.Teachers;
import com.company.repositories.interfaces.IRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Repository implements IRepository {                                    

    private final IDBManager dbManager;

    public Repository(IDBManager dbManager) {
        this.dbManager = dbManager;                                                    //creating data base manager
    }

   @Override
    public boolean addStudent(Students student) {
        Connection con = null;                                                         //create try catch block
        try {
            con = dbManager.getConnection();                                           //get coonect
            PreparedStatement st = con.prepareStatement("INSERT INTO students(id,fname,lname,age,score,email,group_id,subject_count,with_books) VALUES(DEFAULT,?,?,?,?,?,?,?,?)");

            st.setString(1, student.getFirst_name());                                  //For adding student write sql statement and fill instead question mark all variables of student
            st.setString(2, student.getLast_name());
            st.setInt(3, student.getAge());
            st.setInt(4, student.getScore());
            st.setString(5, student.getEmail());
            st.setInt(6,student.getGroupID());
            st.setInt(7,student.getSubject_count());
            st.setBoolean(8,student.isWith_books());
            st.execute();
            return true;                                                 
        } catch ( SQLException | ClassNotFoundException throwables ) { 
            throwables.printStackTrace();                                              //Catch block
        }
        return false;                                                                  //if try block didn't work return false
    }

    public boolean addTeacher(Teachers teachers) {
        Connection con = null;
        try {
            con = dbManager.getConnection();
            PreparedStatement st = con.prepareStatement("INSERT INTO teachers(id,fname,lname,age,email,group_id,salary,subject_name) VALUES(DEFAULT,?,?,?,?,?,?,?)");

            st.setString(1, teachers.getFirst_name());                                 //the same as previous one but instead students, teachers
            st.setString(2, teachers.getLast_name());
            st.setInt(3, teachers.getAge());
            st.setString(4,teachers.getEmail());
            st.setInt(5, teachers.getGroup_id());
            st.setDouble(6,teachers.getSalary());
            st.setString(7,teachers.getSubject());
            st.execute();
            return true;
        } catch ( SQLException | ClassNotFoundException throwables ) {
            throwables.printStackTrace();                                             //catch block
        }
        return false;
    }

    @Override
    public ArrayList<Students> showAllStudents() {
        Connection con = null;
        try {
            con = dbManager.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM students");    //another sql statements to show all fields of table
            
            ResultSet resultSet = ps.executeQuery();                                  //creating resultSet
            ArrayList<Students> students = new ArrayList<>();                         //creating array list of students
            while (resultSet.next()) {                                                //if result set has next fields
               Students students1 = new Students(resultSet.getInt("id"),              //creating student and with help constructor filling it
                        resultSet.getString("fname"),
                        resultSet.getString("lname"),
                        resultSet.getInt("age"),
                        resultSet.getInt("score"),
                        resultSet.getString("email"),
                        resultSet.getInt("group_id"),
                       resultSet.getInt("subject_count"),
                       resultSet.getBoolean("with_books"));

                students.add(students1);                                               //adding each students
            }
            return students;                                                           //return array list

        } catch ( SQLException | ClassNotFoundException throwables ) {
            throwables.printStackTrace();
        }
        return null;
    }
    
    @Override
    public boolean removeStudentByID(int id) {
        Connection con = null;
        try {
            con = dbManager.getConnection();                                           //get connection

            PreparedStatement ps = con.prepareStatement("DELETE FROM students WHERE id=?");  //for remove student use this sql statement
            ps.setInt(1, id);                                                                //instead question mark id
            ps.execute();
            return true;
            
        } catch ( SQLException | ClassNotFoundException throwables ) {
            throwables.printStackTrace();
        }
        return false;                                                                        //if it didn't work return false
    }
    
    @Override
    public ArrayList<Students> showTop10Students() {
        Connection con = null;
        try {
            con = dbManager.getConnection();

            PreparedStatement ps = con.prepareStatement("SELECT * FROM students ORDER BY score DESC ");  //do the same as show all students but with decreasing score from higher yo lower
            ResultSet resultSet = ps.executeQuery();                                                     //execute this query
            ArrayList<Students> students = new ArrayList<>();                                            //create array list of students
            int k = 0;                                                                                   //create variable

            while (resultSet.next() && k<11) {                                                           //if resultset have next list and k is less than 11 continue this loop
                Students students1 = new Students(resultSet.getInt("id"),                                //creating students
                        resultSet.getString("fname"),
                        resultSet.getString("lname"),
                        resultSet.getInt("age"),
                        resultSet.getInt("score"),
                        resultSet.getString("email"),
                        resultSet.getInt("group_id"),
                        resultSet.getInt("subject_count"),
                        resultSet.getBoolean("with_books"));
                k++;                                                                                      //k from 0 to 10
                students.add(students1);                                                                  //add student to list
            }
            return students;
        } catch ( SQLException | ClassNotFoundException throwables ) {
            throwables.printStackTrace();
        }
        return null;
    }
    
    @Override
    public Students getStudentByHighestScore() {
        Connection con = null;
        try {
            con = dbManager.getConnection();
            PreparedStatement st = con.prepareStatement("SELECT * FROM students WHERE score=(SELECT MAX(score) FROM students)");  //statement to find student with highest score
            ResultSet resultSet = st.executeQuery();
            Students students = new Students();                                 //creating students and resultSet

            if(resultSet.next()) {                                              //if is not null add student
                Students s = new Students(resultSet.getInt("id"),
                        resultSet.getString("fname"),
                        resultSet.getString("lname"),
                        resultSet.getInt("age"),
                        resultSet.getInt("score"),
                        resultSet.getString("email"),
                        resultSet.getInt("group_id"),
                        resultSet.getInt("subject_count"),
                        resultSet.getBoolean("with_books"));

                students = s;
            }
            return students;                                                     //return it
        } catch ( SQLException | ClassNotFoundException throwables ) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean changeEmailById(int id, String email, String table) {
        Connection con = null;
        try {
            con = dbManager.getConnection();                                          //get connection
            PreparedStatement st = con.prepareStatement("UPDATE " + table + " SET email='" + email + "' WHERE id=" + id + "");  //complex statement which can update email to 3 tables
            st.execute();      //execute it and return true
            return true;
        } catch ( SQLException | ClassNotFoundException throwables ) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public ArrayList<Groups> showAllGroup() {
        Connection con = null;
        try {
            con = dbManager.getConnection();
            PreparedStatement st = con.prepareStatement("SELECT * FROM groups");  //the same as show all students 
            ResultSet resultSet = st.executeQuery();

            ArrayList<Groups> groups = new ArrayList<>();                 //create array list

            while(resultSet.next()) {
                Groups group = new Groups(resultSet.getInt("g_id"),
                        resultSet.getString("name"),                      //fill each array list
                        resultSet.getString("level"),
                        resultSet.getInt("mentor_id"));
                groups.add(group);
            }
            return groups;                                                //return it
        } catch ( SQLException | ClassNotFoundException throwables ) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Mentors> showMentors() {
        Connection con = null;
        try {
            con = dbManager.getConnection();
            PreparedStatement st = con.prepareStatement("SELECT * FROM mentors");   //the same as previous
            ResultSet resultSet = st.executeQuery();

            ArrayList<Mentors> mentors = new ArrayList<>();                         //create array list

            while(resultSet.next()) {
                Mentors m = new Mentors(resultSet.getInt("id"),                     //filling each
                        resultSet.getString("fname"),
                        resultSet.getString("lname"),
                        resultSet.getInt("age"),
                        resultSet.getString("email"),
                        resultSet.getDouble("salary"));
                mentors.add(m);
            }
            return mentors;                                                         //return this array list
        } catch ( SQLException | ClassNotFoundException throwables ) {
            throwables.printStackTrace();
        }
        return null;
    }
    
    @Override
    public ArrayList<Teachers> showAllTeachers() {
        Connection con = null;
        try {
            con = dbManager.getConnection();                                        //get connection
            PreparedStatement ps = con.prepareStatement("SELECT * FROM teachers");  //the same as previous
            ResultSet resultSet = ps.executeQuery();
            ArrayList<Teachers> teachers = new ArrayList<>();                       //create array list
            while (resultSet.next()) {
                Teachers t = new Teachers(resultSet.getInt("id"),                   //filling it
                        resultSet.getString("fname"),
                        resultSet.getString("lname"),
                        resultSet.getInt("age"),
                        resultSet.getString("email"),
                        resultSet.getDouble("salary"),
                        resultSet.getString("subject_name"),
                        resultSet.getInt("group_id"));
                teachers.add(t);
            }
            return teachers;                                                        //return this array list
        } catch ( SQLException | ClassNotFoundException throwables ) {
            throwables.printStackTrace();
        }
        return null;
    }
}

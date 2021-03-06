package com.company.repositories;

import com.company.data.interfaces.IDBManager;
import com.company.entities.Students;
import com.company.repositories.interfaces.IRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Repository implements IRepository {

    private final IDBManager dbManager;

    public Repository(IDBManager dbManager) {
        this.dbManager = dbManager;
    }

    @Override
    public boolean addStudent(Students student) {
        Connection con = null;
        try {
            con = dbManager.getConnection();
            PreparedStatement st = con.prepareStatement("INSERT INTO students(id,fname,lname,age,score,email,group_id) VALUES(DEFAULT,?,?,?,?,?,?)");

            st.setString(1, student.getFirst_name());
            st.setString(2, student.getLast_name());
            st.setInt(3, student.getAge());
            st.setInt(4, student.getScore());
            st.setString(5, student.getEmail());
            st.setInt(6,student.getGroup_id());
            st.execute();
            return true;
        } catch ( SQLException throwables ) {
            throwables.printStackTrace();
        } catch ( ClassNotFoundException e ) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean addTeacher(Teachers teachers) {
        Connection con = null;
        try {
            con = dbManager.getConnection();
            PreparedStatement st = con.prepareStatement("INSERT INTO teachers(id,fname,lname,age,email,group_id,salary,subject_name) VALUES(DEFAULT,?,?,?,?,?,?,?)");

            st.setString(1, teachers.getFirst_name());
            st.setString(2, teachers.getLast_name());
            st.setInt(3, teachers.getAge());
            st.setString(4,teachers.getEmail());
            st.setInt(5, teachers.getGroup_id());
            st.setDouble(6,teachers.getSalary());
            st.setString(7,teachers.getSubject());
            st.execute();
            return true;
        } catch ( SQLException | ClassNotFoundException throwables ) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public ArrayList showAllStudents() {


        Connection con = null;

        try {
            con = dbManager.getConnection();

            PreparedStatement ps = con.prepareStatement("SELECT * FROM students");
            ResultSet resultSet = ps.executeQuery();
            ArrayList<Students> students = new ArrayList<>();
            while (resultSet.next()) {
               Students students1 = new Students(resultSet.getInt("id"),
                        resultSet.getString("fname"),
                        resultSet.getString("lname"),
                        resultSet.getInt("age"),
                        resultSet.getInt("score"),
                        resultSet.getString("email"),
                        resultSet.getInt("group_id"));

                students.add(students1);
            }
            return students;

        } catch ( Exception e ) {
            e.printStackTrace();
        }

        return null;
    }
    @Override
    public boolean removeStudentByID(int id) {

        Connection con = null;

        try {
            con = dbManager.getConnection();

            PreparedStatement ps = con.prepareStatement("DELETE FROM students WHERE id=?");

            ps.setInt(1, id);

            ps.execute();

            return true;

        } catch ( SQLException | ClassNotFoundException throwables ) {
            throwables.printStackTrace();
        } finally {
            try {
                assert con == null;
                con.close();
            } catch ( SQLException throwables ) {
                throwables.printStackTrace();
            }
        }
        return false;
    }
    @Override
    public ArrayList showTop10Students() {


        Connection con = null;

        try {
            con = dbManager.getConnection();

            PreparedStatement ps = con.prepareStatement("SELECT * FROM students ORDER BY score DESC ");
            ResultSet resultSet = ps.executeQuery();
            ArrayList<Students> students = new ArrayList<>();
            int k = 0;

            while (resultSet.next() && k<11) {
                Students students1 = new Students(resultSet.getInt("id"),
                        resultSet.getString("fname"),
                        resultSet.getString("lname"),
                        resultSet.getInt("age"),
                        resultSet.getInt("score"),
                        resultSet.getString("email"),
                        resultSet.getInt("group_id"));
                        k++;
                students.add(students1);
            }
            return students;

        } catch ( Exception e ) {
            e.printStackTrace();
        }

        return null;
    }
    @Override
    public Students getStudentByHighestScore() {
        Connection con = null;
        try {
            con = dbManager.getConnection();
            PreparedStatement st = con.prepareStatement("SELECT * FROM students WHERE score=(SELECT MAX(score) FROM students)");
            ResultSet resultSet = st.executeQuery();
            Students students = new Students();

            if(resultSet.next()) {
                Students s = new Students(resultSet.getInt("id"),
                        resultSet.getString("fname"),
                        resultSet.getString("lname"),
                        resultSet.getInt("age"),
                        resultSet.getString("email"),
                        resultSet.getInt("score"),
                        resultSet.getInt("group_id"));
                students = s;
            }
            return students;
        } catch ( SQLException throwables ) {
            throwables.printStackTrace();
        } catch ( ClassNotFoundException e ) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean changeEmailById(int id, String email, String table) {
        Connection con = null;
        try {
            con = dbManager.getConnection();
            PreparedStatement st = con.prepareStatement("UPDATE " + table + " SET email='" + email + "' WHERE id=" + id + "");
            st.execute();
            return true;
        } catch ( SQLException throwables ) {
            throwables.printStackTrace();
        } catch ( ClassNotFoundException e ) {
            e.printStackTrace();
        }
        return false;
    }
}

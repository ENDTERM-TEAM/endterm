package com.company.repositories;

import com.company.data.interfaces.IDBManager;
import com.company.entities.Groups;
import com.company.entities.Mentors;
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
        this.dbManager = dbManager;
    }

   @Override
    public boolean addStudent(Students student) {
        Connection con = null;
        try {
            con = dbManager.getConnection();
            PreparedStatement st = con.prepareStatement("INSERT INTO students(id,fname,lname,age,score,email,group_id,subject_count,with_books) VALUES(DEFAULT,?,?,?,?,?,?,?,?)");

            st.setString(1, student.getFirst_name());
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
            throwables.printStackTrace();
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
    public ArrayList<Students> showAllStudents() {


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
                        resultSet.getInt("group_id"),
                       resultSet.getInt("subject_count"),
                       resultSet.getBoolean("with_books"));


                students.add(students1);
            }
            return students;

        } catch ( SQLException | ClassNotFoundException throwables ) {
            throwables.printStackTrace();
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
        }
        return false;
    }
    @Override
    public ArrayList<Students> showTop10Students() {


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
                        resultSet.getInt("group_id"),
                        resultSet.getInt("subject_count"),
                        resultSet.getBoolean("with_books"));

                k++;
                students.add(students1);
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
            PreparedStatement st = con.prepareStatement("SELECT * FROM students WHERE score=(SELECT MAX(score) FROM students)");
            ResultSet resultSet = st.executeQuery();
            Students students = new Students();

            if(resultSet.next()) {
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
            return students;
        } catch ( SQLException | ClassNotFoundException throwables ) {
            throwables.printStackTrace();
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
            PreparedStatement st = con.prepareStatement("SELECT * FROM groups");
            ResultSet resultSet = st.executeQuery();

            ArrayList<Groups> groups = new ArrayList<>();

            while(resultSet.next()) {
                Groups group = new Groups(resultSet.getInt("g_id"),
                        resultSet.getString("name"),
                        resultSet.getString("level"),
                        resultSet.getInt("mentor_id"));
                groups.add(group);
            }
            return groups;
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
            PreparedStatement st = con.prepareStatement("SELECT * FROM mentors");
            ResultSet resultSet = st.executeQuery();

            ArrayList<Mentors> mentors = new ArrayList<>();

            while(resultSet.next()) {
                Mentors m = new Mentors(resultSet.getInt("id"),
                        resultSet.getString("fname"),
                        resultSet.getString("lname"),
                        resultSet.getInt("age"),
                        resultSet.getString("email"),
                        resultSet.getDouble("salary"));
                mentors.add(m);
            }
            return mentors;
        } catch ( SQLException | ClassNotFoundException throwables ) {
            throwables.printStackTrace();
        }
        return null;
    }
    
    @Override
    public ArrayList<Teachers> showAllTeachers() {
        Connection con = null;
        try {
            con = dbManager.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM students");
            ResultSet resultSet = ps.executeQuery();
            ArrayList<Teachers> teachers = new ArrayList<>();
            while (resultSet.next()) {
                Teachers t = new Teachers(resultSet.getInt("id"),
                        resultSet.getString("fname"),
                        resultSet.getString("lname"),
                        resultSet.getInt("age"),
                        resultSet.getString("email"),
                        resultSet.getDouble("salary"),
                        resultSet.getString("subject_name"),
                        resultSet.getInt("group_id"));
                teachers.add(t);
            }
            return teachers;
        } catch ( SQLException | ClassNotFoundException throwables ) {
            throwables.printStackTrace();
        }
        return null;
    }
}

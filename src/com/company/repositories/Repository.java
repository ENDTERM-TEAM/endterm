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
}

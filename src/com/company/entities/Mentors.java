package com.company.entities;

public class Mentors extends Member{
    public double salary;

    public Mentors(String first_name, String last_name, int age, String email, double salary) {
        super(first_name, last_name, age, email);

    }

    public Mentors(int id, String first_name, String last_name, int age, String email, double salary) {
        super(id, first_name, last_name, age, email);

    }

}

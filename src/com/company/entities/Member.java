package com.company.entities;

public class Member {
    private int id;                                                                    //Super class for all members with id
    private String first_name;                                                         //with his first name
    private String last_name;                                                          //with last name
    private String email;                                                              //with email and age
    private int age;
    
    //Constructors
    public Member(){                                                                   //empty constructor
    }

    public Member(int id,String first_name, String last_name, String email,int age) {  //full constructor
        setId(id);
        setFirst_name(first_name);
        setLast_name(last_name);
        setEmail(email);
        setAge(age);
    }

    public Member(String first_name, String last_name, String email,int age) {         //constructor without id, in some tables id is serial
        setFirst_name(first_name);
        setLast_name(last_name);
        setEmail(email);
        setAge(age);
    }
    
    //Getters and setters od all variables
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return getFirst_name() + ' ' + getLast_name() + " , id: " + id
                + ", age: " + age + ", email: " + email;                                           //Method toString to show all variables
    }
}

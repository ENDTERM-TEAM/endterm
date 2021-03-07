package com.company.entities;

public class Teachers extends Member{
    public double salary;
    private String subject_name;
    private int group_id;
    
    public Teachers(int id,String first_name,String last_name,int age,String email,double salary,String subject_name,int group_id) {
        super(id, first_name, last_name, email, age);
        setSubject(subject_name);
        setSalary(salary);
        setGroup_id(group_id);
    }

    public Teachers(String first_name, String last_name, int age, String email, int group_id, double salary, String subject_name) {
        super(first_name,last_name,email,age);
        setGroup_id(group_id);
        setSalary(salary);
        setSubject(subject_name);
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }
    
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getSubject() {
        return subject_name;
    }

    public void setSubject(String subject_name) {
        this.subject_name = subject_name;
    }
    
    @Override
    public String work() {
        return ", is working as teacher";
    }
    @Override
    public String getSalaries() {
        return ", is salary="+salary;
    }

    @Override
    public String toString() {
        return super.toString() + getSalaries() + work() + "\n";
    }
}

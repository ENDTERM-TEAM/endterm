package com.company.entities;

public class Mentors extends Member implements IWorker{
    public double salary;

    public Mentors(String first_name, String last_name, int age, String email, double salary) {
        super(first_name, last_name, age, email);
        setSalary(salary);
    }

    public Mentors(int id, String first_name, String last_name, int age, String email, double salary) {
        super(id, first_name, last_name, age, email);
        setSalary(salary);
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    public double getSalary() {
        return salary;
    }
    
    @Override
    public String work() {
        return ", is working as mentor";
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

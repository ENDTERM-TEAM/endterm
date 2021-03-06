package com.company.entities;

import com.company.entities.interfaces.IWorker;

public class Mentors extends Member implements IWorker{
    public double salary;

    public Mentors(String first_name, String last_name, int age, String email, double salary) {                            //creating constructors
        super(first_name, last_name, email,age);
        setSalary(salary);
    }

    public Mentors(int id, String first_name, String last_name, int age, String email, double salary) {                    //creating constructors
        super(id, first_name, last_name, email,age);
        setSalary(salary);
    }

    public void setSalary(double salary) {                                                                                  //setter
        this.salary = salary;
    }

    public double getSalary() {                                                                                             //getter
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

    @Override                                                                                                               //toString method to show all variables
    public String toString() {
        return super.toString() + getSalaries() + work() + "\n";
    } 
}

package com.company.entities;

public class Teachers extends Member{
    private int group_id;

    public Teachers () {}

    public Teachers (String first_name, String last_name, int age, String email, int group_id) {
        super(first_name, last_name, age, email);
    }

    public Teachers(int id, String first_name, String last_name, int age, String email, int group_id) {
        super(id, first_name, last_name, age, email);
        this.group_id = group_id;
    }
    
    public double getSalary() {
        return salary;
    }
    
    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
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

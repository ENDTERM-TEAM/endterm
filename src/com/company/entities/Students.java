package com.company.entities;

import com.company.entities.interfaces.IStudent;

public class Students extends Member implements IStudent {
    private int score;
    private int group_id;

    public Students() {
    }

    public Students(String first_name, String last_name, int age, String email, int score, int group_id) {
        super(first_name, last_name, age, email);
        this.score = score;
        this.group_id = group_id;
    }

    public Students(int id, String first_name, String last_name, int age, String email, int score, int group_id) {
        super(id, first_name, last_name, age, email);
        this.score = score;
        this.group_id = group_id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    @Override
    public String study() {
        return ", is student of group ";
    }

    @Override
    public String test() {
        return null;
    }

    @Override
    public String toString() {
        return super.toString() + ", score: " + score  + study() + group_id;
    }
}

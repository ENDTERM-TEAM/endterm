package com.company.entities;

import com.company.entities.interfaces.IStudent;

public class Students extends Member implements IStudent {
    private int score;
    private int group_id;
    private int subject_count;
    private boolean with_books;
    
    public Students(int id,String first_name,String last_name,int age,int score,String email,int group_id,int subject_count,boolean with_books) {
        super(id, first_name, last_name, email, age);
        setSubject_count(subject_count);
        setWith_books(with_books);
        setScore(score);
        setGroupID(group_id);
    }

    public Students(String first_name, String last_name, int age, int score, String email, int group_id, int subject_count, boolean with_books) {
        super(first_name, last_name, email, age);
        setSubject_count(subject_count);
        setWith_books(with_books);
        setScore(score);
        setGroupID(group_id);
    }
    public Students(){
        super(); 
    }
    
    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public int getSubject_count() {
        return subject_count;
    }

    public void setSubject_count(int subject_count) {
        this.subject_count = subject_count;
    }
    
    public boolean isWith_books() {
        return with_books;
    }

    public void setWith_books(boolean with_books) {
        this.with_books = with_books;
    }
    
    public int getGroupID() {
        return group_id;
    }

    public void setGroupID(int group_id) {
        this.group_id = group_id;
    }
    
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    @Override
    public String study() {
        return ", is student of group ";
    }

    @Override
    public String test() {
        return ", have passed the test with score " + score;
    }

    @Override
    public String costOfStudy() {
        return ", the cost of study " + (subject_count*9000)+((with_books) ? 12500 : 0);
    }

    @Override
    public String toString() {
      return  " \n " + super.toString() + test() + study() + group_id + costOfStudy();
    }
}

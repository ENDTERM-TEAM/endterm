package com.company.entities;

import com.company.entities.interfaces.IStudent;

public class Students extends Member implements IStudent {
    private int score;
    private int group_id;
    private int subject_count;
    private boolean with_books;
    
    public Students(int id,String first_name,String last_name,int age,int score,String email,int group_id,int subject_count,boolean with_books) {       //creating constructors
        super(id, first_name, last_name, email, age);
        setSubject_count(subject_count);
        setWith_books(with_books);
        setScore(score);
        setGroupID(group_id);
    }

    public Students(String first_name, String last_name, int age, int score, String email, int group_id, int subject_count, boolean with_books) {       //creating constructors
        super(first_name, last_name, email, age);
        setSubject_count(subject_count);
        setWith_books(with_books);
        setScore(score);
        setGroupID(group_id);
    }
    public Students(){                                                                                                                                  //creating constructors
        super(); 
    }
    
    public int getGroup_id() {                                                                                                                          //getter
        return group_id;
    }

    public void setGroup_id(int group_id) {                                                                                                             //setter                                          
        this.group_id = group_id;
    }
                    
    public int getSubject_count() {                                                                                                                     //getter                                                             
        return subject_count; 
    }

    public void setSubject_count(int subject_count) {                                                                                                    //setter
        this.subject_count = subject_count;
    }
    
    public boolean isWith_books() {                                                                                                                       //getter
        return with_books;
    }

    public void setWith_books(boolean with_books) {                                                                                                      //setter
        this.with_books = with_books;
    }
    
    public int getGroupID() {                                                                                                                            //getter
        return group_id;
    }
 
    public void setGroupID(int group_id) {                                                                                                              //setter
        this.group_id = group_id;
    }
    
    public int getScore() {                                                                                                                             //getter
        return score;
    }

    public void setScore(int score) {                                                                                                                    //setter
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

    @Override                                                                                                                //method, which is counting the cost of subject counts
    public String costOfStudy() {                                                                                            //each subject price is 9000tg, if student wants additional
        return ", the cost of study " + (subject_count*9000)+((with_books) ? 12500 : 0);                                     //books, its 12 500 tg added, if not 0
    }

    @Override
    public String toString() {
      return  " \n " + super.toString() + test() + study() + group_id + costOfStudy();                                       //ToString method to show all variables
    }
}

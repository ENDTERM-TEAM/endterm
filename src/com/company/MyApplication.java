package com.company;

import com.company.controllers.Controller;

import java.util.Scanner;

public class MyApplication {
    private final Controller controller;
    private final Scanner scanner;

    public MyApplication(Controller controller) {
        this.controller = controller;
        scanner = new Scanner(System.in);
    }

    public void start() {
         System.out.println("Welcome to Educational center 'Brainstorm'! ");
         while (true) {
            System.out.println("Choose one option:\n 1) Add new student \n " + "2) Add new teacher \n " + "3) Show all students \n "
                    + "4) Remove student by id \n " + "5) Show Top 10 Students \n "+ "6) Get Student By Highest Score Menu \n "
                    + "7) Change Email By Id Menu \n "  + "8) Show all groups Menu \n "+ "0) Exit\n");
            int choice = scanner.nextInt();

            if (choice == 1) {
                addStudent();
            }
            else if(choice==2){
                addTeacher();
                }
            else if(choice==3){
                showAllStudents();
            }
            else if(choice==4){
               removeStudentById();
            }
            else if(choice==5){
                showTop10Students();
            }
            else if(choice==6){
                getStudentByHighestScoreMenu();
            }
            else if(choice==7){
                changeEmailByIdMenu();
            }
            else if(choice==8){
                showAllGroupsMenu();
            }
            else {
                break;
            }

            System.out.println("____________________________");
        }
    }

   public void addStudent() {
        System.out.println("Write Student's first name");
        String first_name = scanner.next();
        System.out.println("Write Student's last name");
        String last_name = scanner.next();
        System.out.println("Write Student's age!");
        int age = scanner.nextInt();
        System.out.println("Write Student's score");
        int score = scanner.nextInt();
        System.out.println("Write Student email");
        String email = scanner.next();
        System.out.println("Write Student's group id");
        int group_id = scanner.nextInt();
        System.out.println("What package do you prefer? \n1) One subject \n2) Two subjects \n3) Three subjects \n4) Four subjects \n5) All subjects ");
        int subject_count=scanner.nextInt();
        System.out.println("Do you need the books? (Yes/No)");
        boolean with_books = (scanner.next() == "Yes");
            
        String result;
        result = controller.addStudent(first_name,last_name,age,score,email,group_id,subject_count,with_books);
        System.out.println(result);
    }

    public void addTeacher() {
        System.out.println("Write Teacher's first name");
        String first_name = scanner.next();
        System.out.println("Write Teacher's last name");
        String last_name = scanner.next();
        System.out.println("Write Teacher's age!");
        int age = scanner.nextInt();
        System.out.println("Write Teacher email");
        String email = scanner.next();
        System.out.println("Write Teacher's group id");
        int group_id = scanner.nextInt();
        System.out.println("Write Teacher's salary");
        Double salary = scanner.nextDouble();
        System.out.println("Write Teacher's subject name");
        String subject_name = scanner.next();
        
        String result;
        result = controller.addTeacher(first_name,last_name,age,email,group_id,salary,subject_name);
        System.out.println(result);
    }
    
    public void showAllStudents() {
        ArrayList<Students> result1 = controller.showAllStudents();
        System.out.println("Students:");
        System.out.println(result1);
    }
    
    public void removeStudentById() {
        System.out.println("Write employee's id!");
        int id = scanner.nextInt();
        
        String result = String.valueOf(controller.removeStudentById(id));
        System.out.println(result);
    }
    
    public void showTop10Students() {
        ArrayList<Students> result1 = controller.showTop10Students();
        System.out.println("Top 10 students:");
        System.out.println(result1);
    }
    
    public void getStudentByHighestScoreMenu() {
        System.out.println(controller.getStudentByHighestScore());
    }

    public void changeEmailByIdMenu() {
        System.out.println("Please write where do you want to change email(students, mentors, teachers)");
        String table = scanner.next();
        System.out.println("Please write an id");
        int id = scanner.nextInt();
        System.out.println("Please write a new email");
        String email = scanner.next();
        System.out.println(controller.changeEmailById(id,email,table));
    }
    
    public void showAllGroupsMenu() {
        controller.showAllGroups();
    }
}

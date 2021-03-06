package com.company;

import com.company.controllers.Controller;

import java.util.Scanner;

public class MyApplication {
    private final Controller centreController;
    private final Scanner scanner;

    public MyApplication(Controller centreController) {
        this.centreController = centreController;
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("Choose one option:\n 1) Add new student \n " + "2) Study \n " + "0) Exit\n");
            int choice = scanner.nextInt();

            if (choice == 1) {
                addStudent();
            }
            else if(choice==2){

            }
            else {
                break;
            }

            System.out.println("____________________________");
        }
    }

    public void addStudent(){
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

        String result;
        result = centreController.addStudent(first_name,last_name,age,email,score,group_id);

        System.out.println(result);
    }
}

package com.company;

import com.company.controllers.Controller;
import com.company.data.DBManager;
import com.company.data.interfaces.IDBManager;
import com.company.repositories.Repository;
import com.company.repositories.interfaces.IRepository;

public class Main {

    public static void main(String[] args) {
        IDBManager dbManager = new DBManager();
        IRepository studentRep = new Repository(dbManager);
        Controller centreController = new Controller(studentRep);
        MyApplication application = new MyApplication(centreController);
        application.start();
    }
}

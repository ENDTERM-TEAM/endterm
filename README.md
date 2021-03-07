Endterm project 'Educational center'
=============================

This project concerns the organization of the educational center 'Brainstorm' 
with the aim of reducing all paperwork and digitizing the details of those who work and study there.

STUDENTS CLASS
------------

In this class, all information about students that will be used in further procedures of the center itself. 
Class extends super class Member which already has data such as:
      
      VARIABLE NAME        DATA TYPE IN JAVA       DATA TYPE IN SQL
      ------------         ------------            ------------
      id                   integer                 serial (PK)
      first name           String                  VARCHAR
      last name            String                  VARCHAR
      age                  integer                 integer
      email                String                  VARCHAR
      score                integer                 integer
      group_id             integer                 integer(FK) 
      subject_count        integer                 integer
      with_books           boolean                 boolean
      
      
And also implements the IStudent interface where there are methods such as:

     study, test, costOfStudy.
     

GROUPS CLASS
------------

In this class, all information about groups of students, in order to manage with students easily 
The list of data there:

      VARIABLE NAME        DATA TYPE IN JAVA       DATA TYPE IN SQL
      ------------         ------------            ------------
      id                   integer                 integer (PK)
      name                 String                  VARCHAR
      level                String                  VARCHAR
      mentor_id            integer                 integer(FK) 
      
      
TEACHERS CLASS
-----------

In this class, all information about teachers, who is educating one exact subject, and have several groups of students, and info that will be used in further procedures of the center itself.
The list of data there:

      VARIABLE NAME        DATA TYPE IN JAVA       DATA TYPE IN SQL
      ------------         ------------            ------------
      id                   integer                 serial (PK)
      first name           String                  VARCHAR
      last name            String                  VARCHAR
      age                  integer                 integer
      email                String                  VARCHAR
      salary               integer                 integer
      group_id             integer                 integer (FK) 
      subject_name         String                  VARCHAR


And also implements the IWorker interface where there are methods such as:


     work, getSalaries.



MENTORS CLASS
-----------

In this class, all information about mentors, who is leading and helping group of students, and info that will be used in further procedures of the center itself. 
The list of data there:

      VARIABLE NAME        DATA TYPE IN JAVA       DATA TYPE IN SQL
      ------------         ------------            ------------
      id                   integer                 serial (PK)
      first name           String                  VARCHAR
      last name            String                  VARCHAR
      age                  integer                 integer
      email                String                  VARCHAR
      salary               integer                 integer
   
   
 And also implements the IWorker interface where there are methods such as:

      work, getSalaries.  
 
 
     

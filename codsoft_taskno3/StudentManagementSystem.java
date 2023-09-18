package com.karthi;

import java.sql.SQLException;
import java.util.Scanner;

public class StudentManagementSystem {

	static Scanner sc =new Scanner(System.in);
	Store st = new Store();
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        boolean status = true ;
        do {
            System.out.println("--------------------------------------------");
            System.out.println("1. Add Student data");
            System.out.println("2. Display student data");
            System.out.println("3. Remove Student data");
            System.out.println("4: Update student data");
            System.out.println("5: Exit");
            System.out.println("--------------------------------------------");
            int ch = sc.nextInt();
            System.out.println("--------------------------------------------");

            switch (ch)
            {
                case 1 :
                    addStudent();
                    break;
                case 2:
                	displayStudent();
                	break;
                case 3:
                	removestudent();
                	break;
                case 4:
                	updatestudent();
                	break;
                case 5 :
                    status = false;
                    break;

                default:
                    System.out.println("Invalid Input !!");
            }

        }while (status);
    }
private static void addStudent() throws ClassNotFoundException, SQLException{
	Store st = new Store();
	st.add();
	}
private static void displayStudent() throws ClassNotFoundException, SQLException{
	Store st = new Store();
	st.display();
	}
private static void removestudent() throws ClassNotFoundException, SQLException{
	Store st = new Store();
	st.remove();
	}
private static void updatestudent() throws ClassNotFoundException, SQLException{
	Store st = new Store();
	st.update();
	}

}

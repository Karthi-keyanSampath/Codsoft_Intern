package com.karthi;

import java.util.Scanner;

public class StudentGradeCalculator {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter name:");
        String name = sc.nextLine();
        System.out.println("enter rollno:");
        long roll_no = sc.nextLong();
        System.out.print("Enter the number of subjects: ");
        int sub = sc.nextInt();
        sc.nextLine();

        int Total = 0;
        double avgper;

        for (int i = 1; i <= sub; i++) {
            System.out.print("Enter marks obtained in subject " + i + " (out of 100): ");
            int marks = sc.nextInt();
            Total += marks;
        }

        avgper = (double) Total / (sub * 100) * 100;

        String grade;
        if (avgper >= 90) {
            grade = "0";
        } else if (avgper >= 80) {
            grade = "A+";
        } else if (avgper >= 70) {
            grade = "A";
        } else if (avgper >= 60) {
            grade = "B+";
        } else if (avgper >= 50) {
            grade = "B";
        } else {
            grade = "F";
        }

        System.out.println("Name: " + name);
        System.out.println("Roll no: " + roll_no);
        System.out.println("Total Marks: " + Total);
        System.out.println("Average Percentage: " + avgper + "%");
        System.out.println("Grade: " + grade);

        sc.close();
    }

}

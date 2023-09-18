package com.kar;

import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args)
    {
    	Scanner sc = new Scanner(System.in);
        Random rd = new Random();
   
        int max = 10,r = 1, score = 0,total=0;
        boolean play = true;
        
        System.out.println("Welcome to the Number Game!\n");
        int maxRange = 100;
        int minRange =1;
        while (play)
        {
        	int generatedno = rd.nextInt(maxRange - minRange + 1) + minRange;
            System.out.println("I've selected a number between " + minRange + " and " + maxRange + ". Try to guess it!");
        	System.out.println("++++++++++++++++++++++++++++++");
            System.out.println("\nRound " + r + ":");
            int left = 0;
            boolean match = false;

            while (!match && left < max)
            {
            	System.out.print("Attempt " + left + "/" + max + ": Enter your guess: ");
                int userno = sc.nextInt();
                left++;

                if (userno == generatedno)
                {
                    System.out.println("You guessed it right,it was " + generatedno + "!!!\nYou guessed it in " + left + " attempts.");
                    score = score + (max-left)*10;
                    match = true;
                } 
                else if (userno < generatedno)
                {
                    System.out.println("too low! Try again.");
                }
                else
                {
                    System.out.println("too high! Try again.");
                }
            }

            if (!match)
            {
                System.out.println("\nOut of attempts! The correct number was: " + generatedno);
            }
            total = total + 100;
            r++;

            System.out.printf("\nDo you want to continue to round %d? (yes/no): ",r);
            String choice = sc.next();
            play = choice.equalsIgnoreCase("yes");
        }
        System.out.printf("Game ends\nYour total score is: %d/%d", score,total);
        sc.close();
    }

}

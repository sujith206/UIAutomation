package com.automation.practise;

import java.util.Scanner;

public class EvenOdd {
    public static void main(String[] args) {
        int numberValue;
        // input through command line
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        numberValue = sc.nextInt();
        sc.close();
        // check if the number is even or odd
        if(numberValue%2==0){
            System.out.println("The number is even");
        }else {
            System.out.println("The number is odd");
        }
    }
}

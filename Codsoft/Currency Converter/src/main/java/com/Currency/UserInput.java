package com.currency;

import java.util.Scanner;

public class UserInput {
    private Scanner sc = new Scanner(System.in);

    public String getCurrency(String message) {
        System.out.print(message);
        return sc.next().toUpperCase();
    }

    public double getAmount() {
        System.out.print("Enter amount: ");
        return sc.nextDouble();
    }

    public boolean playAgain() {
        System.out.print("Convert again? (y/n): ");
        char ch = sc.next().charAt(0);
        return ch == 'y' || ch == 'Y';
    }
}
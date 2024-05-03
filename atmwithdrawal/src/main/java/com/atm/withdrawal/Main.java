package com.atm.withdrawal;

public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM();
        try {
            atm.withdraw(230);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
    }
}
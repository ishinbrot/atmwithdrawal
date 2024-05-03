package com.atm.withdrawal;
import java.util.HashMap;
import java.util.Map;


public class ATM {
    private Map<Integer, Integer> amountMap;

    public ATM() {
        // IPrset the ATM with a starting amount
        amountMap = new HashMap<>();
        // Let's assumne amounts available are 10, 20, 50, 100
        amountMap.put(10, 100); // 100 dollars of 10 bills
        amountMap.put(20, 50);  // 50 dollars of 20 bills
        amountMap.put(50, 20);  // 20 dollars of 50 bills
        amountMap.put(100, 10); // 10 dollars of 100 bills
    }

    public void withdraw(int amount) throws InsufficientFundsException {
        // Check if the amount to withdraw is a multiple of 10
        if (amount % 10 != 0) {
            throw new IllegalArgumentException("Amount must be multiple of 10");
        }

        // Check if ATM has enough cash
        if (!isEnoughCashAvailable(amount)) {
            throw new InsufficientFundsException("ATM does not have enough cash to dispense");
        }
        // Dispense cash
        cashWithdrawl(amount);
    }

    // Check if enough cash is available in the ATM
    private boolean isEnoughCashAvailable(int amount) {
        int remainingAmount = amount;
        for (Map.Entry<Integer, Integer> amouEntry : amountMap.entrySet()) {
            int amountValue = amouEntry.getKey();
            int amountCount = amouEntry.getValue();
            int notesNeeded = remainingAmount / amountValue;
            if (notesNeeded > amountCount) {
                remainingAmount -= amountCount * amountValue;
            } else {
                remainingAmount %= amountValue;
            }
            if (remainingAmount == 0) 
            {
                return true;
            }
        }
        return false;
    }

    private void cashWithdrawl(int amount) {
        int remainingAmount = amount;
        for (Map.Entry<Integer, Integer> denomination : amountMap.entrySet()) {
            int amountValue = denomination.getKey();
            int amountCount = denomination.getValue();
            int notesNeeded = remainingAmount / amountValue;
            if (notesNeeded > amountCount) {
                notesNeeded = amountCount;
            }
            System.out.println("Dispensing " + notesNeeded + " notes of " + amountValue);
            remainingAmount -= notesNeeded * amountValue;
            amountCount -= notesNeeded;
            amountMap.put(amountValue, amountCount);
            if (remainingAmount == 0) break;
        }
    }
}


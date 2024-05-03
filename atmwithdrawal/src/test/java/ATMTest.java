import org.junit.jupiter.api.Test;

import com.atm.withdrawal.ATM;
import com.atm.withdrawal.InsufficientFundsException;


import static  org.junit.jupiter.api.Assertions.*;

public class ATMTest {
    // Ensure I can withdraw money
    @Test
    public void testWithdrawal() {
        ATM atm = new ATM();
        assertDoesNotThrow(() -> atm.withdraw(200));
    }

    // Ensure I have insufficient funds
    @Test
    public void testWithdrawalInsufficientFunds() {
        ATM atm = new ATM();
        assertThrows(InsufficientFundsException.class, () -> atm.withdraw(100000));
    }

        // ensure i withdraw a multiple of 10
    @Test
    public void testWithdrawalNonMultipleOfTen() {
        ATM atm = new ATM();
        assertThrows(IllegalArgumentException.class, () -> atm.withdraw(205));
    }
}

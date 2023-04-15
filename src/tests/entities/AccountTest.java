package tests.entities;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import entities.Account;
import tests.factory.AccountFactory;

class AccountTest {

	@Test
	void testDepositShouldIncreaseBalanceAndDiscountFeeWhenPositiveAmount() {
		double amount = 200D;
		double expectedValue = 196D;
		Account acc = AccountFactory.createEmptyAccount();
		
		acc.deposit(amount);
		
		assertEquals(expectedValue, acc.getBalance());
	}
	
	@Test
	public void testDepositShouldDoNothingWhenNegativeAmount() {
		double expectedValue = 100D;
		Account acc = AccountFactory.createAccount(expectedValue);
		double amount = -200D;
		
		acc.deposit(amount);
		
		assertEquals(expectedValue, acc.getBalance());
	}

	@Test
	public void testFullWithdrawShouldClearBalanceAndReturnFullBalance() {
		double expectedValue = 0D;
		double initialBalance = 800D;
		Account acc = AccountFactory.createAccount(initialBalance);
		
		double result = acc.fullWithdraw();
		
		assertTrue(expectedValue == acc.getBalance());
		assertTrue(result == initialBalance);
	}
	
	@Test
	public void testWithdrawShouldDecreaseBalanceWhenSufficientBalance() {
		Account acc = AccountFactory.createAccount(800D);
		
		acc.withdraw(500D);
		
		assertEquals(300D, acc.getBalance());
	}
	
	@Test
	public void testWithdrawShouldThrowExceptionWhenInsufficientBalance() {
		assertThrows(IllegalArgumentException.class, () -> {
			Account acc = AccountFactory.createAccount(800D);
			acc.withdraw(801D);
		});
	}
	
}

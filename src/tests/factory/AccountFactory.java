package tests.factory;

import entities.Account;

public class AccountFactory {

	public static Account createEmptyAccount() {
		return new Account(1L, 0D);
	}
	
	public static Account createAccount(double initialBalance) {
		return new Account(1L, initialBalance);
	}
}

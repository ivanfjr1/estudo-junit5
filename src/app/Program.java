package app;

import entities.Financing;

public class Program {
	public static void main(String[] args) {
		Financing financing = new Financing(100000D, 2000D, 20);
		financing.getMonths();
	}
}

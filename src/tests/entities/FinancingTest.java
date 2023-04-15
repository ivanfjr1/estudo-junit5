package tests.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import entities.Financing;

class FinancingTest {

	@Test
	void testConstructorShouldCreateObjectWhenValidData() {
		Financing financing = new Financing(100000D, 2000D, 80);
		
		assertEquals(100000D, financing.getTotalAmount());
		assertEquals(2000D, financing.getIncome());
		assertEquals(80, financing.getMonths());
	}
	
	@Test
	void testConstructorShouldThrowIllegalArgumentExceptionWhenInvalidData() {		
		assertThrows(IllegalArgumentException.class, () -> {
			new Financing(100000D, 2000D, 20);
		});
	}
	
	@Test
	void testTotalAmountShouldSetDataWhenValidData() {
		Financing financing = new Financing(100000D, 2000D, 80);
		
		financing.setTotalAmount(90000D);
		
		assertEquals(90000D, financing.getTotalAmount());
		assertEquals(2000D, financing.getIncome());
		assertEquals(80, financing.getMonths());
	}
	
	@Test
	void testTotalAmountShouldThrowIllegalArgumentExceptionWhenInvalidData() {		
		assertThrows(IllegalArgumentException.class, () -> {
			Financing financing = new Financing(100000D, 2000D, 80);
			financing.setTotalAmount(110000D);
		});
	}
	
	@Test
	void testIncomeShouldSetDataWhenValidData() {
		Financing financing = new Financing(100000D, 2000D, 80);
		
		financing.setIncome(2100D);
		
		assertEquals(2100D, financing.getIncome());
	}
	
	@Test
	void testIncomeShouldThrowIllegalArgumentExceptionWhenInvalidData() {		
		assertThrows(IllegalArgumentException.class, () -> {
			Financing financing = new Financing(100000D, 2000D, 80);
			financing.setIncome(1900D);
		});
	}
	
	@Test
	void testMonthsShouldSetDataWhenValidData() {
		Financing financing = new Financing(100000D, 2000D, 80);
		
		financing.setMonths(81);
		
		assertEquals(81, financing.getMonths());
	}
	
	@Test
	void testMonthsShouldThrowIllegalArgumentExceptionWhenInvalidData() {		
		assertThrows(IllegalArgumentException.class, () -> {
			Financing financing = new Financing(100000D, 2000D, 80);
			financing.setMonths(79);
		});
	}
	
	@Test
	public void testEntryShouldCalculateEntryCorrectly() {
		Financing financing = new Financing(100000D, 2000D, 80);
		
		assertEquals(20000D, financing.entry());
	}

	@Test
	public void testQuotaShouldCalculateQuotaCorrectly() {
		Financing financing = new Financing(100000D, 2000D, 80);
		
		assertEquals(1000D, financing.quota());
	}
	
}

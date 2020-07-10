package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import machineManager.Refund;

public class RefundTest {

	@Test
	public void testOne() {
		Refund refund = new Refund(3.9);
		// Pass if change was returned right
		assertEquals("Refund:\nCoins of 2 : 1\nCoins of 1 : 1\nCoins of 0.5 : 1\nCoins of 0.2 : 2", refund.getRefund());
	}

	@Test
	public void testTwo() {
		Refund refund = new Refund(4.8);
		// Pass if change was returned right
		assertEquals("Refund:\nCoins of 2 : 2\nCoins of 0.5 : 1\nCoins of 0.2 : 1\nCoins of 0.1 : 1", refund.getRefund());
	}
}
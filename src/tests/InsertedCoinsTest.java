package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import machineManager.AmountKeeper;
import machineManager.InsertCoin;

public class InsertedCoinsTest {
	
	private AmountKeeper amountKeeper = new AmountKeeper();
	private InsertCoin insertCoin = new InsertCoin(amountKeeper);
	
	@Test
	public void test() {
		// Add some valid coins
		insertCoin.insert("0.1");
		insertCoin.insert("0.2");
		insertCoin.insert("0.5");
		insertCoin.insert("1");
		insertCoin.insert("1.0");
		
		// Pass if all valid coins are added
		assertEquals("2.8", Double.toString(amountKeeper.getAmount()));
		
		// Add no valid coins
		// Warning windows will appear
		insertCoin.insert("1.5");
		insertCoin.insert("5");
		insertCoin.insert("-");
	}

}

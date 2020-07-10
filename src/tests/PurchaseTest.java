package tests;

import static org.junit.Assert.*;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

import org.junit.Test;

import guiMainEngine.Gui;
import machineManager.AmountKeeper;
import machineManager.MakePurchase;

public class PurchaseTest {

	private AmountKeeper amountKeeper = new AmountKeeper();
	private Gui gui = new Gui();
	private JRadioButton Water;
	private ButtonGroup products;
	
	@Test
	public void test() {
		amountKeeper.setAmount(4.6);
		products = gui.getProducts();
		Water = gui.getWaterProduct();
		Water.setSelected(true);

		MakePurchase makePurchase = new MakePurchase(amountKeeper, products);
		makePurchase.purchase();
		String lines[] = makePurchase.getPurchaseMade().split("\\r?\\n");
		
		// Pass if correct item was returned and the new total amount is correct
		assertEquals("You Bought Water", lines[0]);
		assertEquals(0, amountKeeper.getAmount(), 0.01);
		// Change no need to test here
	}
	
	@Test
	public void testTwo() {
		amountKeeper.setAmount(0.2);
		products = gui.getProducts();
		Water = gui.getWaterProduct();
		Water.setSelected(true);

		MakePurchase makePurchase = new MakePurchase(amountKeeper, products);
		makePurchase.purchase();
		
		// Pass if detects that amount is low and the new total amount remain the same
		assertEquals("Not enough money", makePurchase.getPurchaseMade());
		assertEquals(0.2, amountKeeper.getAmount(), 0.01);
	}

}

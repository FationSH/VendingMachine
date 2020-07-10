package tests;

import static org.junit.Assert.*;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import org.junit.Test;

import machineManager.Reset;
import machineManager.AmountKeeper;
import guiMainEngine.Gui;

public class ResetTest {

	private AmountKeeper amountKeeper = new AmountKeeper();
	private Gui gui = new Gui();
	private JRadioButton Water;
	private ButtonGroup products;
	private final JLabel amountLabel = new JLabel();
	
	@Test
	public void test() {
		amountKeeper.setAmount(4.6);
		Water = gui.getWaterProduct();
		Water.setSelected(true);
		
		// Print to check if assignment was successful
		System.out.println("Amount:" + amountKeeper.getAmount());
		products = gui.getProducts();
		if (products.getSelection()!=null) {
			String selectedProduct = products.getSelection().getActionCommand();
			System.out.println(selectedProduct);
		}
		
		new Reset(amountKeeper, amountLabel, products);
		
		// Pass if total amount is 0 and no product is selected
		assertEquals(0, amountKeeper.getAmount(), 0.01);
		assertEquals(null, products.getSelection());
		
	}

}

package machineManager;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

/**
 * Class to implement transaction if possible returns product
 * and change.
 */

public class MakePurchase {

	private double amount;
	private AmountKeeper amountKeeper;
	private String selectedProduct;
	private ButtonGroup products;
	private String purchaseMade;
	
	public MakePurchase(AmountKeeper amountKeeper, ButtonGroup products) {
		this.amountKeeper = amountKeeper;
		this.products = products;
	}
	
	public void purchase(){
		if (products.getSelection()!=null) {
			selectedProduct = products.getSelection().getActionCommand();
			amount = amountKeeper.getAmount();
			switch(selectedProduct) {
				case "Water":
					if (checkTransaction(0.5)) {
						Refund refund = new Refund(amount);
						purchaseMade = "You Bought Water\n" + refund.getRefund();
						JOptionPane.showMessageDialog(null, purchaseMade);
						res();
					}
					break;
				case "Coke_330":
					if (checkTransaction(1.0)) {
						Refund refund = new Refund(amount);
						purchaseMade = "You Bought Coke 330ml\n" + refund.getRefund();
						JOptionPane.showMessageDialog(null, purchaseMade);
						res();
					}
					break;
				case "Coke_500":
					if (checkTransaction(1.5)) {
						Refund refund = new Refund(amount);
						purchaseMade = "You Bought Coke 500ml\n" + refund.getRefund();
						JOptionPane.showMessageDialog(null, purchaseMade);
						res();
					}
					break;
				case "Crunch":
					if (checkTransaction(2.5)) {
						Refund refund = new Refund(amount);
						purchaseMade = "You Bought Crunch\n" + refund.getRefund();
						JOptionPane.showMessageDialog(null, purchaseMade);
						res();
					}
					break;
			}
		} else {
			JOptionPane.showMessageDialog(null, "Select Product");
		}
	}
	
	/**
	 * Check if transaction is possible.
	 * @param price of the product that is selected.
	 * @return true if transaction possible.
	 */
	private boolean checkTransaction(double price) {
		if (amount >= price) {
			amount -= price;
			amountKeeper.setAmount(amount);
			return true;
		} else {
			purchaseMade = "Not enough money";
			JOptionPane.showMessageDialog(null, purchaseMade);
			return false;
		}
	}
	
	private void res() {
		amountKeeper.setAmount(0.0);
		products.clearSelection();
	}
	
	// Getter for test reason
	public String getPurchaseMade() {
		return purchaseMade;
	}
}

package machineManager;

/**
 * This class keeps the total amount of money that
 * are inserted in machine.
 */

public class AmountKeeper {
	
	private double amount;
	
	public AmountKeeper() {
		 this.amount = 0.0;
	}	
	
	// Round for errors in representable double-precision value
	public void addCoin(double coin) {
		amount = Math.round((amount+coin)*100.0)/100.0;
	}
	
	// Setters
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	// Getters
	public double getAmount() {
		return amount;
	}
	
	
}

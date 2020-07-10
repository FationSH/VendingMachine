package machineManager;

/**
 * Computes the least amount of coins to be returned.
 */

public class Refund {

	private String refund = "Refund:";
	
	public Refund(double totalAmount) {
		if (totalAmount == 0) {
			refund = refund + " 0";
		} else {
			int coins_of_2 = (int)(totalAmount/2);
			if (coins_of_2 != 0) {
				refund = refund + "\nCoins of 2 : " + coins_of_2;
				totalAmount -= coins_of_2*2;
			}
			int coins_of_1 = (int)(totalAmount/1);
			if (coins_of_1 != 0) {
				refund = refund + "\nCoins of 1 : " + coins_of_1;
				totalAmount -= coins_of_1;
			}
			// Round for errors in representable double-precision value
			int coins_of_50 = (int)(Math.round((totalAmount/0.5)*100.0)/100.0);
			if (coins_of_50 != 0) {
				refund = refund + "\nCoins of 0.5 : " + coins_of_50;
				totalAmount -= coins_of_50*0.5;
			}
			int coins_of_20 = (int)(Math.round((totalAmount/0.2)*100.0)/100.0);
			if (coins_of_20 != 0) {
				refund = refund + "\nCoins of 0.2 : " + coins_of_20;
				totalAmount -= coins_of_20*0.2;
			}
			int coins_of_10 = (int)(Math.round((totalAmount/0.1)*100.0)/100.0);
			if (coins_of_10 != 0) {
				refund = refund + "\nCoins of 0.1 : " + coins_of_10;
				totalAmount -= coins_of_10*0.1;
			}
		}
	}
	
	/**
	 * @return A string with the change.
	 */
	public String getRefund() {
		return refund;
	}
	
}

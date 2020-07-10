package machineManager;

import javax.swing.JOptionPane;

/**
 * Insert into the machine the coins that are acceptable.
 */

public class InsertCoin {

	private AmountKeeper amountKeeper;
	
	public InsertCoin(AmountKeeper amountKeeper) {
		this.amountKeeper = amountKeeper;
	}
	
	public void insert(String coin) {
		if (coin.equals("0.1") || coin.equals("0.2") || coin.equals("0.5") || coin.equals("1") || coin.equals("1.0") || coin.equals("2") || coin.equals("2.0")) {
			amountKeeper.addCoin(Double.parseDouble(coin));
		} else {
			JOptionPane.showMessageDialog(null, "Wrong Coin inserted");
			return;
		}
	}
}
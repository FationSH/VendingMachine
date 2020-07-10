package machineManager;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;

/**
 * Reset the machine, selected product and total amount
 */

public class Reset {

	public Reset(AmountKeeper amountKeeper, JLabel amountLabel, ButtonGroup products) {
		amountKeeper.setAmount(0);
		amountLabel.setText("Total Amount: " + amountKeeper.getAmount());
		products.clearSelection();
	}
}

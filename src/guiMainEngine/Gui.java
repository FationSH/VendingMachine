package guiMainEngine;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import machineManager.*;

/**
 * The Main Class that creates the application interface
 * @author Fation Shehaj
 *
 */

public class Gui extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private final JLabel insertLabel;
	private final JLabel amountLabel;
	private JTextField insertCoins;
	private JButton insertButton;
	private final ButtonGroup products = new ButtonGroup();
	private final JButton makePurchaseButton;
	private final JButton resetButton;
	private final JButton cancelButton;
	
	private AmountKeeper amountKeeper;
	
	private JRadioButton Water;
	private JRadioButton Coke_330;
	private JRadioButton Coke_500;
	private JRadioButton Crunch;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui frame = new Gui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public Gui() {
		setBounds(500, 500, 600, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("Vending Machine");
		setDefaultLookAndFeelDecorated(true);
		setLayout(null);
		
		// Initialize total amount in machine
		amountKeeper = new AmountKeeper();
		
		/* 
		 * Insert Coins
		 */
		insertLabel = new JLabel("Insert Coins: ");
		insertLabel.setBounds(135, 50, 100, 30);
		this.add(insertLabel);
		
		insertCoins = new JTextField();
		insertCoins.setBounds(235, 50, 150, 30);
		this.add(insertCoins);
		
		insertButton = new JButton("Insert");
		insertButton.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InsertCoin insertCoin = new InsertCoin(amountKeeper);
				insertCoin.insert(insertCoins.getText());
				amountLabel.setText("Total Amount: " + amountKeeper.getAmount());
				insertCoins.setText("");
			}
		});
		insertButton.setBounds(385, 50, 80, 30);
		this.add(insertButton);
		
		amountLabel = new JLabel("Total Amount: " + amountKeeper.getAmount());
		amountLabel.setBounds(225, 100, 150, 30);
		this.add(amountLabel);
		
		/*
		 * Products available to select
		 */
		Water = new JRadioButton("Water: 0.5");
		Water.setActionCommand("Water");
		Water.setBounds(50, 125, 125, 30);
		this.add(Water);
		
		Coke_330 = new JRadioButton("Coke 330: 1.0");
		Coke_330.setActionCommand("Coke_330");
		Coke_330.setBounds(175, 125, 125, 30);
		this.add(Coke_330);
		
		Coke_500 = new JRadioButton("Coke 500: 1.5");
		Coke_500.setActionCommand("Coke_500");
		Coke_500.setBounds(300, 125, 125, 30);
		this.add(Coke_500);
		
		Crunch = new JRadioButton("Crunch: 2.5");
		Crunch.setActionCommand("Crunch");
		Crunch.setBounds(425, 125, 125, 30);
		this.add(Crunch);
		
		products.add(Water);
		products.add(Coke_330);
		products.add(Coke_500);
		products.add(Crunch);
		
		/*
		 * Buttons to choose action
		 */
		//  ===============  Make Purchase Button =======================
		makePurchaseButton = new JButton("Make Purchase");
		makePurchaseButton.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MakePurchase makePurchase = new MakePurchase(amountKeeper, products);
				makePurchase.purchase();
				amountLabel.setText("Total Amount: " + amountKeeper.getAmount());
			}
		});
		makePurchaseButton.setBounds(25, 200, 150, 30);
		this.add(makePurchaseButton);
		
		//  ===============  Reset Button ================================
		resetButton = new JButton("Reset");
		resetButton.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Reset(amountKeeper, amountLabel, products);
			}
		});
		resetButton.setBounds(225, 200, 150, 30);
		this.add(resetButton);
		
		//  ===============  Cancel Button ===============================
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Refund refund = new Refund(amountKeeper.getAmount());
				JOptionPane.showMessageDialog(null, refund.getRefund());
				amountKeeper.setAmount(0);
				amountLabel.setText("Total Amount: " + amountKeeper.getAmount());
			}
		});
		cancelButton.setBounds(425, 200, 150, 30);
		this.add(cancelButton);
	}

	// Getters for test reason
	public JRadioButton getWaterProduct() {
		return Water;
	}
	
	public ButtonGroup getProducts() {
		return products;
	}
}

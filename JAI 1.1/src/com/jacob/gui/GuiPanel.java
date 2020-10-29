package com.jacob.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

import com.jacob.main.ellis;
import com.jacob.main.noon;

public class GuiPanel extends JPanel {
	
	private static final long serialVersionUID = 624077343780878109L;
	private JPasswordField passwordField;
	private boolean validatedUser;
	private GuiFrame currentFrame;
	private noon nai;
	private ellis eai;
	
	public GuiPanel(GuiFrame cFrame) {
		
		currentFrame = cFrame;
		validatedUser = false;
		setupPanel();
		
	}
	
	private void setupPanel() {
		
		setLayout(null);
		
		JButton btnNewButton = new JButton("Launch NOON");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if (validatedUser) {
					
					currentFrame.runNOON();
					nai = new noon();
					com.jacob.gui.GuiRunningNOON.getNOON(nai);
					System.out.println("Launched NOON.");
					
				} else {
					
					JOptionPane.showMessageDialog(null, "User has not yet been validated.", "JAI Terminal", 1);
					System.out.println("User has not yet been validated.");
					
				}
				
			}
			
		});
		btnNewButton.setBounds(0, 0, 145, 300);
		add(btnNewButton);
		
		JButton btnLaunchEllis = new JButton("Launch ELLIS");
		btnLaunchEllis.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnLaunchEllis.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if (validatedUser) {
					
					currentFrame.runELLIS();
					eai = new ellis();
					com.jacob.gui.GuiRunningELLIS.getELLIS(eai);
					System.out.println("Launched ELLIS.");
					
				} else {
					
					JOptionPane.showMessageDialog(null, "User has not yet been validated.", "JAI Terminal", 1);
					System.out.println("User has not yet been validated.");
					
				}
				
			}
			
		});
		btnLaunchEllis.setBounds(299, 0, 151, 300);
		add(btnLaunchEllis);
		
		JLabel lblNewLabel = new JLabel("Welcome To JAI!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(155, 11, 134, 14);
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 11));
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("(Jacob's Artificial Intelligence)");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(152, 26, 145, 14);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("I have created two AI's,");
		lblNewLabel_2.setBounds(164, 62, 121, 27);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("one shares a resemblence");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(152, 85, 146, 14);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("to Tony Stark's JARVIS,");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(164, 102, 121, 14);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("whilst the other more");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(171, 120, 107, 14);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("towards EDITH.");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(178, 136, 94, 14);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 11));
		add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Enter your unique password");
		lblNewLabel_7.setBounds(153, 204, 143, 14);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 11));
		add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("below:");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setBounds(202, 220, 46, 14);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 11));
		add(lblNewLabel_8);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(158, 250, 134, 20);
		add(passwordField);
		
		JButton btnNewButton_1 = new JButton("Enter");
		btnNewButton_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				@SuppressWarnings("deprecation")
				String enteredPassword = passwordField.getText();
				String password = "090402";
				
				if (enteredPassword.equals(password)) {
					
					System.out.println("Password is correct.");
					JOptionPane.showMessageDialog(null, "User successfully validated.", "JAI Terminal", 1);
					validatedUser = true;
					passwordField.setText("");
					
				} else if (enteredPassword.equals("")) { 
					
					System.out.println("Password is empty.");
					JOptionPane.showMessageDialog(null, "Please enter a password.", "JAI Terminal", 1);
					passwordField.setText("");
					
				} else {
					
					System.out.println("Password is incorrect.");
					JOptionPane.showMessageDialog(null, "Password is incorrect.", "JAI Terminal", 1);
					passwordField.setText("");
					
				}
				
			}
			
		});
		btnNewButton_1.setBounds(180, 275, 89, 23);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		add(btnNewButton_1);
		
	}
	
}
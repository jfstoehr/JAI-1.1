package com.jacob.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.jacob.main.noon;

public class GuiRunningNOON extends JPanel {
	
	private static final long serialVersionUID = 624077343780878109L;
	public static noon nai;
	private GuiFrame currentFrame;
	
	public GuiRunningNOON(GuiFrame cFrame) {
		
		currentFrame = cFrame;
		setupPanel();
		
	}
	
	private void setupPanel() {
		
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NOON Is Running");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(65, 125, 320, 49);
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 30));
		add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Terminate");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				nai.stopSpeechRecognition();
				currentFrame.resetApplication();
				
			}
			
		});
		btnNewButton.setBounds(180, 185, 89, 23);
		add(btnNewButton);
		
	}
	
	public static void getNOON(noon ai) {
		
		nai = ai;
		
	}
	
}
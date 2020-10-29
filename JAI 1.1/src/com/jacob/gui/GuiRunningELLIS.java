package com.jacob.gui;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.jacob.main.ellis;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuiRunningELLIS extends JPanel {
	
	private static final long serialVersionUID = 624077343780878109L;
	public static ellis eai;
	private GuiFrame currentFrame;
	
	public GuiRunningELLIS(GuiFrame cFrame) {
		
		currentFrame = cFrame;
		setupPanel();
		
	}
	
	private void setupPanel() {
		
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ELLIS Is Running");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(65, 125, 320, 49);
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 30));
		add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Terminate");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				eai.stopSpeechRecognition();
				currentFrame.resetApplication();
				
			}
			
		});
		btnNewButton.setBounds(180, 185, 89, 23);
		add(btnNewButton);
		
	}
	
	public static void getELLIS(ellis ai) {
		
		eai = ai;
		
	}
	
	
}
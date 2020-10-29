package com.jacob.algorithms;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class openprograms {
	
	public String openExplorer() {
		
		String result = "";
		
		try {
			
			Runtime.getRuntime().exec("cmd /c start explorer", null, new File("C:\\Users\\jacob\\Downloads\\"));
			result = "application opened.";
			
		} catch (IOException e) {
			
			e.printStackTrace();
			result = "error, could not open file explorer";
			
		}
		
		return result;
		
	}
	
	public String openZoom() {
		
		String result = "";
		
		try {
			
			/*
			Runtime.getRuntime().exec("cmd /c nircmd sendkeypress rwin", null, new File("C:\\Users\\jacob\\Downloads\\"));
			TimeUnit.MILLISECONDS.sleep(700);
			Runtime.getRuntime().exec("cmd /c nircmd sendkeypress z", null, new File("C:\\Users\\jacob\\Downloads\\"));
			TimeUnit.MILLISECONDS.sleep(500);
			Runtime.getRuntime().exec("cmd /c nircmd sendkeypress o", null, new File("C:\\Users\\jacob\\Downloads\\"));
			TimeUnit.MILLISECONDS.sleep(500);
			Runtime.getRuntime().exec("cmd /c nircmd sendkeypress o", null, new File("C:\\Users\\jacob\\Downloads\\"));
			TimeUnit.MILLISECONDS.sleep(500);
			Runtime.getRuntime().exec("cmd /c nircmd sendkeypress m", null, new File("C:\\Users\\jacob\\Downloads\\"));
			TimeUnit.MILLISECONDS.sleep(500);
			Runtime.getRuntime().exec("cmd /c nircmd sendkeypress enter", null, new File("C:\\Users\\jacob\\Downloads\\"));
			*/
			
			Runtime.getRuntime().exec("cmd /c C:\\Users\\jacob\\AppData\\Roaming\\Zoom\\bin\\Zoom.exe", null, new File("C:\\Users\\jacob\\Downloads\\"));
			result = "application opened";
			
		} catch (IOException /*| InterruptedException*/  e) {
			
			e.printStackTrace();
			result = "error, could not open zoom";
			
		}
		
		return result;
		
	}
	
	public String openGoogleClassroom() {
		
		String result = "";
	
	try {
		
		Runtime.getRuntime().exec("cmd /c G:\\APP_DATA\\googleclassroom.txt", null, new File("C:\\Users\\jacob\\Downloads\\"));
		TimeUnit.MILLISECONDS.sleep(500);
		Runtime.getRuntime().exec("cmd /c nircmd sendkeypress leftctrl+a", null, new File("C:\\Users\\jacob\\Downloads\\"));
		TimeUnit.MILLISECONDS.sleep(500);
		Runtime.getRuntime().exec("cmd /c nircmd sendkeypress leftctrl+c", null, new File("C:\\Users\\jacob\\Downloads\\"));
		TimeUnit.MILLISECONDS.sleep(500);
		Runtime.getRuntime().exec("cmd /c nircmd sendkeypress rwin+3", null, new File("C:\\Users\\jacob\\Downloads\\"));
		TimeUnit.MILLISECONDS.sleep(500);
		Runtime.getRuntime().exec("cmd /c nircmd sendkeypress leftctrl+t", null, new File("C:\\Users\\jacob\\Downloads\\"));
		TimeUnit.MILLISECONDS.sleep(500);
		Runtime.getRuntime().exec("cmd /c nircmd sendkeypress leftctrl+v", null, new File("C:\\Users\\jacob\\Downloads\\"));
		TimeUnit.MILLISECONDS.sleep(500);
		Runtime.getRuntime().exec("cmd /c nircmd sendkeypress enter", null, new File("C:\\Users\\jacob\\Downloads\\"));
		result = "application opened";
		
	} catch (IOException | InterruptedException  e) {
		
		e.printStackTrace();
		result = "error, could not open zoom";
		
	}
	
	return result;
		
	}

}
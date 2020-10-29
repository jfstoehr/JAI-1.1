package com.jacob.algorithms;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.IOException;

public class paste {
	
	public String pasteNoEnter(int times) throws UnsupportedFlavorException, IOException {
		
		try {
			
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			Clipboard c = toolkit.getSystemClipboard();
			String clipboard = (String) c.getData(DataFlavor.stringFlavor);
			
		} catch (UnsupportedFlavorException | IOException e) {
			
			return "error! nothing is on the clipboard.";
			
		}
		
		for (int i = 0; i < times; i++) {
			
			Runtime.getRuntime().exec("cmd /c nircmd sendkeypress rctrl+v", null, new File("C:\\Users\\jacob\\Downloads\\"));
			
		}
		
		return "successfully pasted.";
		
	}
	
	public String pasteWithEnter(int times) throws UnsupportedFlavorException, IOException {
		
		try {
			
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			Clipboard c = toolkit.getSystemClipboard();
			String clipboard = (String) c.getData(DataFlavor.stringFlavor);
			
		} catch (UnsupportedFlavorException | IOException e) {
			
			return "error! nothing is on the clipboard.";
			
		}
		
		for (int i = 0; i < times; i++) {
			
			Runtime.getRuntime().exec("cmd /c nircmd sendkeypress rctrl+v", null, new File("C:\\Users\\jacob\\Downloads\\"));
			Runtime.getRuntime().exec("cmd /c nircmd sendkeypress enter", null, new File("C:\\Users\\jacob\\Downloads\\"));
			
		}
		
		return "successfully pasted.";
		
	}

}
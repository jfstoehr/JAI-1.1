package com.jacob.algorithms;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.hadas.krzysztof.TidalApi;
import com.hadas.krzysztof.TidalApiImpl;

public class win10system {
	
	public String mute() {
		
		try {
			
			Runtime.getRuntime().exec("cmd /c nircmd mutesysvolume 1", null, new File("C:\\Users\\jacob\\Downloads\\"));
			return "volume muted";
			
		} catch (IOException e) {
			
			e.printStackTrace();
			return "error, could not mute system volume";
			
		}
		
	}
	
	public String unmute() {
		
		try {
			
			Runtime.getRuntime().exec("cmd /c nircmd mutesysvolume 0", null, new File("C:\\Users\\jacob\\Downloads\\"));
			return "volume unmuted";
			
		} catch (IOException e) {
			
			e.printStackTrace();
			return "error, could not mute system volume";
			
		}
		
	}
	
	public String screensaver() {
		
		try {
			
			Runtime.getRuntime().exec("cmd /c nircmd sendkeypress rwin+d", null, new File("C:\\Users\\jacob\\Downloads\\"));
			return "okay";
			
		} catch (IOException e) {
			
			e.printStackTrace();
			return "error, could not show screensaver";
			
		}
		
	}
	
	public String playpause(String data) {
		
		try {
			
			Runtime.getRuntime().exec("cmd /c nircmd sendkeypress rwin+4", null, new File("C:\\Users\\jacob\\Downloads\\"));
			TimeUnit.SECONDS.sleep(1);
			Runtime.getRuntime().exec("cmd /c nircmd sendkeypress spc", null, new File("C:\\Users\\jacob\\Downloads\\"));
			
			if (data.indexOf("play") != -1) {
				
				return "okay, I resumed the music";
				
			} else {
				
				return "okay, I paused the music";
				
			}
			
			
		} catch (InterruptedException | IOException e) {
			
			e.printStackTrace();
			return "error, application is not open";
			
		}
		
	}

}
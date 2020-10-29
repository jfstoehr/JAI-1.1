package com.jacob.algorithms;

import java.util.*;

public class calendar {
	
	public static Date getTime() {
		
		Calendar c = Calendar.getInstance(); 
        Date time = c.getTime(); 
        
        return time;
		
	}
	
	public static String $time() {
		
		Date t = getTime();
		
		String time = "" + t;
		time = time.substring(11, 19);
		
		return time;
		
	}
	
	public static int getYear() {
		
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		
		return year;
		
	}
	
	public static String getDate() {
		
		//Calendar c = Calendar.getInstance();
		//int d = c.get(Calendar.DATE);
		
		String time = "" + getTime();
		time = time.substring(4, 10) + ", " + time.substring(24);
		
		return time;
		
	}
	
	public static String convertTo12HourTime(String time) {
		
		String temp = new String(time);
		int k = 0;
		int[] colons;
		
		while (temp.indexOf(":") != -1) {
			
			temp = temp.substring(0, temp.indexOf(":")) + temp.substring(temp.indexOf(":") + 1);
			k++;
			
		}
		
		colons = new int[k];
		temp = new String(time);
		k = 0;
		
		while (temp.indexOf(":") != -1) {
			
			colons[k] = temp.indexOf(":") + k;
			temp = temp.substring(0, temp.indexOf(":")) + temp.substring(temp.indexOf(":") + 1);
			k++;
			
		}
		
		String $formated = new String(time);
		
		for (int j = 0; j < colons.length; j++) {
			
			int c = time.indexOf(":");
			int colon = c + (colons[j] - c);
			int hour = Integer.parseInt(time.substring(colon - 2, colon));
			
			int[] hours = {13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 0};
			int[] newHours = {01, 02, 03, 04, 05, 06, 07, 8, 9, 10, 11, 12};
			String h = "";
			
			for (int i = 0; i < hours.length; i++) {
				
				if (hour == hours[i]) {
					
					h = "" + newHours[i];
					
					if (i <= 8) {
						
						h = "0" + h;
						
					}
					
					break;
					
				}
				
			}
			
			$formated = $formated.substring(0, colon  - 2) + h + $formated.substring(colon);
			
		}
		
		return $formated;
		
	}

}
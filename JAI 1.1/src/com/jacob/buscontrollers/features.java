package com.jacob.buscontrollers;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Date;

import com.jacob.algorithms.*;

public class features {
	
	public static String calendar(String data) throws IOException, GeneralSecurityException {
		
		new calendar();
		new googlecalendar();
		
		String time = "what time is it";
		String year = "what year is it";
		String date = "what is the date";
		//String setEvent1 = "create an event";
		//String setEvent2 = "create a calendar event";
		String getEvent1 = "what events do I have";
		String getEvent2 = "what is on my schedule";
		
		if (data.indexOf(time) != -1) {
			
			String nD = calendar.$time();
			return nD;

		} else if (data.indexOf(year) != -1) {

			int y = calendar.getYear();
			String nY = "" + y;
			return nY;

		} else if (data.indexOf(date) != -1) {

			String nD = calendar.getDate();
			return nD;

		} /*else if ((data.indexOf(setEvent1) != -1) || (data.indexOf(setEvent2) != -1)) {

			String ff = data.substring(16, data.length());
			boolean se = calendar.setEvent(ff, cD);
			String s_se = "" + se;
			return s_se;

		}*/ else if (data.indexOf(getEvent1) != -1 || data.indexOf(getEvent2) != -1) {

			String ge = googlecalendar.getEvents();
			return ge;

		} else {

			String error = "error";
			return error;

		}

	}
	/*
	public static mail() {
		
		
		
	}
	
	public static String news() {
		
		
		
	}

	public static String notes() {



	}

	public static String stocks() {



	}

	public static String reminders() {



	}

	public static String books() {



	}
	 */
	public static double math(String data) {

		math m = new math();

		data = data.trim();
		String addition = "+";
		String subtraction = "-";
		String multipication = "*";
		String division = "/";
		String exponent = "^";

		double answer = 0.0;

		if (data.indexOf(addition) != -1) {

			answer = m.add(data);

		} else if (data.indexOf(subtraction) != -1) {

			answer = m.subtract(data);

		} else if (data.indexOf(multipication) != -1) {

			answer = m.multiply(data);

		} else if (data.indexOf(division) != -1) {

			answer = m.divide(data);

		} else if (data.indexOf(exponent) != -1) {

			answer = m.exponent(data);

		}

		return answer;

	}

	public static String stringMath(String data) {

		String scientificNotation = "scientific notation";
		String answer = "";
		math m = new math();

		if (data.indexOf(scientificNotation) != -1) {

			answer = m.scientificNotation(data);

		}

		return answer;

	}

	/*
	public static String weather() {



	}*/

	/*public static String bedtime(String data) throws FileNotFoundException {

		bedtime bt = new bedtime();

		String c1 = "set my bedtime to";
		String c2 = "what is my bedtime";
		String c3 = "i'm going to sleep";
		String c4 = "what is my sleep pattern";
		String c5 = "give me some advise on my sleeping schedule";

		calendar c = new calendar();
		Date d_ct = c.getTime();
		String ct = "" + d_ct;
		String fct = ct.substring(11, 16);

		String r = "";
		boolean rr = false;
		String[] rrr;

		if (data.indexOf(c2) != -1) {

			r = bt.getBedtime();

		} else if (data.indexOf(c1) != -1) {

			String b = data.substring(18, data.length());
			rr = bt.setBedtime(b);
			r = "" + rr;

		} else if (data.indexOf(c3) != -1) {

			rr = bt.trackSleep(fct);
			r = "" + rr;

		} else if (data.indexOf(c4) != -1) {

			r = bt.getSleepPattern();

		} else if (data.indexOf(c5) != -1) {

			r = bt.advise();

			/*for (int i = 0; i < rrr.length; i++) {

				r += rrr[i] + "\n";

			}

		} else {

			r = "error";

		}

		return r;

	}*/

	public static String worldClock(String data) {

		new worldclock();

		String loc1 = "what time is it in london";
		String loc2 = "what time is it in paris";
		String loc3 = "what time is it in new york city";
		String loc4 = "what time is it in los angeles";
		String loc5 = "what time is it in hong kong";

		String time = "";
		String city = "";

		if (data.equals(loc1)) {

			city = data.substring(19, loc1.length());
			time = worldclock.locations(city);

		} else if (data.equals(loc2)) {

			city = data.substring(19, loc2.length());
			time = worldclock.locations(city);

		} else if (data.equals(loc3)) {

			city = data.substring(19, loc3.length());
			time = worldclock.locations(city);

		} else if (data.equals(loc4)) {

			city = data.substring(19, loc4.length());
			time = worldclock.locations(city);

		} else if (data.equals(loc5)) {

			city = data.substring(19, loc5.length());
			time = worldclock.locations(city);

		} else {

			String error = "error";
			return error;

		}

		return time;

	}
	/*
	public static double alarm() {



	}

	public static double timer() {



	}

	public static double stopwatch() {



	}*/
	
	public static String openPrograms(String data) {
		
		openprograms o = new openprograms();
		String result = "";
		
		if (data.indexOf("File Explorer") != -1 || data.indexOf("file explorer") != -1) {
			
			result = o.openExplorer();
			
		} else if (data.indexOf("Zoom") != -1 || data.indexOf("zoom") != -1 || data.indexOf("Xoom") != -1 || data.indexOf("xoom") != -1) {
			
			result = o.openZoom();
			
		} else if (data.indexOf("google classroom") != -1 || data.indexOf("Google classroom") != -1 || data.indexOf("google Classroom") != -1 || data.indexOf("Google Classroom") != -1) {
			
			result = o.openGoogleClassroom();
			
		} else {
			
			result = "error, no application found with that name.";
			
		}
		
		return result;
		
	}
	
	public static String volume(String data) {
		
		win10system $win10 = new win10system();
		
		if (data.indexOf("unmute") != -1) {
			
			return $win10.unmute();
		
		} else if (data.indexOf("mute") != -1) {
			
			return $win10.mute();
			
		} else {
			
			return "error";
			
		}
		
	}
	
	public static String screensaver() {
		
		win10system $win10 = new win10system();
		return $win10.screensaver();
		
	}
	
	public static String email(String data) throws GeneralSecurityException, IOException {
		
		new gmail();
		String forReturn = "";
		
		if (data.indexOf("what messages do I have") != -1) {
			
			forReturn =  gmail.getFlaggedMessages();
			
		}
		
		return forReturn;
		
	}
	
	public static String paste(String data) {
		
		paste p = new paste();
		
		boolean success1 = false;
		boolean success2 = false;
		boolean success3 = false;
		int times = 0;
		
		for (int i = 0; i < data.length(); i++) {
			
			try {
				
				Integer.parseInt(data.substring(i, i + 1));
				success1 = true;
				
			} catch (Exception e) { e.printStackTrace(); }
			
			try {
				
				Integer.parseInt(data.substring(i, i + 2));
				success2 = true;
				
			} catch (Exception e) { e.printStackTrace(); }
			
			try {
				
				Integer.parseInt(data.substring(i, i + 3));
				success3 = true;
				
			} catch (Exception e) { e.printStackTrace(); }
			
			System.out.println("0 Times = " + times);
			
			if (success3) {
				
				times = Integer.parseInt(data.substring(i, i + 3));
				System.out.println("1 Times = " + times);
				break;
				
			} else if (success2) {
				
				times = Integer.parseInt(data.substring(i, i + 2));
				System.out.println("2 Times = " + times);
				break;
				
			} else if (success1) {
				
				times = Integer.parseInt(data.substring(i, i + 1));
				System.out.println("3 Times = " + times);
				break;
				
			}
			
			System.out.println(times);
			
		}
		
		if (data.indexOf("enter") != -1) {
			
			try {
				
				return p.pasteNoEnter(times);
				
			} catch (UnsupportedFlavorException | IOException e) {
				
				return "error";
				
			}
			
		} else {
			
			try {
				
				return p.pasteNoEnter(times);
				
			} catch (UnsupportedFlavorException | IOException e) {
				
				return "error";
				
			}
			
		}
		
	}
	
	public static String music(String data) {
		
		win10system $win10 = new win10system();
		
		if (data.indexOf("play") != -1 || data.indexOf("pause") != -1) {
			
			return $win10.playpause(data);
			
		} else {
			
			return "error";
			
		}
		
	}

}
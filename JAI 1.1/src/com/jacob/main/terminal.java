package com.jacob.main;

import java.io.FileNotFoundException;
import java.util.*;

import com.jacob.data.save;
import com.jacob.main.ellis;
import com.jacob.main.noon;

//import java.util.concurrent.TimeUnit;

@Deprecated
public class terminal {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		terminal bot = new terminal();
		
		Scanner reader = new Scanner(System.in);
		String input = "";
		boolean run = true;
		boolean applicationBooted = false;
		
		bot.printLogOn();
		
		while (run) {
			
			bot.printC();
			
			if (applicationBooted) {
				
				bot.printAppBoot();
				
			}
			
			input = reader.nextLine();
			int refId = bot.executeCommand(input);
			
			if (refId == 1) {
				
				new ellis();
				applicationBooted = true;
				
			} else if (refId == 2) {
				
				new noon();
				applicationBooted = true;
				
			} else {
				
				bot.printError();
				
			}
			
		}
		
		try {
			
			reader.close();
			
		} catch (Exception e) {
			
			System.err.printf("%s..%s", "Error", e);
			//e.printStackTrace();
			
		} finally {
			
			System.exit(0);
			
		}
		
	}

	private void printC() {

		System.out.print("\n" + System.getProperty("user.name") + "-" + "win1:~ " + System.getProperty("user.name") + "$ ");

	}

	private void printLogOn() throws FileNotFoundException {

		Calendar c = Calendar.getInstance(); 
		Date time = c.getTime(); 

		System.out.print("Console Log On: " + time);
		
		String log = "Console Log On: " + time;
		save s = new save();
		s.saveData(log, 1, "consolelog");
		
	}

	private void printError() {

		System.out.print("Internal or external command was not recognized by the system.");

	}
	
	private void printAppBoot() {
		
		System.out.print("bash print args");
		System.out.print("\n");
		
	}

	private int executeCommand(String input) {

		int refId = 0;
		
		if (input.equals("boot ellis")) {
			
			System.out.print("Ellis AI has been started.");
			refId = 1;
			
		} else if (input.equals("boot noon")) {
			
			System.out.print("Noon AI has been started.");
			refId = 2;
			
		} else if (input.equals("terminate shell")) {
			
			System.exit(0);
			
		} else if (input.equals("terminate ellis")) {
			
			ellis bot = new ellis();
			bot.terminate();
			
		} else if (input.equals("terminate noon")) {
			
			noon bot = new noon();
			bot.terminate();
			
		}

		return refId;

	}

}
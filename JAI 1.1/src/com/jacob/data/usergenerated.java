package com.jacob.data;

import java.io.*;
import java.util.Scanner;

public class usergenerated {
	
	public static boolean createFiles(String name, String data) throws FileNotFoundException{
		
		boolean success = false;
		save s = new save();
		
		try {
			
			ClassLoader classLoader = new save().getClass().getClassLoader();
			File file = new File(classLoader.getResource("usergenerated/" + name + ".txt").getFile());
			
			if (file.createNewFile()) {
				
				success = s.saveData(data , 2, name);
				
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
		return success;
		
	}
	
	public static String[] getNameOfFiles(int refId) {
		
		if (refId == 1) {
			
			ClassLoader classLoader = new save().getClass().getClassLoader();
			File file = new File(classLoader.getResource("userdata/").getFile());
			String ff = trimChars(file);
			
			File folder = new File(ff);
			File[] files = folder.listFiles();
			String[] names = new String[files.length];
			
			for (int i = 0; i < files.length; i++) {
				
				names[i] = files[i].getName();
				
			}
			
			return names;
			
		} else if (refId == 2) {
			
			ClassLoader classLoader = new save().getClass().getClassLoader();
			File file = new File(classLoader.getResource("usergenerated/").getFile());
			String ff = trimChars(file);
			
			File folder = new File(ff);
			File[] files = folder.listFiles();
			String[] names = new String[files.length];
			
			for (int i = 0; i < files.length; i++) {
				
				names[i] = files[i].getName();
				
			}
			
			return names;
			
		} else if (refId == 3) {
			
			File folder = new File("C:\\witpol\\$USERDATA\\$BEDTIME\\bedtime\\");
			File[] files = folder.listFiles();
			String[] names = new String[files.length];
			
			for (int i = 0; i < files.length; i++) {
				
				names[i] = files[i].getName();
				
			}
			
			return names;
			
		} else if (refId == 4) {
			
			File folder = new File("C:\\witpol\\$USERDATA\\$BEDTIME\\sleeptracker\\");
			File[] files = folder.listFiles();
			String[] names = new String[files.length];
			
			for (int i = 0; i < files.length; i++) {
				
				names[i] = files[i].getName();
				
			}
			
			return names;
			
		} else {
			
			String[] n = new String[1];
			
			return n;
			
		}
		
		
	}
	
	@SuppressWarnings("resource")
	public static String[] getDataInFiles(int refId) throws FileNotFoundException {
		
		String[] names = getNameOfFiles(refId);
		String[] data = new String[names.length];
		
		for (int i = 0; i < names.length; i++) {
			
			if (refId == 1) {
				
				ClassLoader classLoader = new save().getClass().getClassLoader();
				File file = new File(classLoader.getResource("userdata/").getFile());
				String ff = trimChars(file);
				
				FileReader f = new FileReader(ff + "\\" + names[i]);
				Scanner r = new Scanner(f);
				data[i] = r.nextLine();
				
			} else if (refId == 2) {
				
				ClassLoader classLoader = new save().getClass().getClassLoader();
				File file = new File(classLoader.getResource("usergenerated/").getFile());
				String ff = trimChars(file);
				
				FileReader f = new FileReader(ff + "\\" + names[i]);
				Scanner r = new Scanner(f);
				data[i] = r.nextLine();
				
			} else if (refId == 3) {
				
				FileReader f = new FileReader("C:\\witpol\\$USERDATA\\$BEDTIME\\bedtime\\" + names[i]);
				Scanner r = new Scanner(f);
				data[i] = r.nextLine();
				
			} else if (refId == 4) {
				
				FileReader f = new FileReader("C:\\witpol\\$USERDATA\\$BEDTIME\\sleeptracker\\sleeptracker.txt");
				Scanner r = new Scanner(f);
				
				FileReader ff = new FileReader("C:\\witpol\\$USERDATA\\$BEDTIME\\sleeptracker\\sleeptracker.txt");
				Scanner rr = new Scanner(ff);
				
				String[] forSleepTracker;
				int numLines = scanFile(rr);
				forSleepTracker = new String[numLines + 1];
				
				for (int j = 0; j < forSleepTracker.length - 1; j++) {
					
					forSleepTracker[j] = r.nextLine();
					
				}
				
				return forSleepTracker;
				
			} else if (refId == 5) {
				
				FileReader f = new FileReader("C:\\witpol\\$USERDATA\\$BEDTIME\\sleeptracker\\wasTired.txt");
				Scanner r = new Scanner(f);
				
				FileReader ff = new FileReader("C:\\witpol\\$USERDATA\\$BEDTIME\\sleeptracker\\wasTired.txt");
				Scanner rr = new Scanner(ff);
				
				String[] forWasTired;
				int numLines = scanFile(rr);
				forWasTired = new String[numLines + 1];
				
				for (int j = 0; j < forWasTired.length - 1; j++) {
					
					forWasTired[j] = r.nextLine();
					
				}
				
				return forWasTired;
				
			} else if (refId == 6) {
				
				FileReader f = new FileReader("G:\\APP_DATA\\1.0.1.txt");
				Scanner r = new Scanner(f);
				
				FileReader ff = new FileReader("G:\\\\APP_DATA\\\\1.0.1.txt");
				Scanner rr = new Scanner(ff);
				
				String[] forData;
				int numLines = scanFile(rr);
				forData = new String[numLines];
				
				for (int j = 0; j < forData.length - 1; j++) {
					
					forData[j] = r.nextLine();
					
				}
				
				return forData;
				
			}
			
		}
		
		return data;
		
	}
	
	public static int scanFile(Scanner sc) {
		
		int numLines = 0;
		
		while (sc.hasNextLine()) {
			
			sc.nextLine();
			numLines++;
			
		}
		
		return numLines;
		
	}
	
	private static String trimChars(File f) {
		
		String file = "" + f;
		
		while (file.indexOf("%20") != -1) {
			
			int index = file.indexOf("%20");
			String before = file.substring(0, index);
			String after = file.substring(index + 3, file.length());
			file = before + " " + after;
			
		}
		
		return file;
		
	}

}
package com.jacob.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* Index Of Reference Id's For Hexadecimal Dumps:
 * 0 = New Id needs to be created.
 * 1 = System Password
 * 2 = Baby Monitor Protocol
 */

public class save {

	public boolean saveData(String data, int referenceId, String name) throws FileNotFoundException {

		boolean success = false;

		OutputStream os = null;

		try {

			if (referenceId == 1) {
				
				ClassLoader classLoader = new save().getClass().getClassLoader();
				File file = new File(classLoader.getResource("userdata/consolelog.txt").getFile());
				String ff = trimChars(file);
		        
				os = new FileOutputStream(new File(ff));
				
			} else if (referenceId == 2) {
				
				ClassLoader classLoader = new save().getClass().getClassLoader();
				File file = new File(classLoader.getResource("usergenerated/" + name +".txt").getFile());
				String ff = trimChars(file);
		        
				os = new FileOutputStream(new File(ff));
				
			} else {

				os = new FileOutputStream(new File("C:\\witpol\\$USERDATA\\$USERGENERATED\\" + name + ".txt"));

			}

			os.write(data.getBytes(), 0, data.length());
			success = true;

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				os.close();

			} catch (IOException | NullPointerException e) {

				e.printStackTrace();

			}

		}

		return success;

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

	public static boolean saveArray(String[] array, int refId, String fn) {

		boolean success = false;

		OutputStream os = null;
		String data = "";

		try {

			if (refId == 1) {

				os = new FileOutputStream(new File("C:\\witpol\\$USERDATA\\$BEDTIME\\sleeptracker\\" + fn + ".txt"));

			} else {

				os = new FileOutputStream(new File("resources\\userdata\\consolelog.txt"));

			}

			for (int i = 0; i < array.length; i++) {

				try {

					data += array[i] + "\n";

				} catch (Exception e) {

					do {

						i++;

					} while (i < array.length);

				}

			}

			os.write(data.getBytes(), 0, data.length());
			success = true;

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				os.close();

			} catch (IOException e) {

				e.printStackTrace();

			}

		}

		return success;

	}

}
package com.jacob.algorithms;

import java.util.Date;

public class worldclock {

	public static String locations(String city) {

		String[] cities = {"london", "paris", "new york city", "los angeles", "hong kong"};
		String locationsTime = "";
		String verified = "";

		if (city.equals(cities[0])) {

			locationsTime = getTimeInCity(1);
			verified = checkFormat(locationsTime, 1);

		} else if (city.equals(cities[1])) {

			locationsTime = getTimeInCity(2);
			verified = checkFormat(locationsTime, 2);

		} else if (city.equals(cities[2])) {

			locationsTime = getTimeInCity(3);
			verified = checkFormat(locationsTime, 3);

		} else if (city.equals(cities[3])) {

			locationsTime = getTimeInCity(4);
			verified = checkFormat(locationsTime, 4);

		} else if (city.equals(cities[4])) {

			locationsTime = getTimeInCity(5);
			verified = checkFormat(locationsTime, 5);

		} else {

			locationsTime = "i do not have that city in my index. would you like me to add it?";
			verified = "i do not have that city in my index. would you like me to add it?";

		}

		return verified;

	}

	public static String getTimeInCity(int refId) {

		//calendar c = new calendar();
		String[] hours = {"31", "30", "29", "28", "27", "26", "25", "24", "23", "22", "21", "20", "19", "18", "17", "16", "15",
				"14", "13", "12", "11", "10", "9", "8", "7", "6", "5", "4", "3", "2", "1"};
		int[] i_hours = {31, 30, 29, 28, 27, 26, 25, 24, 23, 22, 21, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7,
				6, 5, 4, 3, 2, 1};

		//String[] cities = {"london", "paris", "new york city", "los angeles", "hong kong"};
		Date localTime = calendar.getTime();
		String lT = "" + localTime;
		lT = lT.substring(11, 16);
		int f_localHour = 0;

		String loc1 = "the time in london is ";
		String loc2 = "the time in paris is ";
		String loc3 = "the time in new york city is ";
		String loc4 = "the time in los angeles is ";
		String loc5 = "the time in hong kong is ";

		if (refId == 1) {

			int add = 5;
			String localHour = lT.substring(0, 2);

			for (int i = 0; i < hours.length; i++) {

				if (localHour.equals(hours[i])) {

					f_localHour = i_hours[i];
					f_localHour += add;
					break;

				}

			}

		} else if (refId == 2) {

			int add = 6;
			String localHour = lT.substring(0, 2);

			for (int i = 0; i < hours.length; i++) {

				if (localHour.equals(hours[i])) {

					f_localHour = i_hours[i];
					f_localHour += add;
					break;

				}

			}

		} else if (refId == 3) {

			int add = 0;
			String localHour = lT.substring(0, 2);

			for (int i = 0; i < hours.length; i++) {

				if (localHour.equals(hours[i])) {

					f_localHour = i_hours[i];
					f_localHour += add;
					break;

				}

			}

		} else if (refId == 4) {

			int add = -3;
			String localHour = lT.substring(0, 2);

			for (int i = 0; i < hours.length; i++) {

				if (localHour.equals(hours[i])) {

					f_localHour = i_hours[i];
					f_localHour += add;
					break;

				}

			}

		} else if (refId == 5) {

			int add = 13;
			String localHour = lT.substring(0, 2);

			for (int i = 0; i < hours.length; i++) {

				if (localHour.equals(hours[i])) {

					f_localHour = i_hours[i];
					f_localHour += add;
					break;

				}

			}

		} else {

			String error = "error";
			return error;

		}

		String locationsTime = "" + f_localHour;
		String minutes = lT.substring(3, lT.length());
		locationsTime += ":" + minutes;
		String formated = "";

		if (refId == 1) {

			formated += loc1 + locationsTime;

		} else if (refId == 2) {

			formated += loc2 + locationsTime;

		} else if (refId == 3) {

			formated += loc3 + locationsTime;

		} else if (refId == 4) {

			formated += loc4 + locationsTime;

		} else if (refId == 5) {

			formated += loc5 + locationsTime;

		}

		return formated;

	}

	public static String checkFormat(String t, int refId) {

		String hour = "";
		String cM = "";

		if (refId == 1) {

			hour = t.substring(22, 24);
			cM = t.substring(25, 27);

		} else if (refId == 2) {

			hour = t.substring(21, 23);
			cM = t.substring(24, 26);

		} else if (refId == 3) {

			hour = t.substring(29, 31);
			cM = t.substring(32, 34);

		} else if (refId == 4) {

			hour = t.substring(27, 29);
			cM = t.substring(30, 32);

		} else if (refId == 5) {

			hour = t.substring(25, 27);
			cM = t.substring(28, 30);

		}

		String[] pHours = {"37", "36", "35", "34", "33", "32", "31", "30", "29", "28", "27", "26", "25", "24"};
		String[] nHours = {"13", "12", "11", "10", "09", "08", "07", "06", "05", "04", "03", "02", "01", "00"};
		String nH = "";

		for (int i = 0; i < pHours.length; i++) {

			if (hour.equals(pHours[i])) {

				nH = nHours[i];
				break;

			} else {

				nH = hour;

			}

		}

		String loc1 = "the time in london is ";
		String loc2 = "the time in paris is ";
		String loc3 = "the time in new york city is ";
		String loc4 = "the time in los angeles is ";
		String loc5 = "the time in hong kong is ";

		String fnh = "";

		if (refId == 1) {

			fnh = loc1 + nH + ":" + cM;

		} else if (refId == 2) {

			fnh = loc2 + nH + ":" + cM;

		} else if (refId == 3) {

			fnh = loc3 + nH + ":" + cM;

		} else if (refId == 4) {

			fnh = loc4 + nH + ":" + cM;

		} else if (refId == 5) {

			fnh = loc5 + nH + ":" + cM;

		}

		return fnh;

	}

}
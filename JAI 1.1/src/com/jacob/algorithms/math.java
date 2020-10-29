package com.jacob.algorithms;

public class math {
	
	public double add(String data) throws NumberFormatException {
		
		double answer = 0.0;
		
		int index = data.indexOf("+");
		int endIndex = index + 1;
		String e1 = data.substring(0, index);
		String e2 = (data.substring(endIndex));
		
		double n1 = 0.0;
		
		for (int i = 0; i < data.length(); i++) {
			
			try {
				
				n1 = Double.parseDouble(e1);
				
			} catch (Exception e) {
				
				e1 = e1.substring(1);
				
			}
			
		}
		
		double n2 = Double.parseDouble(e2);
		answer = n1 + n2;
		
		return answer;
		
	}
	
	public double subtract(String data) {
		
		double answer = 0.0;
		
		int index = data.indexOf("-");
		int endIndex = index + 1;
		String e1 = data.substring(0, index);
		String e2 = (data.substring(endIndex));
		
		double n1 = 0.0;
		
		for (int i = 0; i < data.length(); i++) {
			
			try {
				
				n1 = Double.parseDouble(e1);
				
			} catch (Exception e) {
				
				e1 = e1.substring(1);
				
			}
			
		}
		
		double n2 = Double.parseDouble(e2);
		answer = n1 - n2;
		
		return answer;
		
	}

	public double multiply(String data) {
		
		double answer = 0.0;
		
		int index = data.indexOf("*");
		int endIndex = index + 1;
		String e1 = data.substring(0, index);
		String e2 = (data.substring(endIndex));
		
		double n1 = 0.0;
		
		for (int i = 0; i < data.length(); i++) {
			
			try {
				
				n1 = Double.parseDouble(e1);
				
			} catch (Exception e) {
				
				e1 = e1.substring(1);
				
			}
			
		}
		
		double n2 = Double.parseDouble(e2);
		answer = n1 * n2;
		
		return answer;
		
	}

	public double divide(String data) {
		
		double answer = 0.0;
		
		int index = data.indexOf("/");
		int endIndex = index + 1;
		String e1 = data.substring(0, index);
		String e2 = (data.substring(endIndex));
		
		double n1 = 0.0;
		
		for (int i = 0; i < data.length(); i++) {
			
			try {
				
				n1 = Double.parseDouble(e1);
				
			} catch (Exception e) {
				
				e1 = e1.substring(1);
				
			}
			
		}
		
		double n2 = Double.parseDouble(e2);
		answer = n1 / n2;
		
		return answer;
		
	}
	
	public double exponent(String data) {
		
		double answer = 0.0;
		
		int index = data.indexOf("^");
		int endIndex = index + 1;
		String e1 = data.substring(0, index);
		String e2 = (data.substring(endIndex));
		
		double n1 = 0.0;
		
		for (int i = 0; i < data.length(); i++) {
			
			try {
				
				n1 = Double.parseDouble(e1);
				
			} catch (Exception e) {
				
				e1 = e1.substring(1);
				
			}
			
		}
		
		double n2 = Double.parseDouble(e2);
		answer = Math.pow(n1, n2);
		
		return answer;
		
	}
	
	public String scientificNotation(String input) {
		
		double d = 0.0;
		
		/*for (int i = 0; i < input.length(); i++) {
			
			try {
				
				d = Double.parseDouble(input);
				System.out.println("ran on " + i);
				
			} catch (Exception e) {
				
				input = input.substring(1);
				
			}
			
		}*/
		
		int spaces = 0;
		
		for (int i = 0; i < input.length(); i++) {
			
			String temp = input.substring(i, i + 1);
			
			if (temp.equals(" ")) {
				
				spaces++;
				
			}
			
		}
		
		int[] indexOfSpaces = new int[spaces];
		int k = 0;
		
		for (int i = 0; i < input.length(); i++) {
			
			String temp = input.substring(i, i + 1);
			
			if (temp.equals(" ")) {
				
				indexOfSpaces[k] = i;
				k++;
				
			}
			
		}
		
		String[] words = new String[spaces + 1];
		int j = 0;
		
		for (int i = 0; i < words.length; i++) {
			
			try {
				
				words[i] = input.substring(j, indexOfSpaces[i]);
				j = indexOfSpaces[i] + 1;
				
			} catch (ArrayIndexOutOfBoundsException e) {
				
				words[i] = input.substring(j);
				
			}
			
		}
		
		for (int i = 0; i < words.length; i++) {
			
			try {
				
				d = Double.parseDouble(words[i]);
				break;
				
			} catch (NumberFormatException e) {}
			
		}
		
		String data = "" + d;
		//System.out.println(data);
		String newFormat = "";
		int i = data.indexOf("E");
		//String firstTwo = data.substring(0, 2);
		
		if (i != -1) {
			
			String forDP = data.substring(3);
			int decimalPlaces = forDP.length();
			
			if (decimalPlaces > 3) {
				
				newFormat = data.substring(0, 1) + " point " + data.substring(2, 4) /*+ firstTwo*/ + " times 10 to the power of " + decimalPlaces;
				
			} else {
				
				newFormat = "Number is too small to convert.";
				
			}
			
		} else {
			
			String forDP = data.substring(2);
			int decimalPlaces = forDP.length() - 1;
			
			if (decimalPlaces > 3) {
				
				newFormat = data.substring(0, 1) + " point " + data.substring(1, 3) + " times 10 to the power of " + decimalPlaces;
				
			} else {
				
				newFormat = "Number is too small to convert.";
				
			}
			
		}
		
		return newFormat;
		
	}

}
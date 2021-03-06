package com.jacob.main;

import javax.sound.sampled.LineUnavailableException;

import com.darkprograms.speech.microphone.Microphone;
import com.darkprograms.speech.recognizer.GSpeechDuplex;
import com.darkprograms.speech.recognizer.GSpeechResponseListener;
import com.darkprograms.speech.recognizer.GoogleResponse;
import com.jacob.buscontrollers.features;

import marytts.TextToSpeech;
//import marytts.signalproc.effects.JetPilotEffect;
import net.sourceforge.javaflacencoder.FLACFileWriter;

import java.util.Random;

public class ellis {
	
	private final TextToSpeech tts = new TextToSpeech();
	private final Microphone mic = new Microphone(FLACFileWriter.FLAC);
	private final GSpeechDuplex duplex = new GSpeechDuplex("AIzaSyBOti4mM-6x9WDnZIjIeyEU21OpBXqWBgw");
	String oldText = "";
	
	public ellis() {
		
		duplex.setLanguage("en");
		duplex.addResponseListener(new GSpeechResponseListener() {
			
			public void onResponse(GoogleResponse googleResponse) {
				
				String output = "";
				
				output = googleResponse.getResponse();
				System.out.println(output);
				
				if (output != null) {
					
					makeDecision(output);
					
				} else {
					
					//System.out.println("Output was null");
					
				}
				
			}
		});
		
		//tts.setVoice("cmu-slt-hsmm");
		tts.setVoice("dfki-spike-hsmm");
		startSpeechRecognition();
		
	}
	
	public void makeDecision(String output) {
		
		output = output.trim();
		
		if (!oldText.equals(output)) {
			
			oldText = output;
			
		} else {
			
			return;
			
		}
		
		try {
			
			new features();
			
			if (output.contains("hello")) {
				
				speak("Hello Jacob!");
				
			} else if (output.contains(" + ")) {
				
				speak(doubleToString(features.math(output)));
				
			} else if (output.contains(" - ")) {
				
				speak(doubleToString(features.math(output)));
				
			} else if (output.contains(" * ")) {
				
				speak(doubleToString(features.math(output)));
				
			} else if (output.contains(" / ")) {
				
				speak(doubleToString(features.math(output)));
				
			} else if (output.contains(" ^ ")) {
				
				speak(doubleToString(features.math(output)));
				
			} else if (output.contains("scientific notation")) {
				
				speak(features.stringMath(output));
				
			} else if (output.contains("what time is it")) {
				
				speak(features.calendar(output));
				
			} else if (output.contains("what year is it")) {
				
				speak(features.calendar(output));
				
			} else if (output.contains("what is the date")) {
				
				speak(features.calendar(output));
				
			} else if (output.contains("thank you")) {
				
				Random r = new Random();
				int num = r.nextInt(4);
				
				if (num == 1) {
					
					speak("its my pleasure, sir.");
					
				} else if (num == 2) {
					
					speak("for you sir, always.");
					
				} else if (num == 3) {
					
					speak("of course sir! it is always a pleasure to watch you work.");
					
				}
				
			} else if (output.contains("open") && output.contains("application")) {
				
				speak(features.openPrograms(output));
				
			} else if (output.contains("terminate")) {
				
				terminate();
				
			} else if (output.contains("mute")) {
				
				speak(features.volume(output));
				
			} else if (output.contains("unmute")) {
				
				speak(features.volume(output));
				
			} else if (output.contains("screensaver") || output.contains("resume current session")) {
				
				speak(features.screensaver());
				
			} else if (output.contains("what events do I have") || output.contains("what is on my schedule")) {
				
				speak(features.calendar(output));
				
			} else if (output.contains("what messages do I have")) {
				
				speak(features.email(output));
				
			}
			
		} catch (Exception e) {
			
			System.out.printf("%s: %s", "The error was ", e);
			speak("Unable to process command.");
			
		}
		
	}
	
	public void speak(String text) {
		
		if (!tts.isSpeaking()) {
			
			new Thread(() -> tts.speak(text, 2.0f, true, false)).start();
			
		}
		
	}
	
	public void startSpeechRecognition() {
		
		new Thread(() -> {
			
			try {
				
				duplex.recognize(mic.getTargetDataLine(), mic.getAudioFormat());
				
			} catch (LineUnavailableException | InterruptedException e) { e.printStackTrace(); }
			
		}).start();
		
	}
	
	public void stopSpeechRecognition() {
		
		mic.close();
		
	}
	
	/*
	public static void main(String[] args) {
		
		new ellis();
		
	}*/
	
	public void terminate() {
		
		speak("system terminated");
		System.exit(5);
		
	}
	
	public static String doubleToString(double convert) {
		
		return "" + convert;
		
	}
	
}
//
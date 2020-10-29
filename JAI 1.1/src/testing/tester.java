package testing;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.concurrent.TimeUnit;

public class tester {
	
	public static void main(String... args) throws IOException, GeneralSecurityException, InterruptedException {
		
		Runtime.getRuntime().exec("cmd /c nircmd sendkeypress rwin+5", null, new File("C:\\Users\\jacob\\Downloads\\"));
		TimeUnit.SECONDS.sleep(1);
		Runtime.getRuntime().exec("cmd /c nircmd sendkeypress spc", null, new File("C:\\Users\\jacob\\Downloads\\"));
		TimeUnit.SECONDS.sleep(3);
		Runtime.getRuntime().exec("cmd /c nircmd sendkeypress spc", null, new File("C:\\Users\\jacob\\Downloads\\"));
		
	}
	
}

/*
new googlecalendar();

String events = "";

try {
	
	events = googlecalendar.getEvents();
	
} catch (IOException | GeneralSecurityException e) {
	
	System.out.println("Error.." + e);
	
}

System.out.println(events);

new calendar();

System.out.println(calendar.convertTo12HourTime(events));
*/
/*
new features();
String events = features.calendar("what events do I have");
TimeUnit.SECONDS.sleep(3);
System.out.println(events);
*/

//new gmail();

//System.out.print(gmail.getFlaggedMessages());

//TidalApi api = new TidalApiImpl();

//You have to login before using api
//api.login("jacobstoehrtidal1@gmail.com", "Jacob315");

//List<com.hadas.krzysztof.models.Track> tracks =  api.searchTrack("My track title");
//String trackId = tracks.get(0).getId().toString();
//api.addTrackToFavorite(trackId);
package com.jacob.algorithms;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.repackaged.org.apache.commons.codec.binary.Base64;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.GmailScopes;
import com.google.api.services.gmail.model.Label;
import com.google.api.services.gmail.model.ListLabelsResponse;
import com.google.api.services.gmail.model.ListMessagesResponse;
import com.google.api.services.gmail.model.Message;
import com.google.api.services.gmail.model.MessagePartHeader;

import testing.GmailQuickstart;

public class gmail {

	private static final String APPLICATION_NAME = "Gmail API Java Quickstart";
	private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
	private static final String TOKENS_DIRECTORY_PATH = "tokens";
	private static final List<String> SCOPES = Collections.singletonList(GmailScopes.MAIL_GOOGLE_COM);
	private static final String CREDENTIALS_FILE_PATH = "/credentials.json";

	private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {

		InputStream in = GmailQuickstart.class.getResourceAsStream(CREDENTIALS_FILE_PATH);

		if (in == null) {

			throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);

		}

		GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));
		GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
				.setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
				.setAccessType("offline")
				.build();

		LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();

		return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");

	}
	/*
	public static void sendMessage() throws MessagingException, IOException {
		
		final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
		Gmail service = new Gmail.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
				.setApplicationName(APPLICATION_NAME)
				.build();

		String user = "me";
		
		////////
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);
		
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		////////
		
		MimeMessage email = new MimeMessage(session);
		
		Message message = createMessageWithEmail(email);
		message = service.users().messages().send(user, message).execute();
		
		System.out.println("Message id: " + message.getId());
		System.out.println(message.toPrettyString());
		
	}
	
	public static Message createMessageWithEmail(MimeMessage email) throws MessagingException, IOException {
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		email.writeTo(baos);
		
		String encodedEmail = Base64.encodeBase64URLSafeString(baos.toByteArray());
		Message message = new Message();
		message.setRaw(encodedEmail);
		
		return message;
		
	}
	*/
	public static String getFlaggedMessages() throws GeneralSecurityException, IOException {

		final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
		Gmail service = new Gmail.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
				.setApplicationName(APPLICATION_NAME)
				.build();

		String user = "me";

		List<String> labelIds = new ArrayList<String>();
		labelIds.add("CATEGORY_PERSONAL");
		List<Message> strIds = gmail.listMessagesWithLabels(service, user, labelIds);
		List<String> messageIds = getMessageIds(strIds);
		List<Message> messages = new ArrayList<>();

		int i = 0;
		for (String msgId : messageIds) {

			if (i < 3) {

				messages.add(gmail.getMessage(service, user, msgId));
				i++;

			} else {

				break;

			}

		}

		String flagged = "";
		List<String> subject = new ArrayList<>();
		List<String> unformatedSender = new ArrayList<>();

		for (Message message : messages) {

			for (MessagePartHeader header : message.getPayload().getHeaders()) {

				if (header.getName().contains("Subject")) {

					//System.out.printf("- %s: %s\n", header.getName(), header.getValue());
					subject.add(header.getValue());

				}

				if (header.getName().contains("From")) {

					//System.out.printf("- %s: %s\n", header.getName(), header.getValue());
					unformatedSender.add(header.getValue());

				}

			}

		}

		List<String> sender = formatSender(unformatedSender);

		for (int k = 0; k < 3; k++) {

			flagged += String.format("%s: %s. %s: %s.\n", "The current message is sent from", sender.get(k), "The subject of the message is", subject.get(k));

		}

		return flagged;

	}
	
	private static List<String> formatSender(List<String> sender) {

		List<String> formatedSenders = new ArrayList<>();

		for (String sdr : sender) {

			if (sdr.indexOf("<") != -1) {

				int i1 = sdr.indexOf("<");
				int i2 = sdr.indexOf(">");
				sdr = sdr.substring(i1 + 1, i2);

			}

			formatedSenders.add(sdr);

		}

		return formatedSenders;

	}
	
	public static void main(String... args) throws IOException, GeneralSecurityException {

		final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
		Gmail service = new Gmail.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
				.setApplicationName(APPLICATION_NAME)
				.build();

		String user = "me";
		ListLabelsResponse listResponse = service.users().labels().list(user).execute();
		List<Label> labels = listResponse.getLabels();

		if (labels.isEmpty()) {

			System.out.println("No labels found.");

		} else {

			System.out.println("Labels:");

			for (Label label : labels) {

				System.out.printf("- %s\n", label.getName());

			}

		}

		//getMessageSubjects();

		/////////////////////////////////////
		/*
		List<String> labelIds = new ArrayList<String>();
		labelIds.add("IMPORTANT");
		List<Message> messages = gmail.listMessagesWithLabels(service, user, labelIds);

		for (Message msg : messages) {

			System.out.println(msg);

		}

		List<String> msgIds = getMessageIds(messages);
		for (String id : msgIds) {

			System.out.printf("%s: %s\n", "Email Id", id);

		}
		 */

		//////// Uncomment if you want to see the labels listed out in "pretty string" format
		//listLabels(service, user);
		////////

		List<String> labelIds = new ArrayList<String>();
		labelIds.add("CATEGORY_PERSONAL");
		List<Message> strIds = gmail.listMessagesWithLabels(service, user, labelIds);
		List<String> messageIds = getMessageIds(strIds);
		List<Message> messages = new ArrayList<>();

		int i = 0;
		for (String msgId : messageIds) {

			if (i < 3) {

				messages.add(gmail.getMessage(service, user, msgId));
				i++;

			} else {

				break;

			}

		}

		for (Message message : messages) {

			for (MessagePartHeader header : message.getPayload().getHeaders()) {

				if (header.getName().contains("Subject")) {

					System.out.printf("- %s: %s\n", header.getName(), header.getValue());

				}

			}

		}

	}

	public static List<String> compileMessages(List<Message> messages) {

		List<String> formatedMessages = new ArrayList<>();

		for (Message msg : messages) {

			formatedMessages.add(msg.toString());

		}

		return formatedMessages;

	}

	public static Message getMessage(Gmail service, String userId, String messageId) throws IOException {
		/*
		ListMessagesResponse messageResponse = service.users().messages().list(userId).execute();
		List<Message> messages = messageResponse.getMessages();
		 */
		//Message message = service.users().messages().get(userId, messageId).execute();

		Message message = service.users().messages().get(userId, messageId).setFormat("full").execute();

		return message;
	}

	public static List<String> getMessageIds(List<Message> messages) throws IOException {

		List<String> ids = new ArrayList<String>();
		List<String> msgs = new ArrayList<String>();

		for (Message msg : messages) {

			msgs.add(msg.toPrettyString());

		}

		for (String msg : msgs) {

			String temp = msg.substring(13, 29);
			ids.add(temp);

		}

		return ids;

	}

	public static void listLabels(Gmail service, String userId) throws IOException {

		ListLabelsResponse response = service.users().labels().list(userId).execute();
		List<Label> labels = response.getLabels();

		for (Label label : labels) {

			System.out.println(label.toPrettyString());

		}

	}

	public static void getLabel(Gmail service, String userId, String labelId) throws IOException {

		Label label = service.users().labels().get(userId, labelId).execute();

		System.out.println("Label " + label.getName() + " retrieved.");
		System.out.println(label.toPrettyString());

	}
	/*
	public static void getMessageSubjects() throws IOException, GeneralSecurityException {

		final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
		Gmail service = new Gmail.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
				.setApplicationName(APPLICATION_NAME)
				.build();

		String user = "me";
		ListMessagesResponse messageResponse = service.users().messages().list(user).execute();
		List<Message> messages = messageResponse.getMessages();
		List<String> msgs = new ArrayList<String>();;
		int i = 0;

		if (messages.isEmpty()) {

			System.out.println("No messages found.");

		} else {

			System.out.println("Messages:");

			for (Message message : messages) {

				//System.out.printf("- %s\n", StringUtils.newStringUtf8(Base64.decodeBase64(message.getRaw())));
				//System.out.printf("- %s\n", com.google.api.services.gmail.model.Message.getContent(message));

				Message msg = service.users().messages().get(user, message.getId()).setFormat("full").execute();
				//Message $msg = service.users().messages().get(user, "IMPORTANT").setFormat("full").execute();

				for (MessagePartHeader header : msg.getPayload().getHeaders()) {

					if (/*header.getName().contains("Date") || header.getName().contains("From") || header.getName().contains("To") || header.getName().contains("Subject")) {

						if (i < 3) {

							System.out.printf("- %s: %s\n", header.getName(), header.getValue());
							i++;

						} else {

							break;

						}

						//System.out.printf("- %s: %s\n", header.getName(), header.getValue());

						if (i < 10) {

							msgs.add(String.format("- %s: %s\n", header.getName(), header.getValue()));
							i++;

						}

					}

				}

				if (i >= 3) {

					break;

				}

			}

		}

		for (String s : msgs) {

			System.out.println(s);

		}

	}
	 */
	public static List<Message> listMessagesWithLabels(Gmail service, String userId, List<String> labelIds) throws IOException {

		ListMessagesResponse response = service.users().messages().list(userId).setLabelIds(labelIds).execute();

		List<Message> messages = new ArrayList<Message>();

		while (response.getMessages() != null) {

			messages.addAll(response.getMessages());

			if (response.getNextPageToken() != null) {

				String pageToken = response.getNextPageToken();
				response = service.users().messages().list(userId).setLabelIds(labelIds).setPageToken(pageToken).execute();

			} else {

				break;

			}

		}

		return messages;

	}

}

/*
		for (Message message : messages) {

			System.out.println(message.toPrettyString());

		}


		return messages;

	}

}

/* // Displaying Message Body as a Plain Text
for (MessagePart msgPart : msg.getPayload().getParts()) {
if (msgPart.getMimeType().contains("text/plain"))
  System.out.println(new String(Base64.decodeBase64(msgPart.getBody().getData())));
}
// Displaying Message Header Information
				for (MessagePartHeader header : msg.getPayload().getHeaders()) {
				  if (header.getName().contains("Date") || header.getName().contains("From") || header.getName().contains("To")
				      || header.getName().contains("Subject"))
				    System.out.println(header.getName() + ":" + header.getValue());
				}*/
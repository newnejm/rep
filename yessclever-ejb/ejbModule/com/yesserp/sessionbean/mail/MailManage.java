package com.yesserp.sessionbean.mail;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.URLName;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.yesserp.domain.mail.Provider;

/**
 * Session Bean implementation class MailManage
 */
@Stateless
@LocalBean
public class MailManage implements MailManageLocal {

	@EJB
	MailCRUDLocal ejb;

	List<Provider> lprovider;

	public MailManage() {

	}

	@Override
	public void sendMessage(String from, String password, String subject,
			String text, String destinataire, String uri) {

		lprovider = ejb.consulter();

		// 1 -> Création de la session

		Properties properties = new Properties();
		properties.setProperty("mail.transport.protocol", "smtp");
		System.out.println("****************************"
				+ lprovider.get(3).getSMTP());
		properties.setProperty("mail.smtp.host", lprovider.get(0).getSMTP());
		properties.setProperty("mail.smtp.user", from);
		properties.setProperty("mail.smtp.starttls.enable", "true");
		Session session = Session.getInstance(properties);
		// session.setDebug(true);// enable debuggin

		// 2 -> Création du message

		MimeMessage message = new MimeMessage(session);
		try {
			// message.setText(text);
			System.out.println("**************** before aadd contet");
			MimeMultipart mimeMultipart = this.addContent(uri, text);
			System.out.println("**************** after aadd contet");
			message.setContent(mimeMultipart);
			message.setSubject(subject);
			message.addRecipients(Message.RecipientType.TO, destinataire);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		// 3 -> Envoi du message

		System.out.println("**************** before trasnport");
		Transport transport = null;
		try {
			transport = session.getTransport("smtp");
			transport.connect(from, password);
			System.out.println("**************** before nw Internet adress");
			transport.sendMessage(message, new Address[] { new InternetAddress(
					destinataire) });
			System.out.println("**************** after nw Internet adress");
		} catch (MessagingException e) {
			e.printStackTrace();
		} finally {
			try {
				if (transport != null) {
					transport.close();
				}
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void receiveMessage(String user, String password) {

		lprovider = ejb.consulter();

		// 1 -> La session (using IMAP)
		//
		// Properties properties = new Properties();
		// properties.setProperty("mail.store.protocol", "imap");
		// properties.setProperty("mail.imap.host", "mail.yess-consulting.com");
		// // lprovider.get(3).getIMAP()
		// properties.setProperty("mail.imap.user", user);
		// properties.setProperty("mail.imap.starttls.enable", "true");
		// // properties.setProperty("mail.imap.port", "993");
		// // THIS IS THE MOST IMPORTANT PROP --> "mail.smtps.auth"
		// properties.setProperty("mail.imap.auth", "true");
		// properties.setProperty("mail.pop3s.keepmessagecontent", "true");
		// Session session = Session.getInstance(properties);

		// session.setDebug(true); // enable debuggin

		// 1 -> La session (using POP3)

		Properties properties = new Properties();
		properties.setProperty("mail.store.protocol", "pop3");
		properties.setProperty("mail.pop3.host", "mail.yess-consulting.com");
		properties.setProperty("mail.pop3.user", user); //
		// properties.setProperty("mail.pop3.starttls.enable", "true"); //
		properties.setProperty("mail.pop3.port", "110");
		// THIS IS THE MOST IMPORTANT PROP --> "mail.smtps.auth"
		properties.setProperty("mail.pop3.auth", "true"); //
		properties.setProperty("mail.pop3s.keepmessagecontent", "true");
		Session session = Session.getInstance(properties);
		// session.setDebug(true);

		// 2 -> Les dossiers
		Store store = null;
		Folder defaultFolder = null;
		Folder inbox = null;
		Folder Sent = null;
		try {
			// using IMAP

			// store = session.getStore(new URLName("imaps://"
			// + lprovider.get(1).getIMAP()));

			// using POP3
			store = session.getStore(new URLName("pop3://"
					+ "mail.yess-consulting.com"));

			store.connect(user, password);
			defaultFolder = store.getDefaultFolder();
			System.out.println("defaultFolder : " + defaultFolder.getName());
			for (Folder folder : defaultFolder.list()) {
				System.out
						.println("*******************folder List*******************"
								+ folder.getName());
			}
			inbox = defaultFolder.getFolder("INBOX");
			// Sent = defaultFolder.getFolder("Sent");
			printMessages(inbox);
			// printMessages(Sent);
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // Ne pas oublier de fermer tout ça !
			close(inbox);
			close(defaultFolder);
			try {
				if (store != null && store.isConnected()) {
					store.close();
				}
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}
	}

	private void printMessages(Folder folder) {

		try {
			folder.open(Folder.READ_WRITE);// READ_ONLY
			int count = folder.getMessageCount();
			int unread = folder.getUnreadMessageCount();
			System.out.println("Il y a " + count + " messages, dont " + unread
					+ " non lus.");
			for (int i = 1; i <= count; i++) {
				Message message = folder.getMessage(i);
				//
				if (message.isMimeType("multipart/mixed")) {
					printMixedMessage(message);
				} else {
					printTextMessage(message, i);
				}
				//
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void printTextMessage(Message message, int i) {
		try {
			System.out.println("Message n° " + i);
			System.out.println("Sujet : " + message.getSubject());
			System.out.println("Expéditeur : ");
			Address[] addresses = message.getFrom();
			for (Address address : addresses) {
				System.out.println("\t" + address);
			}
			System.out.println("Destinataires : ");
			addresses = message.getRecipients(RecipientType.TO);
			if (addresses != null) {
				for (Address address : addresses) {
					System.out.println("\tTo : " + address);
				}
			}
			addresses = message.getRecipients(RecipientType.CC);
			if (addresses != null) {
				for (Address address : addresses) {
					System.out.println("\tCopie : " + address);
				}
			}
			System.out.println("Content : ");
			BufferedReader Breader = inputStreamToStrings(message
					.getInputStream());
			while (true) {
				String line = Breader.readLine();
				if (line == null)
					break;
				else
					System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// fin test

	public void printMixedMessage(Message message) {

		try {
			DataSource dataSource = message.getDataHandler().getDataSource();
			MimeMultipart mimeMultipart = new MimeMultipart(dataSource);
			int multiPartCount = mimeMultipart.getCount();
			System.out.println("Il y a " + multiPartCount
					+ " partie(s) dans ce message.");
			for (int i = 0; i < multiPartCount; i++) {
				BodyPart bp = mimeMultipart.getBodyPart(i);
				processBodyPart(bp);
			}
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	private void processBodyPart(BodyPart bp) {

		try {
			System.out.println("Type : " + bp.getContentType());
			String fileName = bp.getFileName();
			System.out.println("FileName : " + fileName);
			if (bp.isMimeType("text/plain")) {
				System.out.println("Content : ");
				BufferedReader Breader = inputStreamToStrings(bp
						.getInputStream());
				while (true) {
					String line = Breader.readLine();
					if (line == null)
						break;
					else
						System.out.println(line);
				}
			} else {
				DataHandler dh = bp.getDataHandler();
				File file = new File("/home/omar/received2_" + fileName);
				FileOutputStream fos = new FileOutputStream(file);
				dh.writeTo(fos);
			}
		} catch (MessagingException | IOException e) {
			e.printStackTrace();
		}
	}

	private static BufferedReader inputStreamToStrings(InputStream inputStream) {
		Charset charset = Charset.forName("iso-8859-1");
		InputStreamReader Ireader = new InputStreamReader(inputStream, charset);
		BufferedReader Breader = new BufferedReader(Ireader);
		return Breader;
	}

	private static void close(Folder folder) {
		if (folder != null && folder.isOpen()) {
			try {
				folder.close(false); // false -> On n'efface pas les messages
										// marqués DELETED
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// add content(text,picture,mp3)
	private MimeMultipart addContent(String uri, String text) {

		System.out.println("************************in add content");
		MimeBodyPart autruche = null;
		if (uri != null) {
			// add image/mp3
			File file = new File(uri);
			FileDataSource datasource1 = new FileDataSource(file);
			DataHandler handler1 = new DataHandler(datasource1);
			autruche = new MimeBodyPart();
			try {
				autruche.setDataHandler(handler1);
				autruche.setFileName(datasource1.getName());
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}
		// add text
		MimeBodyPart content = new MimeBodyPart();
		try {
			content.setContent(text, "text/plain");
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		MimeMultipart mimeMultipart = new MimeMultipart();
		try {
			mimeMultipart.addBodyPart(content);
			if (uri != null) {
				mimeMultipart.addBodyPart(autruche);
			}
			// mimeMultipart.addBodyPart(musique);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return mimeMultipart;
	}
}
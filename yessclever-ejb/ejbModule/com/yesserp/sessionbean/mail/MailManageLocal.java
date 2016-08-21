package com.yesserp.sessionbean.mail;

import javax.ejb.Local;

@Local
public interface MailManageLocal {

	void sendMessage(String from, String password, String subject, String text,
			String destinataire, String uri);

	void receiveMessage(String user, String password);

}

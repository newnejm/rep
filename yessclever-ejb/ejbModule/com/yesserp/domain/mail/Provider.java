package com.yesserp.domain.mail;

import java.io.Serializable;
import java.lang.String;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Provider
 * 
 */
@Entity
@Table(name = "mail_provider")
public class Provider implements Serializable {

	private int id;
	private String name;
	private String SMTP;
	private String IMAP;
	private String POP3;
	private static final long serialVersionUID = 1L;

	public Provider() {
		super();
	}

	public Provider(String name, String SMTP, String IMAP, String POP3) {
		this.name = name;
		this.SMTP = SMTP;
		this.IMAP = IMAP;
		this.POP3 = POP3;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(unique = true)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSMTP() {
		return this.SMTP;
	}

	public void setSMTP(String SMTP) {
		this.SMTP = SMTP;
	}

	public String getIMAP() {
		return this.IMAP;
	}

	public void setIMAP(String IMAP) {
		this.IMAP = IMAP;
	}

	public String getPOP3() {
		return POP3;
	}

	public void setPOP3(String pOP3) {
		POP3 = pOP3;
	}

}

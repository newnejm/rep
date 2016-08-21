package com.yesserp.sessionbean.ga.mail;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.ga.Mail;

@Local
public interface GestionMailLocal {
	public void ajouterMail(Mail mail);

	public void supprimerMail(Mail mail);

	public void modifierMail(Mail mail);

	public Mail trouverParId(Long id);

	public List<Mail> trouverMailsParIdentite(Identite identite);
}

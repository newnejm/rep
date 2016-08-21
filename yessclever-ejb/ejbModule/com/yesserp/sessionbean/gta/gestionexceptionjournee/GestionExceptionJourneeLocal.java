package com.yesserp.sessionbean.gta.gestionexceptionjournee;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.gta.Exceptionjournee;

@Local
public interface GestionExceptionJourneeLocal {

	public void ajouterExceptionjournee(Exceptionjournee exceptionjournee);

	public void supprimerExceptionjournee(Exceptionjournee exceptionjournee);

	public void modifierExceptionjournee(Exceptionjournee exceptionjournee);

	public Exceptionjournee findExceptionjourneeById(int id);

	public List<Exceptionjournee> findAllExceptionjournee();

	public List<Exceptionjournee> findJourneFromException(Identite identite);
}

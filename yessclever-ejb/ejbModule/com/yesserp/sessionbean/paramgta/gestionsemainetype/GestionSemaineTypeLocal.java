package com.yesserp.sessionbean.paramgta.gestionsemainetype;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.gtaparam.CodeJour;
import com.yesserp.domain.gtaparam.CycleTravail;
import com.yesserp.domain.gtaparam.JourneeType;
import com.yesserp.domain.gtaparam.SemaineType;

@Local
public interface GestionSemaineTypeLocal {
	public void ajouterSemaineType(SemaineType semaineType);

	public void modifierSemaineType(SemaineType semaineType);

	public void supprimerSemaineType(SemaineType semaineType);

	public List<SemaineType> listeSemaineType();

	public void affectJourneeTypesTosemaineType(SemaineType semaineType,
			List<JourneeType> journeeTypes);

	public SemaineType trouverSemaineParCode(String code);

	public List<SemaineType> findSemaineTypeForCycle(CycleTravail cycleTravail);

	public void ajouterDesJourneesPourSemaineAvecCodeJour(
			SemaineType semaineType, JourneeType journeeType, CodeJour codeJour);

	public JourneeType trouverJourneParCodeJourEtSemaineType(
			SemaineType semaineType, CodeJour codeJour);

	public List<JourneeType> trouverJourneesParSemaine(SemaineType semaineType);

	public SemaineType findSemaineByID(int id);

	public CodeJour trouverCodeParSemaineEtParJourneeType(
			SemaineType semaineType, JourneeType journeeType);

}

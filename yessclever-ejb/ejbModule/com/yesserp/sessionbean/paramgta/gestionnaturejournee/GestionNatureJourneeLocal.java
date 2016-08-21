package com.yesserp.sessionbean.paramgta.gestionnaturejournee;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.gtaparam.NatureJournee;

@Local
public interface GestionNatureJourneeLocal {
	public void ajouterNatureJournee(NatureJournee natureJournee);
	public void modifierNatureJournee(NatureJournee natureJournee);
	public List<NatureJournee> listeNatureJournee();
	public NatureJournee findNatureJourneeByCode(String code);
	public NatureJournee findNatureJourneeById(int id);
}

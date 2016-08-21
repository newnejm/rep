package com.yesserp.sessionbean.paramgta.gestioncodejour;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.gtaparam.CodeJour;
import com.yesserp.domain.gtaparam.Filtre;

@Local
public interface GestionCodeJourLocal {
	public void ajouterCodeJour(CodeJour codeJour);
	public void modifierCodeJour(CodeJour codeJour);
	public void supprimerCodeJour(CodeJour codeJour);
	public List<CodeJour> listeCodeJours();
	public CodeJour findCodeJourByCode(String code);
	public CodeJour findCodeJourById(int id);
	public List<Integer> getCodeJourFromFilter(Filtre f);
	
}

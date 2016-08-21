package com.yesserp.sessionbean.gta.gestioncodecalendrier;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.gta.Calendrier;
import com.yesserp.domain.gta.CodeCalendrier;

@Local
public interface GestionCodeCalendrierLocal {
	//crud
	public void ajouterCodeCalendrier(CodeCalendrier codeCalendrier);

	public void supprimerCodeCalendrier(CodeCalendrier codeCalendrier);

	public void modifierCodeCalendrier(CodeCalendrier codeCalendrier);

	//search
	public CodeCalendrier findCodeCalendrierById(int id);
	public List<CodeCalendrier> findAllCodeCalendriers();
	public CodeCalendrier trouverCodeParCode(String code);
	public List<Calendrier> trouverJoursFerierParCalendrier(CodeCalendrier calendrier);
	


}

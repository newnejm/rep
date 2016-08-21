package com.yesserp.sessionbean.gta.gestionOccurence;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.gta.ContratGta;

@Local
public interface GestionOccurenceLocal {
	public void ajouterOccurence(ContratGta ContratGta);
	public void supprimerOccurence(ContratGta ContratGta);
	public void modifierOccurence(ContratGta ContratGta);
	public ContratGta findOccurenceById(int id);
	public List<ContratGta> findAllOccurences();
	public List<ContratGta> findAllContratById(int id);
	public List<ContratGta> findAllContratByIdentite(Identite identite);
	public ContratGta findContratByIdentite(Identite identite);
	
	public List<Identite> trouverEmployeesGereParLaGTA(boolean gere);
	
}

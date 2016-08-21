package com.yesserp.sessionbean.paramgta.gestionactiviteabsence;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.gtaparam.ActiviteAbsence;
import com.yesserp.domain.gtaparam.Filtre;
import com.yesserp.domain.gtaparam.GroupeActivite;

@Local
public interface GestionActiviteAbsenceLocal {
	public void ajouterActiviteAbsence(ActiviteAbsence activiteAbsence);

	public void modifierActiviteAbsence(ActiviteAbsence activiteAbsence);

	public void supprimerActiviteAbsence(ActiviteAbsence activiteAbsence);

	public ActiviteAbsence findActiviteAbsenceById(int id);

	public ActiviteAbsence findActiviteAbsenceByCode(String code);

	public List<ActiviteAbsence> listerActiviteAbsence();

	public List<ActiviteAbsence> getActivieAbsenceParFilter(Filtre f);

	public List<ActiviteAbsence> getActiviteAbsencesParGroupe(GroupeActivite ga);

	public List<ActiviteAbsence> getActiviteAbsencesNotInGroupe(
			GroupeActivite groupeActivite);

	public List<ActiviteAbsence> findAll();
	
	
	public List<String> findALLCode();
	
	
	
//	public List<ActiviteAbsence> findByGroupeActivite(GroupeActivite groupeActivite);
}

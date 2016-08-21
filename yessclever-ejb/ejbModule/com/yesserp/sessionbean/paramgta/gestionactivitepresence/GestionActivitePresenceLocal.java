package com.yesserp.sessionbean.paramgta.gestionactivitepresence;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.gtaparam.ActivitePresence;
import com.yesserp.domain.gtaparam.GroupeActivite;

@Local
public interface GestionActivitePresenceLocal {

	public void ajouterActivitePresence(ActivitePresence activitePresence);

	public void modifierActivitePresence(ActivitePresence activitePresence);

	public void supprimerActivitePresence(ActivitePresence activitePresence);

	public ActivitePresence findActivitePresenceById(int id);

	public ActivitePresence findActivitePresenceByCode(String code);

	public List<ActivitePresence> findAll();

	public List<ActivitePresence> getActivitePresencesNotInGroupe(
			GroupeActivite groupeActivite);

	public List<ActivitePresence> getActivitePresencesParGroupe(
			GroupeActivite groupeActivite);
	
//	public List<ActivitePresence> findByGroupeActivite(GroupeActivite groupeActivite);
}

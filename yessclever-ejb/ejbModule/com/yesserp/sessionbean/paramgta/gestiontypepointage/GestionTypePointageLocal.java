package com.yesserp.sessionbean.paramgta.gestiontypepointage;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.entities.RefPointage;
import com.yesserp.domain.gta.TypePointage;
import com.yesserp.domain.gtaparam.DescJourneeType;

@Local
public interface GestionTypePointageLocal {
	public void ajouterTypePointage(TypePointage typePointage);

	public void modifierTypePointage(TypePointage typePointage);

	public void supprimerTypePointage(TypePointage typePointage);

	public List<TypePointage> findAll();

}

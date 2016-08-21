package com.yesserp.sessionbean.gta.gestionactivitereelsaisie;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.gta.ActiviteReelSaisie;

@Local
public interface GestionActiviteReelSaisieLocal {

	public void ajouterActiviteReelSaisie(ActiviteReelSaisie activiteReelSaisie);

	public void modifierActiviteReelSaisie(ActiviteReelSaisie activiteReelSaisie);

	public void supprimerActiviteReelSaisie(
			ActiviteReelSaisie activiteReelSaisie);

	public List<ActiviteReelSaisie> findAll(Identite identite);

	public List<ActiviteReelSaisie> findByDate(Identite identite, Date date);

	public List<ActiviteReelSaisie> findFromDateToDate(Identite identite,
			Date dateDeb, Date dateFin);

}

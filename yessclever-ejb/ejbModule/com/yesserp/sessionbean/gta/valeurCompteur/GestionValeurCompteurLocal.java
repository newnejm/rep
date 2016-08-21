package com.yesserp.sessionbean.gta.valeurCompteur;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.gta.CalculCompteur;
import com.yesserp.domain.gtaparam.Compteur;
import com.yesserp.domain.gtaparam.ValeurCompteur;

@Local
public interface GestionValeurCompteurLocal {
	public void ajoutervaleurCompteur(ValeurCompteur vc);

	public void supprimervaleurCompteur(ValeurCompteur vc);

	public void modifiervaleurCompteur(ValeurCompteur vc);

	public List<Object[]> rechercheValeurCompteurParCompteur(
			Compteur compteur);

	public List<ValeurCompteur> findAllvaleurCompteur();

	public void supprimerTousLesLignes(Compteur cmp);

	public ValeurCompteur getValeurCompteurParCompteurEtParDate(
			Compteur cmp, Date d);
     

}

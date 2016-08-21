package com.yesserp.sessionbean.paramgta.gestiongroupecompteur;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.gtaparam.GroupeCompteur;
import com.yesserp.domain.gtaparam.GroupeImputation;

@Local
public interface GestionGroupeCompteurLocal {
	public void ajouterGroupeCompteur(GroupeCompteur groupeCompteur) ;

	public void modifierGroupeCompteur(GroupeCompteur groupeCompteur);

	public void supprimerGroupeCompteur(GroupeCompteur groupeCompteur);
	
	public void affecterGroupetoIdentite(Identite identite , GroupeCompteur groupeCompteur, Date dateefet , Date datefin);
	
	//
	public List<GroupeCompteur> trouverGroupesCompteursParIdentite(Identite identite);
	public List<GroupeCompteur> trouverHistoriqueGroupesCompteursParIdentite(Identite identite, int n);
	public List<GroupeCompteur> trouverHistoriqueGroupesCompteursParIdentiteEtDateMin(Identite identite, Date min, int n);
	public List<GroupeCompteur> trouverPremiersHistoriqueGroupesCompteursParIdentiteEtDateMin(Identite identite, Date min, int n);
	public List<GroupeCompteur> trouverHistoriqueGroupesCompteursParIdentiteEtDateMax(Identite identite, Date max, int n);
	public List<GroupeCompteur> trouverHistoriqueGroupesCompteursParIdentiteEtDateMinMax(Identite identite, Date min, Date max, int n);
	public List<GroupeCompteur> trouverPremiersHistoriqueGroupesCompteurssParIdentite(Identite identite, int n);
	
	public Long trouverNombreOccurrencesParIdentite(Identite identite);

	public Long trouverNombreOccurrencesActivesParIdentite(Identite identite);
}

package com.yesserp.sessionbean.paramgta.gestiongroupeactivite;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.gtaparam.GroupeActivite;

@Local
public interface GestionGroupeActiviteLocal {
	public void ajouterGroupeActivite(GroupeActivite groupeActivite);

	public void modifierGroupeActivite(GroupeActivite groupeActivite);

	public List<GroupeActivite> listeGroupeActivite();

	public GroupeActivite findGroupeActiviteByCode(String code);



	public void supprimerGroupeActivite(GroupeActivite i);

	
	public List<GroupeActivite> trouverGroupesActivitesParIdentite(
			Identite identite);

	public List<GroupeActivite> trouverHistoriqueGroupesActivitesParIdentite(
			Identite identite, int n);

	public List<GroupeActivite> trouverHistoriqueGroupesActivitesParIdentiteEtDateMin(
			Identite identite, Date min, int n);

	public List<GroupeActivite> trouverPremiersHistoriqueGroupesActivitesParIdentiteEtDateMin(
			Identite identite, Date min, int n);

	public List<GroupeActivite> trouverHistoriqueGroupesActivitesParIdentiteEtDateMax(
			Identite identite, Date max, int n);

	public List<GroupeActivite> trouverHistoriqueGroupesActivitesParIdentiteEtDateMinMax(
			Identite identite, Date min, Date max, int n);

	public List<GroupeActivite> trouverPremiersHistoriqueGroupesActivitessParIdentite(
			Identite identite, int n);

	public Long trouverNombreOccurrencesParIdentite(Identite identite);

	public Long trouverNombreOccurrencesActivesParIdentite(Identite identite);

}

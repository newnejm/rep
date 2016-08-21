package com.yesserp.sessionbean.ga.experience;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.ga.Experience;
import com.yesserp.domain.ga.Identite;

@Local
public interface GestionExperienceLocal {

	public void ajouterExperience(Experience experience);

	public void supprimerExperience(Experience experience);

	public void modifierExperience(Experience experience);

	public Experience trouverParId(Long id);

	public List<Experience> trouverExperiencesParIdentite(
			Identite identite, int n);

	public List<Experience> trouverExperiencesParIdentiteEtDateMin(
			Identite identite, Date min, int n);

	public List<Experience> trouverPremiersExperiencesParIdentiteEtDateMin(
			Identite identite, Date min, int n);

	public List<Experience> trouverExperiencesParIdentiteEtDateMax(
			Identite identite, Date max, int n);

	public List<Experience> trouverExperiencesParIdentiteEtDateMinMax(
			Identite identite, Date min, Date max, int n);

	public Long trouverNombreOccurrencesParIdentite(Identite identite);

	public List<Experience> trouverPremiersExperiencesParIdentite(
			Identite identite, int n);
	public List<Experience> findAll();
}

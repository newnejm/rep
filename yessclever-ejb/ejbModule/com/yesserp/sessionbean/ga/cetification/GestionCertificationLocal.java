package com.yesserp.sessionbean.ga.cetification;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.ga.Certification;
import com.yesserp.domain.ga.Identite;

@Local
public interface GestionCertificationLocal {
	
	public void ajouterCertification(Certification certification);

	public void supprimerCertification(Certification certification);

	public void modifierCertification(Certification certification);

	public Certification trouverParId(Long id);

	public List<Certification> trouverCertificationsParIdentite(
			Identite identite, int n);

	public List<Certification> trouverCertificationsParIdentiteEtDateMin(
			Identite identite, Date min, int n);

	public List<Certification> trouverPremiersCertificationsParIdentiteEtDateMin(
			Identite identite, Date min, int n);

	public List<Certification> trouverCertificationsParIdentiteEtDateMax(
			Identite identite, Date max, int n);

	public List<Certification> trouverCertificationsParIdentiteEtDateMinMax(
			Identite identite, Date min, Date max, int n);

	public Long trouverNombreOccurrencesParIdentite(Identite identite);

	public List<Certification> trouverPremiersCertificationsParIdentite(
			Identite identite, int n);
	public List<Certification> findAll();
}

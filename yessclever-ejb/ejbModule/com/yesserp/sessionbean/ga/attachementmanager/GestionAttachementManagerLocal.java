package com.yesserp.sessionbean.ga.attachementmanager;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.ga.Affectation;
import com.yesserp.domain.ga.AttachementManager;

@Local
public interface GestionAttachementManagerLocal {

	public void ajouterAttachementManager(AttachementManager attachementManager);

	public void supprimerAttachementManager(
			AttachementManager attachementManager);

	public void modifierAttachementManager(AttachementManager attachementManager);

	public AttachementManager trouverParId(Long id);

	public List<AttachementManager> trouverAttachementsManagersActifsParAffectation(
			Affectation affectation);

	public List<AttachementManager> trouverHistoriqueAttachementsManagersParAffectation(
			Affectation affectation, int n);

	public List<AttachementManager> trouverHistoriqueAttachementsManagersParAffectationEtDateMin(
			Affectation affectation, Date min, int n);

	public List<AttachementManager> trouverPremiersHistoriqueAttachementsManagersParAffectationEtDateMin(
			Affectation affectation, Date min, int n);
	
	public List<AttachementManager> trouverPremiersHistoriqueAttachementsManagersParAffectation(
			Affectation affectation, int n);

	public List<AttachementManager> trouverHistoriqueAttachementsManagersParAffectationEtDateMax(
			Affectation affectation, Date max, int n);

	public List<AttachementManager> trouverHistoriqueAttachementsManagersParAffectationEtDateMinMax(
			Affectation affectation, Date min, Date max, int n);

	public Long trouverNombreOccurrencesParAffectation(Affectation affectation);

	public Long trouverNombreOccurrencesActivesParAffectation(
			Affectation affectation);

}

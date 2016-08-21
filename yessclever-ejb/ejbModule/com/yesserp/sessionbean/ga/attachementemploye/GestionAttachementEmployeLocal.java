package com.yesserp.sessionbean.ga.attachementemploye;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.ga.Affectation;
import com.yesserp.domain.ga.AttachementEmploye;

@Local
public interface GestionAttachementEmployeLocal {

	public void ajouterAttachementEmploye(AttachementEmploye attachementEmploye);

	public void supprimerAttachementEmploye(
			AttachementEmploye attachementEmploye);

	public void modifierAttachementEmploye(AttachementEmploye attachementEmploye);

	public AttachementEmploye trouverParId(Long id);

	public List<AttachementEmploye> trouverAttachementsEmployersActifsParAffectation(
			Affectation affectation);

	public List<AttachementEmploye> trouverHistoriqueAttachementsEmployesParAffectation(
			Affectation affectation, int n);

	public List<AttachementEmploye> trouverHistoriqueAttachementsEmployesParAffectationEtDateMin(
			Affectation affectation, Date min, int n);

	public List<AttachementEmploye> trouverPremiersHistoriqueAttachementsEmployesParAffectationEtDateMin(
			Affectation affectation, Date min, int n);

	public List<AttachementEmploye> trouverHistoriqueAttachementsEmployesParAffectationEtDateMax(
			Affectation affectation, Date max, int n);

	public List<AttachementEmploye> trouverHistoriqueAttachementsEmployesParAffectationEtDateMinMax(
			Affectation affectation, Date min, Date max, int n);

	public Long trouverNombreOccurrencesParAffectation(Affectation affectation);
	
	public Long trouverNombreOccurrencesActivesParAffectation(Affectation affectation);

	public List<AttachementEmploye> trouverPremiersHistoriqueAttachementsEmployesParAffectation(
			Affectation affectation, int nombreSelectEmp);

}

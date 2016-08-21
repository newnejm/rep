package com.yesserp.sessionbean.ga.affectation;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.ga.Affectation;
import com.yesserp.domain.ga.AttachementEmploye;
import com.yesserp.domain.ga.AttachementManager;
import com.yesserp.domain.ga.Embauche;
import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.ga.ImputationGa;

@Local
public interface GestionAffectationLocal {

	public void ajouterAffectation(Affectation affectation);

	public void supprimerAffectation(Affectation affectation);

	public void modifierAffectation(Affectation affectation);

	public List<Affectation> trouverParPoste(String poste);

	public List<Affectation> trouverParUniteOrganisationnelle(
			String uniteOrganisationnelle);

	public Affectation trouverParId(Long id);
public Affectation TrouverFonctionByIdentite(Identite identite);


	public void attacherManager(Affectation affectation,
			AttachementManager attachementManager);
	public void modifierAttachementManager(Affectation affectation,
			AttachementManager attachementManager);

	public void attacherListManagers(Affectation affectation,
			List<AttachementManager> attachementManagers);
	public void modifierAttachementListManagers(Affectation affectation,
			List<AttachementManager> attachementManagers);

	public void ajouterImputationGa(Affectation affectation,
			ImputationGa imputationGa);

	public void modifierImputationGa(Affectation affectation,
			ImputationGa imputationGa);
	public void ajouterListImputationGas(Affectation affectation,
			List<ImputationGa> imputationGas);
	public void modifierListImputationGas(Affectation affectation,
			List<ImputationGa> imputationGas);

	public void attacherEmploye(Affectation affectation,
			AttachementEmploye attachementEmploye);
	
	public void modifierAttachementEmploye(Affectation affectation,
			AttachementEmploye attachementEmploye);
	public void attacherListEmployes(Affectation affectation,
			List<AttachementEmploye> attachementEmployes);
	public void modifierAttachementListEmployes(Affectation affectation,
			List<AttachementEmploye> attachementEmployes);

	public List<Affectation> trouverAffectationsActivesParEmbauche(
			Embauche embauche);

	public List<Affectation> trouverHistoriqueAffectationsParEmbauche(
			Embauche embauche, int n);

	public List<Affectation> trouverHistoriqueAffectationsParEmbaucheEtDateMin(
			Embauche embauche, Date min, int n);

	public List<Affectation> trouverPremiersHistoriqueAffectationsParEmbaucheEtDateMin(
			Embauche embauche, Date min, int n);

	
	public List<Affectation> trouverPremiersHistoriqueAffectationsParEmbauche(
			Embauche embauche, int n);

	public List<Affectation> trouverHistoriqueAffectationsParEmbaucheEtDateMax(
			Embauche embauche, Date max, int n);

	public List<Affectation> trouverHistoriqueAffectationsParEmbaucheEtDateMinMax(
			Embauche embauche, Date min, Date max, int n);

	public Long trouverNombreOccurrencesParEmbauche(Embauche embauche);

	public Long trouverNombreOccurrencesActivesParEmbauche(Embauche embauche);
	public List<Affectation> findAll();
	

}

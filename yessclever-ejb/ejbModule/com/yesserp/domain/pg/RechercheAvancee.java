package com.yesserp.domain.pg;

import java.io.Serializable;
import java.lang.Long;
import java.util.List;

import javax.persistence.*;


/**
 * Entity implementation class for Entity: RechercheAvancee
 *
 */
@Entity
@Table(name = "pg_RechercheAvancee")
@NamedQuery(name = "RechercheAvancee.findAll", query = "SELECT g FROM RechercheAvancee g")
public class RechercheAvancee implements Serializable {

	
	private Long idR;
	private String numMatricule;
	private String nom;
	private String prenom;
	private String sexe;
	private String situationFamiliale;
	private String nationalitePays;
	private List<Age> listIntervallesAge ;
	private String typPieceIdentite;
	private String valeurPieceIdentite;
	private List<DateEmbauche> listIntervallesDateEmbauche;
	private String typeContrat;
	private String niveauDiplome;
	private String typeCertificat;
	private String experiencePoste;
	private String experienceSociete;
	private String poste;
	private String emploi;
	private String uniteOrg;
	
	
	
	private static final long serialVersionUID = 1L;

	public RechercheAvancee() {
		super();
	}   
	
	public String getNumMatricule() {
		return numMatricule;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getIdR() {
		return idR;
	}

	public void setIdR(Long idR) {
		this.idR = idR;
	}

	public void setNumMatricule(String numMatricule) {
		this.numMatricule = numMatricule;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getSituationFamiliale() {
		return situationFamiliale;
	}

	public void setSituationFamiliale(String situationFamiliale) {
		this.situationFamiliale = situationFamiliale;
	}

	public String getNationalitePays() {
		return nationalitePays;
	}

	public void setNationalitePays(String nationalitePays) {
		this.nationalitePays = nationalitePays;
	}

	@OneToMany(mappedBy = "rechercheAvancee", cascade = CascadeType.REMOVE)
	public List<Age> getListIntervallesAge() {
		return listIntervallesAge;
	}

	public void setListIntervallesAge(List<Age> listIntervallesAge) {
		this.listIntervallesAge = listIntervallesAge;
	}

	public String getTypPieceIdentite() {
		return typPieceIdentite;
	}

	public void setTypPieceIdentite(String typPieceIdentite) {
		this.typPieceIdentite = typPieceIdentite;
	}

	public String getValeurPieceIdentite() {
		return valeurPieceIdentite;
	}

	public void setValeurPieceIdentite(String valeurPieceIdentite) {
		this.valeurPieceIdentite = valeurPieceIdentite;
	}

	@OneToMany(mappedBy = "rechercheAvancee", cascade = CascadeType.REMOVE)
	public List<DateEmbauche> getListIntervallesDateEmbauche() {
		return listIntervallesDateEmbauche;
	}

	public void setListIntervallesDateEmbauche(
			List<DateEmbauche> listIntervallesDateEmbauche) {
		this.listIntervallesDateEmbauche = listIntervallesDateEmbauche;
	}

	public String getTypeContrat() {
		return typeContrat;
	}

	public void setTypeContrat(String typeContrat) {
		this.typeContrat = typeContrat;
	}

	public String getNiveauDiplome() {
		return niveauDiplome;
	}

	public void setNiveauDiplome(String niveauDiplome) {
		this.niveauDiplome = niveauDiplome;
	}

	public String getTypeCertificat() {
		return typeCertificat;
	}

	public void setTypeCertificat(String typeCertificat) {
		this.typeCertificat = typeCertificat;
	}

	public String getExperiencePoste() {
		return experiencePoste;
	}

	public void setExperiencePoste(String experiencePoste) {
		this.experiencePoste = experiencePoste;
	}

	public String getExperienceSociete() {
		return experienceSociete;
	}

	public void setExperienceSociete(String experienceSociete) {
		this.experienceSociete = experienceSociete;
	}

	public String getPoste() {
		return poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}

	public String getEmploi() {
		return emploi;
	}

	public void setEmploi(String emploi) {
		this.emploi = emploi;
	}

	public String getUniteOrg() {
		return uniteOrg;
	}

	public void setUniteOrg(String uniteOrg) {
		this.uniteOrg = uniteOrg;
	}
	
   
}

package com.yesserp.domain.gf;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.yesserp.domain.ga.Identite;

/**
 * Entity implementation class for Entity: DemandeFrais
 * 
 */
@Entity
@Table(name = "gf_defrrh01")
public class DemandeFrais implements Serializable {

	private Long id;
	private Date dateDemande;
	private Double montant;
	private Integer duree;
	private String etatDemande;
	private Frais frais = new Frais();
	private ModaliteConsommation modaliteConsommation = new ModaliteConsommation();
	private Remboursement remboursement = new Remboursement();
	private Identite identite = new Identite();
	private String description;
	private Integer quantite;
	private static final long serialVersionUID = 1L;

	public DemandeFrais() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Temporal(TemporalType.DATE)
	public Date getDateDemande() {
		return this.dateDemande;
	}

	public void setDateDemande(Date dateDemande) {
		this.dateDemande = dateDemande;
	}

	public Double getMontant() {
		return this.montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public Integer getDuree() {
		return this.duree;
	}

	public void setDuree(Integer duree) {
		this.duree = duree;
	}

	public String getEtatDemande() {
		return this.etatDemande;
	}

	public void setEtatDemande(String etatDemande) {
		this.etatDemande = etatDemande;
	}

	@ManyToOne
	public Identite getIdentite() {
		return identite;
	}

	public void setIdentite(Identite identite) {
		this.identite = identite;
	}

	@ManyToOne
	public Frais getFrais() {
		return frais;
	}

	public void setFrais(Frais frais) {
		this.frais = frais;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	@ManyToOne
	public ModaliteConsommation getModaliteConsommation() {
		return modaliteConsommation;
	}

	public void setModaliteConsommation(
			ModaliteConsommation modaliteConsommation) {
		this.modaliteConsommation = modaliteConsommation;
	}

	@ManyToOne
	public Remboursement getRemboursement() {
		return remboursement;
	}

	public void setRemboursement(Remboursement remboursement) {
		this.remboursement = remboursement;
	}

}

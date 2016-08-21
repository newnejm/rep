package com.yesserp.domain.ga;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity implementation class for Entity: Contrat
 * 
 */
@Entity
@Table(name = "ga_contrrh01")
public class Contrat implements Serializable {

	private Long id;
	private Date datedebu;
	private Date datefin;
	private Date dateSignature;
	private String nature;
	private String type;
	private String situation;
	private String commentaire;
	private byte[] contratSigne;
	private boolean actif;
	private Embauche embauche;

	private static final long serialVersionUID = 1L;

	public Contrat() {
		super();
		actif = true;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getDatedebu() {
		return this.datedebu;
	}

	public void setDatedebu(Date datedebu) {
		this.datedebu = datedebu;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getDatefin() {
		return this.datefin;
	}

	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}

	@Column(name = "datesign")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDateSignature() {
		return this.dateSignature;
	}

	public void setDateSignature(Date dateSignature) {
		this.dateSignature = dateSignature;
	}

	public String getNature() {
		return this.nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "situatio")
	public String getSituation() {
		return this.situation;
	}

	public void setSituation(String situation) {
		this.situation = situation;
	}

	@Column(name = "commenta")
	public String getCommentaire() {
		return this.commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	@Column(name = "contsign")
	public byte[] getContratSigne() {
		return this.contratSigne;
	}

	public void setContratSigne(byte[] contratSigne) {
		this.contratSigne = contratSigne;
	}

	@ManyToOne
	@JoinColumn(name = "embauche")
	public Embauche getEmbauche() {
		return embauche;
	}

	public void setEmbauche(Embauche embauche) {
		this.embauche = embauche;
	}

	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

}

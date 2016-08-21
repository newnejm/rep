package com.yesserp.domain.crm;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Compagne
 * 
 */
@Entity
@Table(name = "crm_sttsuf02")
public class StatusMarketing {

	private Long idStatus;
	private String Libelle;
	private List<Marketing> marketing;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(Long idStatus) {
		this.idStatus = idStatus;
	}

	public String getLibelle() {
		return Libelle;
	}

	public void setLibelle(String libelle) {
		Libelle = libelle;
	}

	@OneToMany(mappedBy = "status", cascade = CascadeType.ALL)
	public List<Marketing> getMarketing() {
		return marketing;
	}

	public void setMarketing(List<Marketing> marketing) {
		this.marketing = marketing;
	}

}

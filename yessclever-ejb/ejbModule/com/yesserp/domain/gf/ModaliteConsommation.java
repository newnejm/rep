package com.yesserp.domain.gf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: ModaliteConsommation
 * 
 */
@Entity
@Table(name = "gf_modarf01")
public class ModaliteConsommation implements Serializable {

	private Long id;
	private String type;
	private List<Frais> frais;
	private List<DemandeFrais> demandesFrais = new ArrayList<DemandeFrais>();
	private static final long serialVersionUID = 1L;

	public ModaliteConsommation() {
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

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@ManyToMany(mappedBy = "modaliteConsommations")
	public List<Frais> getFrais() {
		return frais;
	}

	public void setFrais(List<Frais> frais) {
		this.frais = frais;
	}

	@OneToMany(mappedBy = "modaliteConsommation")
	public List<DemandeFrais> getDemandesFrais() {
		return demandesFrais;
	}

	public void setDemandesFrais(List<DemandeFrais> demandesFrais) {
		this.demandesFrais = demandesFrais;
	}

}
